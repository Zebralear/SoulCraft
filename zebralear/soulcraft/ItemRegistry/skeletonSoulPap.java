package zebralear.soulcraft.ItemRegistry;

import net.minecraft.world.item.Item;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class skeletonSoulPap extends Item {

	public skeletonSoulPap(Properties properties) {
		super(properties);
	}

	@Override
public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		if(!level.isClientSide && hand == InteractionHand.MAIN_HAND) {
		player.getCooldowns().addCooldown(this, 20);
		Minecraft.getInstance().player.sendSystemMessage(Component.literal("Your Soul is filled with the will of a kindhearted, if not foolish individual"));
		}
		return super.use(level, player, hand);
	}
	

}