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

public class CombatKeyC2S {
	
 public CombatKeyC2S() {
 	 }
 
 public CombatKeyC2S(FriendlyByteBuf buf) {
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
			 
		 player.getCapability(SoulTypeProvider.Soul_Type).ifPresent(soulType -> {
		 player.getCapability(CombatModeProvider.Combat_Mode).ifPresent(combatMode -> {
			var SoulCheck = soulHas.getSoulHaver();
			var CombatCheck = combatMode.getCombatMode();
			var TypeCheck = soulType.getSoulType();
	
			// looks to see if player is in combat mode; these are for not, and sets it to true with some flavor text in chat
			if(SoulCheck == 1 && CombatCheck == 0) {
			switch(TypeCheck) {
			case 1:
				 Minecraft.getInstance().player.sendSystemMessage(Component.literal("You raise your spears."));
				 combatMode.setModeOn(1);
				 break;
			case 2:
				 Minecraft.getInstance().player.sendSystemMessage(Component.literal("A hunger overcomes you. Time to entangle your prey."));
				 combatMode.setModeOn(1);
				 break;
			case 3:
				 Minecraft.getInstance().player.sendSystemMessage(Component.literal("You simply cannot sit back any longer."));
				 combatMode.setModeOn(1);
				 break;
			case 4:
				//maybe use some math.rand here to make the occasional spamton reference
				 Minecraft.getInstance().player.sendSystemMessage(Component.literal("The show begins!"));
				 combatMode.setModeOn(1);
				 break;
			case 5:
				 Minecraft.getInstance().player.sendSystemMessage(Component.literal("You must protect them from this creul world."));
				 combatMode.setModeOn(1);
				 break;
			case 6:
				 Minecraft.getInstance().player.sendSystemMessage(Component.literal("Time to become all you were meant to be!"));
				 combatMode.setModeOn(1);
				 break;
			case 7:
				 Minecraft.getInstance().player.sendSystemMessage(Component.literal("You can't look them in the eye, but this must happen."));
				 combatMode.setModeOn(1);
				 break;
			case 8:
			 	Minecraft.getInstance().player.sendSystemMessage(Component.literal("Oh well..."));
			 	combatMode.setModeOn(1);
			 	break;
			case 9:
				 Minecraft.getInstance().player.sendSystemMessage(Component.literal("Time to get revenge for all they did to you."));
				 combatMode.setModeOn(1);
				 break;
			case 10:
				 Minecraft.getInstance().player.sendSystemMessage(Component.literal("Time to show them what real fear is..."));
				 combatMode.setModeOn(1);
				 break;
			case 11:
				 Minecraft.getInstance().player.sendSystemMessage(Component.literal("Your determination surges!"));
				 combatMode.setModeOn(1);
				 break;
			case 12:
				 Minecraft.getInstance().player.sendSystemMessage(Component.literal("You can brave this fight!"));
				 combatMode.setModeOn(1);
				 break;
			case 13:
				 Minecraft.getInstance().player.sendSystemMessage(Component.literal("Your integrity fuels you to do what is right!"));
				 combatMode.setModeOn(1);
				 break;
			case 14:
				 Minecraft.getInstance().player.sendSystemMessage(Component.literal("Justice spurs you on!"));
				 combatMode.setModeOn(1);
				 break;
			case 15:
				 Minecraft.getInstance().player.sendSystemMessage(Component.literal("Kindness will surely prevail!"));
				 combatMode.setModeOn(1);
				 break;
			case 16:
				 Minecraft.getInstance().player.sendSystemMessage(Component.literal("With patience, you can defeat any foe."));
				 combatMode.setModeOn(1);
				 break;
			case 17:
				 Minecraft.getInstance().player.sendSystemMessage(Component.literal("You will persevere through this fight!"));
				 combatMode.setModeOn(1);
				 break;
			case 99:
				 Minecraft.getInstance().player.sendSystemMessage(Component.literal("Time to test some new weapons."));
				 combatMode.setModeOn(1);
				 break;
			}
			} else {
				if(SoulCheck == 1 && CombatCheck == 1) {
					// looks to see if player is in combat mode; these are for are, and sets it to false with some flavor text in chat
					switch(TypeCheck) {
					case 1:
						 Minecraft.getInstance().player.sendSystemMessage(Component.literal("You lower your spears."));
						 combatMode.setModeOff(1);
						 break;
					case 2:
						 Minecraft.getInstance().player.sendSystemMessage(Component.literal("What a delicious meal~"));
						 combatMode.setModeOff(1);
						 break;
					case 3:
						 Minecraft.getInstance().player.sendSystemMessage(Component.literal("That'll teach 'em"));
						 combatMode.setModeOff(1);
						 break;
					case 4:
						//maybe use some math.rand here to make the occasional spamton reference
						 Minecraft.getInstance().player.sendSystemMessage(Component.literal("And that concludes a wonderful episode!"));
						 combatMode.setModeOff(1);
						 break;
					case 5:
						 Minecraft.getInstance().player.sendSystemMessage(Component.literal("Time to dust off and make some pie!"));
						 combatMode.setModeOff(1);
						 break;
					case 6:
						 Minecraft.getInstance().player.sendSystemMessage(Component.literal("Now they will surely recognize you!"));
						 combatMode.setModeOff(1);
						 break;
					case 7:
						 Minecraft.getInstance().player.sendSystemMessage(Component.literal("It is done."));
						 combatMode.setModeOff(1);
						 break;
					case 8:
					 	Minecraft.getInstance().player.sendSystemMessage(Component.literal("Oh well..."));
					 	combatMode.setModeOff(1);
					 	break;
					case 9:
						 Minecraft.getInstance().player.sendSystemMessage(Component.literal("That was fun, wasn't it..."));
						 combatMode.setModeOff(1);
						 break;
					case 10:
						//make that italic later
						 Minecraft.getInstance().player.sendSystemMessage(Component.literal("Maniacal laughter"));
						 combatMode.setModeOff(1);
						 break;
					case 11:
						 Minecraft.getInstance().player.sendSystemMessage(Component.literal("Determination triumphs, as always"));
						 combatMode.setModeOff(1);
						 break;
					case 12:
						 Minecraft.getInstance().player.sendSystemMessage(Component.literal("Bravery saw you through it all."));
						 combatMode.setModeOff(1);
						 break;
					case 13:
						 Minecraft.getInstance().player.sendSystemMessage(Component.literal("What needed to be done has been done."));
						 combatMode.setModeOff(1);
						 break;
					case 14:
						 Minecraft.getInstance().player.sendSystemMessage(Component.literal("Justice delievered!"));
						 combatMode.setModeOff(1);
						 break;
					case 15:
						 Minecraft.getInstance().player.sendSystemMessage(Component.literal("Kindness has once again prevailed."));
						 combatMode.setModeOff(1);
						 break;
					case 16:
						 Minecraft.getInstance().player.sendSystemMessage(Component.literal("That wasn't so tough!"));
						 combatMode.setModeOff(1);
						 break;
					case 17:
						 Minecraft.getInstance().player.sendSystemMessage(Component.literal("Perseverance brought you through."));
						 combatMode.setModeOff(1);
						 break;
					case 99:
						 Minecraft.getInstance().player.sendSystemMessage(Component.literal("Science Triumphs again!"));
						 combatMode.setModeOff(1);
						 break;


				}
				}
			}

			
		 });
		});
		 });
	 });
	 return true;
 }
}