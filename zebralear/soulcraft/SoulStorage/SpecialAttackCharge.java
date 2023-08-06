package zebralear.soulcraft.SoulStorage;

import net.minecraft.nbt.CompoundTag;

public class SpecialAttackCharge {
private int chargePercent = 0;
private final int MaxCharge = 100;
private final int MinCharge =  0;

public int getChargePercent() {
	return chargePercent;
	}

public void chargeIncrease(int percentcharger) {
	this.chargePercent = Math.min(chargePercent + percentcharger, MaxCharge);
	}


public void chargeDecrease(int percentcharger) {
	this.chargePercent = Math.max(chargePercent - percentcharger, MinCharge);
	}

public void saveNBTData(CompoundTag nbt) {
	nbt.putInt("EntitychargePercent", chargePercent);
	}

public void loadNBTData(CompoundTag nbt) {
	chargePercent = nbt.getInt("EntitychargePercent");
	}

public void copyFrom(SpecialAttackCharge source) {
	this.chargePercent = source.chargePercent;
	}
}


