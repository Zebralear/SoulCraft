package zebralear.soulcraft.SoulStorage;


import org.checkerframework.checker.nullness.qual.NonNull;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.AutoRegisterCapability;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;

@AutoRegisterCapability
public interface ISoulHas {
	public void addSoul(int addtosoul);
	
	public void removeSoul(int subfromsoul) ;

	public void saveNBTData(CompoundTag nbt);

	public void loadNBTData(CompoundTag nbt);

	public void copyFrom(SoulHas source);
	
	public CompoundTag serializeNBT();
	
	public void deserializeNBT(CompoundTag nbt);
	
	@NonNull
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side);
	}
