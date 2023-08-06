package zebralear.soulcraft.entity.client;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import zebralear.soulcraft.entity.custom.SingleSpearEntity;
import zebralear.soulcraft.toplevel.SoulCraftMod;

public class SingleSpearModel extends AnimatedGeoModel<SingleSpearEntity>{

	@Override
	public ResourceLocation getAnimationResource(SingleSpearEntity animatable) {
		return new ResourceLocation(SoulCraftMod.mod_id,  "animations/singlespear.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SingleSpearEntity object) {
		return new ResourceLocation(SoulCraftMod.mod_id,  "geo/singlespear.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SingleSpearEntity object) {
		return new ResourceLocation(SoulCraftMod.mod_id,  "textures/singlespear.singlespear_texture.json");
	}

}
