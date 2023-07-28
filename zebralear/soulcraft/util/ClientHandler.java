package zebralear.soulcraft.util;


import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import zebralear.soulcraft.networking.CombatKeyC2S;
import zebralear.soulcraft.toplevel.SoulCraftMod;

public class ClientHandler {
	@Mod.EventBusSubscriber(modid = SoulCraftMod.mod_id, value = Dist.CLIENT)
	public static class ClientForgeEvents {

		@SubscribeEvent
		public static void onKeyInput(InputEvent.Key event)
		{
			if(KeyBindings.Combat_Key.consumeClick()) {
			 //  try {
				ModMessages.sendToServer(new CombatKeyC2S());
			//   } catch (NullPointerException npe) {}
			   //catch NPEs (Not needed, left in for use later if more crashes occur
			}
		}
	}
	
	@Mod.EventBusSubscriber(modid = SoulCraftMod.mod_id, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class ClientModBusEvents {
		@SubscribeEvent
		public static void onKeyRegister(RegisterKeyMappingsEvent event) {
			event.register(KeyBindings.Combat_Key);
			}
	}
}
