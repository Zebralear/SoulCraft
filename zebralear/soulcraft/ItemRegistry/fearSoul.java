package zebralear.soulcraft.ItemRegistry;

import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import zebralear.soulcraft.networking.FearC2S;
import zebralear.soulcraft.util.ModMessages;

public class fearSoul extends Item {

	public fearSoul(Properties properties) {
		super(properties);
	}

	@Override
public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		if(!level.isClientSide && hand == InteractionHand.MAIN_HAND) {
		player.getCooldowns().addCooldown(this, 20);
		ModMessages.sendToServer(new FearC2S());
		}
		return super.use(level, player, hand);
	}
	

}