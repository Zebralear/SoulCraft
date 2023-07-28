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

public class CombatModeProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<CombatMode> Combat_Mode = CapabilityManager.get(new CapabilityToken<CombatMode>() {});

	private CombatMode CombatMode = null;
	private final LazyOptional<CombatMode> optional = LazyOptional.of(this::createCombatMode);
	
	private <T> CombatMode createCombatMode() {
		if(this.CombatMode == null) {
		this.CombatMode = new CombatMode();
		}
		return this.CombatMode;	
	}
	
	
	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if(cap == Combat_Mode) {
			return optional.cast();
		}
		return LazyOptional.empty();
	}
	
	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createCombatMode().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createCombatMode().loadNBTData(nbt);
		
	}

}
