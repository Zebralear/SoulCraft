package zebralear.soulcraft.util;

import net.minecraftforge.network.simple.SimpleChannel;
import zebralear.soulcraft.networking.BraveryC2S;
import zebralear.soulcraft.networking.ChildC2S;
import zebralear.soulcraft.networking.CombatKeyC2S;
import zebralear.soulcraft.networking.DeterminationC2S;
import zebralear.soulcraft.networking.FearC2S;
import zebralear.soulcraft.networking.GhostC2S;
import zebralear.soulcraft.networking.IntegrityC2S;
import zebralear.soulcraft.networking.JusticeC2S;
import zebralear.soulcraft.networking.KindnessC2S;
import zebralear.soulcraft.networking.KingC2S;
import zebralear.soulcraft.networking.PapC2S;
import zebralear.soulcraft.networking.PatienceC2S;
import zebralear.soulcraft.networking.PerseveranceC2S;
import zebralear.soulcraft.networking.QueenC2S;
import zebralear.soulcraft.networking.RobotC2S;
import zebralear.soulcraft.networking.SansC2S;
import zebralear.soulcraft.networking.SpiderC2S;
import zebralear.soulcraft.networking.StrangeC2S;
import zebralear.soulcraft.networking.UndyingSoulUsedC2S;
import zebralear.soulcraft.networking.UnsetterC2S;
import zebralear.soulcraft.toplevel.SoulCraftMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;

public class ModMessages {
	private static SimpleChannel INSTANCE;


	
	public static void register() {
		SimpleChannel net = NetworkRegistry.ChannelBuilder
				.named(new ResourceLocation(SoulCraftMod.mod_id, "messages"))
				.networkProtocolVersion(() -> "1.0")
				.clientAcceptedVersions(s -> true)
				.serverAcceptedVersions(s -> true)
				.simpleChannel();
		
		INSTANCE = net;
		
		net.messageBuilder(UndyingSoulUsedC2S.class, id(), NetworkDirection.PLAY_TO_SERVER)
			.decoder(UndyingSoulUsedC2S::new)
			.encoder(UndyingSoulUsedC2S::toBytes)
			.consumerMainThread(UndyingSoulUsedC2S::handle)
			.add();
		net.messageBuilder(UnsetterC2S.class, id(), NetworkDirection.PLAY_TO_SERVER)
			.decoder(UnsetterC2S::new)
			.encoder(UnsetterC2S::toBytes)
			.consumerMainThread(UnsetterC2S::handle)
			.add();
		net.messageBuilder(CombatKeyC2S.class, id(), NetworkDirection.PLAY_TO_SERVER)
			.decoder(CombatKeyC2S::new)
			.encoder(CombatKeyC2S::toBytes)
			.consumerMainThread(CombatKeyC2S::handle)
			.add();
		net.messageBuilder(StrangeC2S.class, id(), NetworkDirection.PLAY_TO_SERVER)
			.decoder(StrangeC2S::new)
			.encoder(StrangeC2S::toBytes)
			.consumerMainThread(StrangeC2S::handle)
			.add();
		net.messageBuilder(SpiderC2S.class, id(), NetworkDirection.PLAY_TO_SERVER)
			.decoder(SpiderC2S::new)
			.encoder(SpiderC2S::toBytes)
			.consumerMainThread(SpiderC2S::handle)
			.add();
		net.messageBuilder(SansC2S.class, id(), NetworkDirection.PLAY_TO_SERVER)
			.decoder(SansC2S::new)
			.encoder(SansC2S::toBytes)
			.consumerMainThread(SansC2S::handle)
			.add();
		net.messageBuilder(RobotC2S.class, id(), NetworkDirection.PLAY_TO_SERVER)
			.decoder(RobotC2S::new)
			.encoder(RobotC2S::toBytes)
			.consumerMainThread(RobotC2S::handle)
			.add();
		net.messageBuilder(QueenC2S.class, id(), NetworkDirection.PLAY_TO_SERVER)
			.decoder(QueenC2S::new)
			.encoder(QueenC2S::toBytes)
			.consumerMainThread(QueenC2S::handle)
			.add();
		net.messageBuilder(PerseveranceC2S.class, id(), NetworkDirection.PLAY_TO_SERVER)
			.decoder(PerseveranceC2S::new)
			.encoder(PerseveranceC2S::toBytes)
			.consumerMainThread(PerseveranceC2S::handle)
			.add();
		net.messageBuilder(PatienceC2S.class, id(), NetworkDirection.PLAY_TO_SERVER)
			.decoder(PatienceC2S::new)
			.encoder(PatienceC2S::toBytes)
			.consumerMainThread(PatienceC2S::handle)
			.add();
		net.messageBuilder(PapC2S.class, id(), NetworkDirection.PLAY_TO_SERVER)
			.decoder(PapC2S::new)
			.encoder(PapC2S::toBytes)
			.consumerMainThread(PapC2S::handle)
			.add();
		net.messageBuilder(KingC2S.class, id(), NetworkDirection.PLAY_TO_SERVER)
			.decoder(KingC2S::new)
			.encoder(KingC2S::toBytes)
			.consumerMainThread(KingC2S::handle)
			.add();
		net.messageBuilder(KindnessC2S.class, id(), NetworkDirection.PLAY_TO_SERVER)
			.decoder(KindnessC2S::new)
			.encoder(KindnessC2S::toBytes)
			.consumerMainThread(KindnessC2S::handle)
			.add();
		net.messageBuilder(JusticeC2S.class, id(), NetworkDirection.PLAY_TO_SERVER)
			.decoder(JusticeC2S::new)
			.encoder(JusticeC2S::toBytes)
			.consumerMainThread(JusticeC2S::handle)
			.add();
		net.messageBuilder(GhostC2S.class, id(), NetworkDirection.PLAY_TO_SERVER)
			.decoder(GhostC2S::new)
			.encoder(GhostC2S::toBytes)
			.consumerMainThread(GhostC2S::handle)
			.add();
		net.messageBuilder(FearC2S.class, id(), NetworkDirection.PLAY_TO_SERVER)
			.decoder(FearC2S::new)
			.encoder(FearC2S::toBytes)
			.consumerMainThread(FearC2S::handle)
			.add();
		net.messageBuilder(DeterminationC2S.class, id(), NetworkDirection.PLAY_TO_SERVER)
			.decoder(DeterminationC2S::new)
			.encoder(DeterminationC2S::toBytes)
			.consumerMainThread(DeterminationC2S::handle)
			.add();
		net.messageBuilder(ChildC2S.class, id(), NetworkDirection.PLAY_TO_SERVER)
			.decoder(ChildC2S::new)
			.encoder(ChildC2S::toBytes)
			.consumerMainThread(ChildC2S::handle)
			.add();
		net.messageBuilder(BraveryC2S.class, id(), NetworkDirection.PLAY_TO_SERVER)
			.decoder(BraveryC2S::new)
			.encoder(BraveryC2S::toBytes)
			.consumerMainThread(BraveryC2S::handle)
			.add();
		net.messageBuilder(IntegrityC2S.class, id(), NetworkDirection.PLAY_TO_SERVER)
			.decoder(IntegrityC2S::new)
			.encoder(IntegrityC2S::toBytes)
			.consumerMainThread(IntegrityC2S::handle)
			.add();
	}
	
	public static <MSG> void sendToServer(MSG message) {
		INSTANCE.sendToServer(message);
	}
	public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
		INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
	}
	
	private static int packetId = 0;
	private static int id() {
	return packetId++;	
	}
	
	}
