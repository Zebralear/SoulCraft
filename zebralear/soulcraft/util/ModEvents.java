package zebralear.soulcraft.util;



import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import zebralear.soulcraft.SoulStorage.CombatModeProvider;
import zebralear.soulcraft.SoulStorage.SoulHas;
import zebralear.soulcraft.SoulStorage.SoulHasProvider;
import zebralear.soulcraft.SoulStorage.SoulType;
import zebralear.soulcraft.SoulStorage.SoulTypeProvider;
import zebralear.soulcraft.SoulStorage.SpecialAttackChargeProvider;
import zebralear.soulcraft.toplevel.SoulCraftMod;

@Mod.EventBusSubscriber(modid = SoulCraftMod.mod_id)
public class ModEvents {
	@SubscribeEvent
	public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
		event.register(SoulHas.class);
		event.register(SoulType.class);
	}
	@SubscribeEvent
	public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
	if(event.getObject() instanceof Player) {
		if(!event.getObject().getCapability(SoulHasProvider.Soul_Has).isPresent()) {
			event.addCapability(new ResourceLocation(SoulCraftMod.mod_id, "hassoulcraftsoul"), new SoulHasProvider());
			}
		};
	if(event.getObject() instanceof Player) {
		if(!event.getObject().getCapability(SoulTypeProvider.Soul_Type).isPresent()) {
			event.addCapability(new ResourceLocation(SoulCraftMod.mod_id, "soulcraftsoultype"), new SoulTypeProvider());
		    }
		};
		if(event.getObject() instanceof Player) {
			if(!event.getObject().getCapability(CombatModeProvider.Combat_Mode).isPresent()) {
				event.addCapability(new ResourceLocation(SoulCraftMod.mod_id, "incombatmode"), new CombatModeProvider());
				}
			};
		if(event.getObject() instanceof Player) {
			if(!event.getObject().getCapability(SpecialAttackChargeProvider.Special_Attack_Charge).isPresent()) {
				event.addCapability(new ResourceLocation(SoulCraftMod.mod_id, "specialattackcharge"), new SpecialAttackChargeProvider());
			}
		};
	}
	@SubscribeEvent
	public void onPlayerCloned(PlayerEvent.Clone event) {
	if(event.isWasDeath()) {
		event.getOriginal().getCapability(SoulHasProvider.Soul_Has).ifPresent(oldStore -> {
			event.getOriginal().getCapability(SoulHasProvider.Soul_Has).ifPresent(newStore -> {
				newStore.copyFrom(oldStore);
			});
		 });
		event.getOriginal().getCapability(SoulTypeProvider.Soul_Type).ifPresent(oldStore -> {
			event.getOriginal().getCapability(SoulTypeProvider.Soul_Type).ifPresent(newStore -> {
			newStore.copyFrom(oldStore);	
			});
		});
		}
	}
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if(event.side == LogicalSide.SERVER) {
			event.player.getCapability(SoulTypeProvider.Soul_Type).ifPresent(soulType -> {
				event.player.getCapability(SpecialAttackChargeProvider.Special_Attack_Charge).ifPresent(chargePercent -> {
					var TypeChecker = soulType.getSoulType();
				event.player.getCapability(CombatModeProvider.Combat_Mode).ifPresent(combatMode -> {
					var CombatChecker = combatMode.getCombatMode();
				if(chargePercent.getChargePercent() < 100 && CombatChecker == 1) {
					switch(TypeChecker) {
					case 1:
						 // undyne gets power by taking damage -- todo
						 break;
					case 2:
						 // muffet gets power by dealing damage -- todo
						 break;
					case 3:
						 // sans gets power by existing 
						if(event.player.getRandom().nextFloat() < .01f) {
							chargePercent.chargeIncrease(1);	
						}
						break;
					case 4:
						// metatton gets power in lots of ways -- todo
					case 5:
						// toriel gets power by ??? -- todo
						 break;
					case 6:
						 // paps gets power by taking and dealing damage --todo
						 break;
					case 7:
						 // asgore gets power by dealing damage -- todo
						 break;
					case 8:
					 	// blooky has no special attack. he just vibes
					 	break;
					case 9:
						 // the child gets power from everything -- todo
						if(event.player.getRandom().nextFloat() < .01f) {
							chargePercent.chargeIncrease(1);
						}
						break;
					case 10:
						 // fear souls get power by dealing damage -- todo
						break;
					case 11:
						 // determination gets power from taking damage and existing -- todo
						if(event.player.getRandom().nextFloat() < .01f) {
							chargePercent.chargeIncrease(1);
						}
						event.player.sendSystemMessage(Component.literal("Power Up"));
						 break;
					case 12:
						// bravery gets power from taking damage -- todo
						 break;
					case 13:
						 // integrity gets power from everything -- todo
						if(event.player.getRandom().nextFloat() < .01f) {
							chargePercent.chargeIncrease(1);	
						}
						 break;
					case 14:
						// justice gets power from dealing damage -- todo
						 break;
					case 15:
						// kindness gets power by existing and healing -- todo
						if(event.player.getRandom().nextFloat() < .01f) {
							chargePercent.chargeIncrease(1);	
						}
						 break;
					case 16:
						// patience gets power quickly from existing and taking damage -- todo
						if(event.player.getRandom().nextFloat() < .05f) {
							chargePercent.chargeIncrease(1);	
						}
						 break;
					case 17:
						// Perseverance gains power through everything -- todo
						if(event.player.getRandom().nextFloat() < .01f) {
							chargePercent.chargeIncrease(1);	
						}
						 break;
					case 99:
						// gaster gets power through dealing damage -- todo
						// will power through calls of summoning blasters and shit during combat.
						 break;
					}
				}
			});
				});
			});
			 }
		}
	}
	