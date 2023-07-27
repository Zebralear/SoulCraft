package zebralear.soulcraft.SoulStorage;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import zebralear.soulcraft.networking.UnsetterC2S;
import zebralear.soulcraft.util.ModMessages;
import net.minecraft.core.Direction;


public class SoulHas implements ISoulHas, ICapabilityProvider, INBTSerializable<CompoundTag> {
private int hasSoul = 0;
private final int maxSoul = 1;
private final int minSoul = 0;

//public int getSoulHaver() {
//	return hasSoul;
//	}
//this is what is being run in screenshot one, but does nothing.
public void addSoul(int addtosoul) {
	Minecraft.getInstance().player.sendSystemMessage(Component.literal("addSoulStart"));
	this.hasSoul = Math.min(hasSoul + addtosoul, maxSoul);
	ModMessages.sendToServer(new UnsetterC2S());
	Minecraft.getInstance().player.sendSystemMessage(Component.literal("addSoul Has Run Successfully"));
	}


public void removeSoul(int subfromsoul) {
	this.hasSoul = Math.min(hasSoul - subfromsoul, minSoul);
	SoulType.soulType = 0;
	
	Minecraft.getInstance().player.sendSystemMessage(Component.literal("removeSoul Has Run Successfully"));  
	}

public void saveNBTData(CompoundTag nbt) {
	nbt.putInt("EntityHasSoul", hasSoul);
	}

public void loadNBTData(CompoundTag nbt) {
	nbt.getInt("EntityHasSoul");
	}

public void copyFrom(SoulHas source) {
	this.hasSoul = source.hasSoul;
	}

public static Capability<SoulHas> Soul_Has = CapabilityManager.get(new CapabilityToken<SoulHas>() {
});

private SoulHas soulHas;
private final LazyOptional<SoulHas> optional = LazyOptional.of(this::createSoulHas);

private SoulHas createSoulHas() {
	if(this.soulHas == null) {
	this.soulHas = new SoulHas();
	}
	return this.soulHas;
}

@Override
public CompoundTag serializeNBT() {
	CompoundTag nbt = new CompoundTag();
	createSoulHas().saveNBTData(nbt);
	return nbt;
}

@Override
public void deserializeNBT(CompoundTag nbt) {
	createSoulHas().loadNBTData(nbt);
}
@NonNull
@Override
public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
	if(cap == Soul_Has) {
		return optional.cast();
	}
	return LazyOptional.empty();
	}
}

