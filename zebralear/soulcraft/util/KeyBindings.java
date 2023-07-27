package zebralear.soulcraft.util;

import org.lwjgl.glfw.GLFW;

import com.mojang.blaze3d.platform.InputConstants;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;

public class KeyBindings {
	public static final String Key_Category_SoulCraft = "key.category.SoulcraftMod.SoulCraft";
	public static final String Key_Enter_Combat_Mode = "key.SoulCraftMod.Combat_Mode";
	
	public static final KeyMapping Combat_Key = new KeyMapping
			(Key_Enter_Combat_Mode, // The translation of the Key used
			KeyConflictContext.IN_GAME, // Key conflicts only with in-game keybinds
			InputConstants.Type.KEYSYM,
			GLFW.GLFW_KEY_Q, //Defaults to Q
			Key_Category_SoulCraft); // the category
}
