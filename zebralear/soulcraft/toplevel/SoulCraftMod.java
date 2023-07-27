package zebralear.soulcraft.toplevel;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import zebralear.soulcraft.ItemRegistry.ModItems;
import zebralear.soulcraft.util.ModMessages;

@Mod(value="soulcraft")
public class SoulCraftMod {
	  public static final String mod_id = "soulcraft";

	public SoulCraftMod() {
		  IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
	ModItems.register(modEventBus);	  
	modEventBus.addListener(this::commonSettup);
	};
	
	private void commonSettup(final FMLCommonSetupEvent event) 
	{
		event.enqueueWork(() ->{
			ModMessages.register();
		});
	  }
	}