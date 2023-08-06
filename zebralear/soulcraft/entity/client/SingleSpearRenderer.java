package zebralear.soulcraft.entity.client;

import javax.annotation.Nullable;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoProjectilesRenderer;
import zebralear.soulcraft.entity.custom.SingleSpearEntity;
import zebralear.soulcraft.toplevel.SoulCraftMod;

public class SingleSpearRenderer extends GeoProjectilesRenderer<SingleSpearEntity> {
		public SingleSpearRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new SingleSpearModel());
		this.shadowRadius = 0f;
	}
	public ResourceLocation getTextureResource(SingleSpearEntity instance) {
		return new ResourceLocation(SoulCraftMod.mod_id,  "textures/singlespear.singlespear_texture.json");
	}
		
		@Override
		public RenderType getRenderType(SingleSpearEntity animatable, float partialTicks, PoseStack stack,
				@Nullable MultiBufferSource renderTypeBuffer,
				@Nullable VertexConsumer vertexBuilder, int packedLightIn,
				ResourceLocation textureLocation) {	
			stack.scale(1f, 1f, 1f);
			return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
				}

	}
