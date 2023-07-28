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

public class SpecialAttackChargeProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<SpecialAttackCharge> Special_Attack_Charge = CapabilityManager.get(new CapabilityToken<SpecialAttackCharge>() {});

	private SpecialAttackCharge SpecialAttackCharge = null;
	private final LazyOptional<SpecialAttackCharge> optional = LazyOptional.of(this::createSpecialAttackCharge);
	
	private <T> SpecialAttackCharge createSpecialAttackCharge() {
		if(this.SpecialAttackCharge == null) {
		this.SpecialAttackCharge = new SpecialAttackCharge();
		}
		return this.SpecialAttackCharge;	
	}
	
	
	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if(cap == Special_Attack_Charge) {
			return optional.cast();
		}
		return LazyOptional.empty();
	}
	
	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createSpecialAttackCharge().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {

}
}
