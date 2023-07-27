package zebralear.soulcraft.networking;

import java.util.function.Supplier;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import zebralear.soulcraft.SoulStorage.SoulHas;

public class UnsetterC2S {
 public UnsetterC2S() {
 	 }
 
 public UnsetterC2S(FriendlyByteBuf buf) {
	 }
 
 public void toBytes(FriendlyByteBuf buf) {
	 }
 
 public boolean handle(Supplier<NetworkEvent.Context> supplier) {
	 NetworkEvent.Context context = supplier.get();
	 //here blows the server
	 context.enqueueWork(() -> {
		 ServerPlayer player = context.getSender();
		 ServerLevel level = player.getLevel();

		SoulHas soulHas = new SoulHas();
		String hasSoul = soulHas.toString();
		
		if(hasSoul.equals("true")) {
			Minecraft.getInstance().player.sendSystemMessage(Component.literal("Fuck"));

			}
		
		});
	 return true;
 }
}
