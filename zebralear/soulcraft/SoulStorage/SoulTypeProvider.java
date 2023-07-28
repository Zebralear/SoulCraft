package zebralear.soulcraft.SoulStorage;

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

public class SoulTypeProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<SoulType> Soul_Type = CapabilityManager.get(new CapabilityToken<SoulType>() {});

	private SoulType soulType = null;
	private final LazyOptional<SoulType> optional = LazyOptional.of(this::createSoulType);
	
	private <T> SoulType createSoulType() {
		if(this.soulType == null) {
		this.soulType = new SoulType();
		}
		return this.soulType;	
	}
	
	
	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if(cap == Soul_Type) {
			return optional.cast();
		}
		return LazyOptional.empty();
	}
	
	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createSoulType().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createSoulType().loadNBTData(nbt);
		
	}

}
