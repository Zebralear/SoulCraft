package zebralear.soulcraft.toplevel;

import static zebralear.soulcraft.libs.ResourceLocationHelper.prefix;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import zebralear.soulcraft.ItemRegistry.ModItems;
import zebralear.soulcraft.entity.SoulcraftEntities;
import zebralear.soulcraft.entity.client.SingleSpearRenderer;
import zebralear.soulcraft.libs.ResourceLocationHelper;
import zebralear.soulcraft.util.ModMessages;
import software.bernie.geckolib3.GeckoLib;

@Mod(value="soulcraft")
public class SoulCraftMod {
	  public static final String mod_id = "soulcraft";

	public SoulCraftMod() {
		  IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
	ModItems.register(modEventBus);
	GeckoLib.initialize();


	
	
	modEventBus.addListener(this::commonSettup);
	};
	
	private void commonSettup(final FMLCommonSetupEvent event) 
	{
		event.enqueueWork(() ->{
			ModMessages.register();
			System.out.println(prefix("SingleSpearEntitiy"));
			System.exit(0);
		});
	  }
	
	@Mod.EventBusSubscriber(modid = mod_id, bus = Mod.EventBusSubscriber.Bus.MOD)
		public static class ClientModEvents {
	@SubscribeEvent
	public static void onClientSetup(FMLClientSetupEvent event) {
		EntityRenderers.register(SoulcraftEntities.Single_Spear, SingleSpearRenderer::new);
	}
		}
	
	}