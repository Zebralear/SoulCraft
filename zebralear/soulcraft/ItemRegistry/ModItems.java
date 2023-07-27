package zebralear.soulcraft.ItemRegistry;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import zebralear.soulcraft.toplevel.SoulCraftMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public class ModItems {
public static final DeferredRegister<Item> ITEMS =
	DeferredRegister.create(ForgeRegistries.ITEMS, SoulCraftMod.mod_id);
//Copy-paste the static for more items
public static final RegistryObject<Item> Undying_Fragment = ITEMS.register("undyingfragment",
		() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
public static final RegistryObject<Item> Undying_Soul = ITEMS.register("undyingsoul",
		() -> new undyingSoul(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
public static final RegistryObject<Item> King_Fragment = ITEMS.register("kingfragment",
		() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
public static final RegistryObject<Item> King_Soul = ITEMS.register("kingsoul",
		() -> new kingSoul(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
public static final RegistryObject<Item> Skeleton_Fragment_A = ITEMS.register("skeletonfragment_a",
		() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
public static final RegistryObject<Item> Skeleton_Soul_A = ITEMS.register("skeletonsoul_a",
		() -> new skeletonSoulPap(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
public static final RegistryObject<Item> Skeleton_Fragment_B = ITEMS.register("skeletonfragment_b",
		() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
public static final RegistryObject<Item> Skeleton_Soul_B = ITEMS.register("skeletonsoul_b",
		() -> new skeletonSoulSans(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
public static final RegistryObject<Item> Queen_Fragment = ITEMS.register("queenfragment",
		() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
public static final RegistryObject<Item> Queen_Soul = ITEMS.register("queensoul",
		() -> new queenSoul(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
public static final RegistryObject<Item> Child_Fragment = ITEMS.register("childfragment",
		() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
public static final RegistryObject<Item> Child_Soul = ITEMS.register("childsoul",
		() -> new childSoul(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
public static final RegistryObject<Item> Ghost_Fragment = ITEMS.register("ghostfragment",
		() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
public static final RegistryObject<Item> Ghost_Soul = ITEMS.register("ghostsoul",
		() -> new ghostSoul(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
public static final RegistryObject<Item> Spider_Fragment = ITEMS.register("spiderfragment",
		() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
public static final RegistryObject<Item> Spider_Soul = ITEMS.register("spidersoul",
		() -> new spiderSoul(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
public static final RegistryObject<Item> Robot_Fragment = ITEMS.register("robotfragment",
		() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
public static final RegistryObject<Item> Robot_Soul = ITEMS.register("robotsoul",
		() -> new robotSoul(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
public static final RegistryObject<Item> Strange_Fragment = ITEMS.register("strangefragment",
		() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
public static final RegistryObject<Item> Strange_Soul = ITEMS.register("strangesoul",
		() -> new strangeSoul(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
public static final RegistryObject<Item> HumanFragRed = ITEMS.register("determinationfragment",
		() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
public static final RegistryObject<Item> HumanRed = ITEMS.register("determinationsoul",
		() -> new determinationSoul(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
public static final RegistryObject<Item> HumanFragYellow = ITEMS.register("justicefragment",
		() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
public static final RegistryObject<Item> HumanYellow = ITEMS.register("justicesoul",
		() -> new justiceSoul(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
public static final RegistryObject<Item> HumanFragBlue = ITEMS.register("integrityfragment",
		() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
public static final RegistryObject<Item> HumanBlue = ITEMS.register("integritysoul",
		() -> new integritySoul(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
public static final RegistryObject<Item> HumanFragCyan = ITEMS.register("patiencefragment",
		() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
public static final RegistryObject<Item> HumanCyan = ITEMS.register("patiencesoul",
		() -> new patienceSoul(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
public static final RegistryObject<Item> HumanFragPurple = ITEMS.register("perseverancefragment",
		() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
public static final RegistryObject<Item> HumanPurple = ITEMS.register("perseverancesoul",
		() -> new perseveranceSoul(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
public static final RegistryObject<Item> HumanFragOrange = ITEMS.register("braveryfragment",
		() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
public static final RegistryObject<Item> HumanOrange = ITEMS.register("braverysoul",
		() -> new braverySoul(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
public static final RegistryObject<Item> HumanFragGreen = ITEMS.register("kindnessfragment",
		() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
public static final RegistryObject<Item> HumanGreen = ITEMS.register("kindnesssoul",
		() -> new kindnessSoul(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
public static final RegistryObject<Item> HumanFragPink = ITEMS.register("fearfragment",
		() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
public static final RegistryObject<Item> HumanPink = ITEMS.register("fearsoul",
		() -> new fearSoul(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
public static final RegistryObject<Item> DevUnset = ITEMS.register("devunsetsoul",
		() -> new SoulUnsetterDevItem (new Item.Properties().tab(CreativeModeTab.TAB_MISC)));





public static void register(IEventBus eventBus) {
	ITEMS.register(eventBus);
}

}