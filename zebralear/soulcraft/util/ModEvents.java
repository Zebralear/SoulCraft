package zebralear.soulcraft.util;



import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import zebralear.soulcraft.SoulStorage.CombatModeProvider;
import zebralear.soulcraft.SoulStorage.SoulHas;
import zebralear.soulcraft.SoulStorage.SoulHasProvider;
import zebralear.soulcraft.SoulStorage.SoulType;
import zebralear.soulcraft.SoulStorage.SoulTypeProvider;
import zebralear.soulcraft.SoulStorage.SpecialAttackCharge;
import zebralear.soulcraft.SoulStorage.SpecialAttackChargeProvider;
import zebralear.soulcraft.entity.SoulcraftEntities;
import zebralear.soulcraft.entity.custom.SingleSpearEntity;
import zebralear.soulcraft.toplevel.SoulCraftMod;



public class ModEvents {
	@Mod.EventBusSubscriber(modid = SoulCraftMod.mod_id)
	public static class ForgeEvents {
		@SubscribeEvent
		public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
			event.register(SoulHas.class);
			event.register(SoulType.class);
			event.register(SpecialAttackCharge.class);
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

			@SubscribeEvent
			public static void chargeFromDamage(LivingDamageEvent playerhurt) {
				if (playerhurt.getEntity() instanceof Player && !playerhurt.getEntity().level.isClientSide()) {
		            Player player = (Player) playerhurt.getEntity();
		            float damageAmount = playerhurt.getAmount();
		            int damageInt = (int) damageAmount;
		            System.out.println("Player took damage!");
		            // because LivingHurtEvent is a server-side trigger, this auto runs on the server side due to @SubscribeEvent.
		            player.getCapability(SoulTypeProvider.Soul_Type).ifPresent(soulType -> {
						player.getCapability(SpecialAttackChargeProvider.Special_Attack_Charge).ifPresent(chargePercent -> {
							var TypeChecker = soulType.getSoulType();
						player.getCapability(CombatModeProvider.Combat_Mode).ifPresent(combatMode -> {
							var CombatChecker = combatMode.getCombatMode();
						if(chargePercent.getChargePercent() < 100 && CombatChecker == 1) {
							switch(TypeChecker) {
							case 1:
								//undyne gets lots of power by taking damage
								int ChargeIntUndyne = (int) Math.round(damageInt*3);
								chargePercent.chargeIncrease(ChargeIntUndyne);
								System.out.println("Player took damage!" + ChargeIntUndyne);
								 break;
							case 2:
								 // muffet gets power by dealing damage -- todo
								 break;
							case 3:
								 // sans gets power by existing -- done elsewhere
								break;
							case 4:
								// mettaton gets power in lots of ways -- todo
								int ChargeIntMettaton = (int)(Math.round(damageInt/2));
								chargePercent.chargeIncrease(ChargeIntMettaton);
								break;
							case 5:
								// toriel gets power by ??? -- todo
								 break;
							case 6:
								 // paps gets power by taking damage -- todo
								 break;
							case 7:
								 // asgore gets power by dealing damage -- todo
								 break;
							case 8:
							 	// blooky has no special attack. he just vibes
							 	break;
							case 9:
								 // the child gets power from everything -- todo
								chargePercent.chargeIncrease(damageInt);
								break;
							case 10:
								 // fear souls get power by dealing damage -- todo
								break;
							case 11:
								 // determination gets power from taking damage and existing
								chargePercent.chargeIncrease(damageInt);
								 break;
							case 12:
								// bravery gets power from taking damage -- todo
								 break;
							case 13:
								 // integrity gets power from everything -- todo
								chargePercent.chargeIncrease(damageInt);

								 break;
							case 14:
								// justice gets power from dealing damage -- todo
								 break;
							case 15:
								// kindness gets power by existing and healing -- todo

								 break;
							case 16:
								// patience gets power quickly from existing and taking damage -- todo
								int ChargeIntPatience = (int) Math.round(damageInt * 1.5);
								chargePercent.chargeIncrease(ChargeIntPatience);

								 break;
							case 17:
								// Perseverance gains power through everything -- todo
								int ChargeIntPerseverance = (int) Math.round(damageInt * 1.5);
								chargePercent.chargeIncrease(ChargeIntPerseverance);

								 break;
							case 99:
								// gaster gets power through dealing damage -- todo
								// will power through calls of summoning blasters and shit during combat.
								 break;
							default:
								break;
							}
						}
					});
						});
					});
					 }
	    		return;
				}


		
		
		@SubscribeEvent
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
							//undyne gets power by taking damage
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
							// mettaton gets power in lots of ways -- todo
						case 5:
							// toriel gets power by existing -- todo
							if(event.player.getRandom().nextFloat() < .01f) {
								chargePercent.chargeIncrease(1);
							}
							 break;
						case 6:
							 // paps gets power by taking damage --todo
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
						default:
							break;
						}
					}
				});
					});
				});
				 }
			}
	}
	@Mod.EventBusSubscriber(modid = SoulCraftMod.mod_id)
	public static class ModEventBusEvents {
		@SubscribeEvent
		public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
			//nothing to see
		}
	}
	}
	