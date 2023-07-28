package zebralear.soulcraft.SoulStorage;

import net.minecraft.nbt.CompoundTag;

public class CombatMode {
private int combatMode = 0;
private final int ModeOn = 1;
private final int ModeOff =  0;

public int getCombatMode() {
	return combatMode;
	}

public void setModeOn(int toggler) {
	this.combatMode = Math.min(combatMode + toggler, ModeOn);
	}


public void setModeOff(int toggler) {
	this.combatMode = Math.max(combatMode - toggler, ModeOff);
	}

public void saveNBTData(CompoundTag nbt) {
	nbt.putInt("EntitycombatMode", combatMode);
	}

public void loadNBTData(CompoundTag nbt) {
	combatMode = nbt.getInt("EntitycombatMode");
	}

public void copyFrom(CombatMode source) {
	this.combatMode = source.combatMode;
	}
}


