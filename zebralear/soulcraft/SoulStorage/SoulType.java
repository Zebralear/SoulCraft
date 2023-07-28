package zebralear.soulcraft.SoulStorage;

import net.minecraft.nbt.CompoundTag;

public class SoulType {
	private int soulType = 0;
	private final int TypeMax = 100;
	private final int TypeMin = 0;
	
	public int getSoulType() {
		return soulType;
		}

	public void setType (int soulTypeAdd) {;
		this.soulType = Math.min(soulType + soulTypeAdd, TypeMax);
		}


	public void deleteType (int soulTypeAdd) {
		this.soulType = Math.max(soulType * soulTypeAdd, TypeMin); 
		}

	public void saveNBTData(CompoundTag nbt) {
		nbt.putInt("EntitySoulType", soulType);
		}

	public void loadNBTData(CompoundTag nbt) {
		soulType = nbt.getInt("EntitySoulType");
		}

	public void copyFrom(SoulType source) {
		this.soulType = source.soulType;
		}
	}