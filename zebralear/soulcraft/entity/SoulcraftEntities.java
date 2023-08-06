package zebralear.soulcraft.entity;

import java.util.function.BiConsumer;
import java.util.function.Function;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import zebralear.soulcraft.entity.custom.SingleSpearEntity;
import zebralear.soulcraft.libs.EntityResourceLibrary;
import zebralear.soulcraft.toplevel.SoulCraftMod;
// https://youtu.be/62GMA9Yg938?t=534
// tutorial man's code look a lot like the code here, just longer and less straightforward. Ask help to see if that's the case
// https://github.com/VazkiiMods/Botania/blob/1.19.2/Xplat/src/main/java/vazkii/botania/common/entity/BotaniaEntities.java
public final class SoulcraftEntities {
	
		@FunctionalInterface
		public interface ECapConsumer<T> {
			void accept(Function<Entity, T> factory, EntityType<?>... types);
		}
	//this just compiles the entities for register
		//perhaps the name after <SingleSpearEntity> has to be lowercase -> not true
	public static final EntityType<SingleSpearEntity> Single_Spear = EntityType.Builder.<SingleSpearEntity>
	of(SingleSpearEntity::new, MobCategory.MISC)
	.sized(1,1)
	.updateInterval(10)
	.clientTrackingRange(6)
	.build(EntityResourceLibrary.Single_Spear.toString());

public static void registerEntities(BiConsumer<EntityType<?>, ResourceLocation> r) {
	r.accept(Single_Spear, EntityResourceLibrary.Single_Spear);
	}


}