package zebralear.soulcraft.networking;

import java.util.function.Supplier;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import zebralear.soulcraft.SoulStorage.CombatModeProvider;
import zebralear.soulcraft.SoulStorage.SoulHasProvider;
import zebralear.soulcraft.SoulStorage.SoulTypeProvider;

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

		 player.getCapability(SoulHasProvider.Soul_Has).ifPresent(soulHas -> {
			 var SoulCheck = soulHas.getSoulHaver();
			 player.getCapability(SoulTypeProvider.Soul_Type).ifPresent(soulType -> { 
				 var TypeCheck = soulType.getSoulType();
				 player.getCapability(CombatModeProvider.Combat_Mode).ifPresent(combatMode -> { 
					 var CombatCheck = combatMode.getCombatMode(); {
					 }
				 	if(SoulCheck != 0) {
				 		soulHas.removeSoul(1);
				 		if(TypeCheck != 0) {
				 		soulType.deleteType(0);
				 			if(CombatCheck == 1) {
				 				combatMode.setModeOff(1);
				 			}
				 		}
				 		Minecraft.getInstance().player.sendSystemMessage(Component.literal("Soul Successfully Removed!"));
				 	} else {
				 		Minecraft.getInstance().player.sendSystemMessage(Component.literal("No Soul Detected!"));
			 }});
			 });
		 });
	});
	return true;
 }
}
