package zebralear.soulcraft.entity.custom;

import org.jetbrains.annotations.NotNull;

import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
//import software.bernie.geckolib3.core.builder.Animation;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
//import zebralear.soulcraft.entity.SoulcraftEntities;
import net.minecraft.util.Mth;

public class SingleSpearEntity extends ThrowableProjectile implements IAnimatable {
	private AnimationFactory factory = new AnimationFactory(this);
	
	public SingleSpearEntity(EntityType<SingleSpearEntity> singleSpearEntity, Level playerLevel) {
		super(singleSpearEntity, playerLevel);
	}
	
	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		if (event.isMoving()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.spears.fire", true));
			return PlayState.CONTINUE;
		}
		
		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.spears.idle", true));
		return PlayState.CONTINUE;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController(this, "SpearsController", 0, this::predicate));
		
	}

	@Override
	public AnimationFactory getFactory() {
		return factory;
	}

	@Override
	protected void defineSynchedData() {
		// TODO Auto-generated method stub
	}
	
	public static Vec3 calculateBurstVelocity(float xRot, float yRot) {
		float f = 0.4F;
		double mx = Mth.sin(yRot / 180.0F * (float) Math.PI) * Mth.cos(xRot / 180.0F * (float) Math.PI) * f / 2D;
		double mz = -(Mth.cos(yRot / 180.0F * (float) Math.PI) * Mth.cos(xRot / 180.0F * (float) Math.PI) * f) / 2D;
		double my = Mth.sin(xRot / 180.0F * (float) Math.PI) * f / 2D;
		return new Vec3(mx, my, mz);
	}
	
	private DamageSource getDamageSource() {
		Entity owner = this.getOwner();
		if (owner instanceof LivingEntity livingOwner) {
			return owner instanceof Player playerOwner
					? DamageSource.playerAttack(playerOwner)
					: DamageSource.mobAttack(livingOwner);
		} else {
			return DamageSource.GENERIC;
		}
	}
	
	@Override
	protected void onHitBlock(@NotNull BlockHitResult hit) {
		super.onHitBlock(hit);
		BlockState state = getLevel().getBlockState(hit.getBlockPos());
		if (!getLevel().isClientSide
				&& !(state.getBlock() instanceof BushBlock)
				&& !state.is(BlockTags.LEAVES)) {
			discard();
		}
	}

	@Override
	protected void onHitEntity(@NotNull EntityHitResult hit) {
		super.onHitEntity(hit);
		if (!getLevel().isClientSide == true) {
			discard();
		}
	}
	
	@Override
	public void tick() {
		// Standard motion
		Vec3 old = getDeltaMovement();

		super.tick();


	/*	// Client FX
		if (level().isClientSide && isFire()) {
			double r = 0.1;
			double m = 0.1;
			for (int i = 0; i < 3; i++) {
				level().addParticle(ParticleTypes.FLAME, getX() + r * (Math.random() - 0.5), getY() + r * (Math.random() - 0.5), getZ() + r * (Math.random() - 0.5), m * (Math.random() - 0.5), m * (Math.random() - 0.5), m * (Math.random() - 0.5));
			}
		} */

		// Server state control
		if (!getLevel().isClientSide || tickCount > 600) {
			Kill();
			}
		}
	private void Kill() {
		discard();
	}
	protected SoundEvent getThrownSound() {return SoundEvents.TRIDENT_RETURN;};
	
	protected float getSoundVolume() {return 0.2f;}
}
	
