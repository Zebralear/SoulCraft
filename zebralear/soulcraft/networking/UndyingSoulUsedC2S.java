package zebralear.soulcraft.networking;

import java.util.function.Supplier;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import zebralear.soulcraft.SoulStorage.SoulHasProvider;

public class UndyingSoulUsedC2S {
 public UndyingSoulUsedC2S() {
 	 }
 
 public UndyingSoulUsedC2S(FriendlyByteBuf buf) {
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
			 //the below line doesn't run or does nothing upon running
			soulHas.addSoul(1);
		 });
			Minecraft.getInstance().player.sendSystemMessage(Component.literal("Soul Added"));
		});
	 return true;
 }
}
