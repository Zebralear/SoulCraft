package zebralear.soulcraft.SoulStorage;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

//when I boot the game, the NBT doesn't even get added to the player despite this file, and the annotation in the previous screenshot
public class SoulHasProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
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
