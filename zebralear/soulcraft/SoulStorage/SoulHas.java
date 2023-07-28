package zebralear.soulcraft.SoulStorage;

import net.minecraft.nbt.CompoundTag;

public class SoulHas {
private int hasSoul = 0;
private final int maxSoul = 1;
private final int minSoul = 0;

public int getSoulHaver() {
	return hasSoul;
	}

public void addSoul(int addtosoul) {
	this.hasSoul = Math.min(hasSoul + addtosoul, maxSoul);
	}


public void removeSoul(int subfromsoul) {
	this.hasSoul = Math.max(hasSoul - subfromsoul, minSoul);
	}

public void saveNBTData(CompoundTag nbt) {
	nbt.putInt("EntityHasSoul", hasSoul);
	}

public void loadNBTData(CompoundTag nbt) {
	hasSoul = nbt.getInt("EntityHasSoul");
	}

public void copyFrom(SoulHas source) {
	this.hasSoul = source.hasSoul;
	}
}


