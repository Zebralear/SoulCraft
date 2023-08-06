package zebralear.soulcraft.util;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class DamageHandler {
	@SubscribeEvent
	public void chargeFromDamage(LivingHurtEvent playerhurt) {
		
		Player player = (Player) playerhurt.getEntity();
		float damagef = playerhurt.getAmount();
		int damagei = (int) damagef;
		
		return;
	}
}
