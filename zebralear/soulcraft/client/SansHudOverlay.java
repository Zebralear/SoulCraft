package zebralear.soulcraft.client;

import zebralear.soulcraft.toplevel.SoulCraftMod;

import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;


public class SansHudOverlay {
	
	private static final ResourceLocation Charged_Sans_Special = new ResourceLocation(SoulCraftMod.mod_id, "textures/huds/skullblue.png");
	private static final ResourceLocation Uncharged_Sans_Special = new ResourceLocation(SoulCraftMod.mod_id, "textures/huds/skullgrey.png");
	
	public static final IGuiOverlay HUD_SANS = ((gui, poseStack, partialTick, width, height) -> {
		int x = width/2;
		int y = height;
		
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, Uncharged_Sans_Special);
		
		for(int i = 0; i < 1; i++) {
			GuiComponent.blit(poseStack, x-94, y-54, 0, 0, 12, 12, 12, 12);
		}
		/*
		RenderSystem.setShaderTexture(0, Charged_Sans_Special);
		if(ClientSoulData.getSoulType() == 3 && ClientSoulData.getSpecialAttackCharge() == 100) {
			GuiComponent.blit(poseStack, x-94, y-54, 0, 0, 12, 12, 12, 12);
		} else {
			break;
		}
		*/
		
	});
	

}

