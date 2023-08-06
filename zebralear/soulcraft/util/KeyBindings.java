package zebralear.soulcraft.util;

import org.lwjgl.glfw.GLFW;

import com.mojang.blaze3d.platform.InputConstants;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;

public class KeyBindings {
	public static final String Key_Category_SoulCraft = "key.category.SoulcraftMod.SoulCraft";
	public static final String Key_Enter_Combat_Mode = "key.SoulCraftMod.Combat_Mode";
	public static final String Key_Special_Attack = "key.SoulCraftMod.SpecialAttack";
	public static final String Key_Attack_3 = "key.SoulCraftMod.Attack3";
	
	public static final KeyMapping Combat_Key = new KeyMapping
			(Key_Enter_Combat_Mode, // The translation of the Key used
			KeyConflictContext.IN_GAME, // Key conflicts only with in-game keybinds
			InputConstants.Type.KEYSYM,
			GLFW.GLFW_KEY_Q, //Defaults to Q
			Key_Category_SoulCraft); // the category
	public static final KeyMapping SpecialAttackKey = new KeyMapping
			(Key_Special_Attack, // The translation of the Key used
			KeyConflictContext.IN_GAME, // Key conflicts only with in-game keybinds
			InputConstants.Type.KEYSYM,
			GLFW.GLFW_KEY_Z, //Defaults to Z
			Key_Category_SoulCraft); // the category
	public static final KeyMapping Attack_3_Key = new KeyMapping
			(Key_Attack_3, // The translation of the Key used
			KeyConflictContext.IN_GAME, // Key conflicts only with in-game keybinds
			InputConstants.Type.MOUSE,
			GLFW.GLFW_MOUSE_BUTTON_4, //Defaults to MB4
			Key_Category_SoulCraft); // the category
}
