package zebralear.soulcraft.util;

import net.minecraftforge.network.simple.SimpleChannel;
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
