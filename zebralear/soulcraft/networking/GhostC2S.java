package zebralear.soulcraft.networking;

import java.util.function.Supplier;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import zebralear.soulcraft.SoulStorage.SoulHasProvider;
import zebralear.soulcraft.SoulStorage.SoulTypeProvider;

public class GhostC2S {
 public GhostC2S() {
 	 }
 
 public GhostC2S(FriendlyByteBuf buf) {
	 }
 
 public void toBytes(FriendlyByteBuf buf) {
	 }
 
 public boolean handle(Supplier<NetworkEvent.Context> supplier) {
	 NetworkEvent.Context context = supplier.get();
	 context.enqueueWork(() -> {
		 //here blows the server
		 ServerPlayer player = context.getSender();
		 ServerLevel level = player.getLevel();
		 player.getCapability(SoulHasProvider.Soul_Has).ifPresent(soulHas -> {
			 var SoulCheck = soulHas.getSoulHaver();
			 player.getCapability(SoulTypeProvider.Soul_Type).ifPresent(soulType -> {
				 var TypeCheck = soulType.getSoulType();
			 if(SoulCheck != 1) {
				 soulHas.addSoul(1);
				 soulType.setType(8);
				 Minecraft.getInstance().player.sendSystemMessage(Component.literal("You slip into the background of reality. Perhaps you can avoid combat, even though you are ready for it."));
			 } else {
				 Minecraft.getInstance().player.sendSystemMessage(Component.literal("Your Soul is already Full! Press USERKEYHERE to enter combat mode!"));
			 }
			
		 });
		});
	 });
	 return true;
 }
}
