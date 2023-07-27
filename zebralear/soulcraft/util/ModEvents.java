package zebralear.soulcraft.util;



import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import zebralear.soulcraft.SoulStorage.SoulHasProvider;
import zebralear.soulcraft.toplevel.SoulCraftMod;

public class ModEvents {
@SubscribeEvent
public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
	if(event.getObject() instanceof Player) {
		if(!event.getObject().getCapability(SoulHasProvider.Soul_Has).isPresent()) {
			event.addCapability(new ResourceLocation(SoulCraftMod.mod_id, "HasSoul"), new SoulHasProvider());
			}
		}
	}
@SubscribeEvent
public void onPlayerCloned(PlayerEvent.Clone event) {
	if(event.isWasDeath()) {
		event.getOriginal().getCapability(SoulHasProvider.Soul_Has).ifPresent(oldStore -> {
			event.getOriginal().getCapability(SoulHasProvider.Soul_Has).ifPresent(newStore -> {
				newStore.copyFrom(oldStore);
			});
		 });
	}
}
@SubscribeEvent
public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
	event.register(SoulHasProvider.class);
}
}
