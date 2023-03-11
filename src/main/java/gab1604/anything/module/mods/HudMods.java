package gab1604.anything.module.mods;

import org.lwjgl.input.Keyboard;

import gab1604.anything.module.Category;
import gab1604.anything.module.Module;
import gab1604.anything.module.gui.Hud;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.RenderTickEvent;

public class HudMods extends Module {

	public HudMods() {
		super("Hud Mods", "Show mods", Keyboard.KEY_L, Category.RENDER, true);
	}
	
	@SubscribeEvent
	public void onRender(RenderTickEvent event) {;
		if (!Keyboard.isKeyDown(keyCode) || mc.ingameGUI.getChatGUI().getChatOpen())
			return;
		
		mc.displayGuiScreen(new Hud());
	}

	@Override
	public void actionComponent() {

	}
}
