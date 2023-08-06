package zebralear.soulcraft.libs;

import net.minecraft.resources.ResourceLocation;
import zebralear.soulcraft.toplevel.SoulCraftMod;

public class ResourceLocationHelper {
		public static ResourceLocation prefix(String path) {
			//right fucking here
			return new ResourceLocation(SoulCraftMod.mod_id, path);
		}
}
