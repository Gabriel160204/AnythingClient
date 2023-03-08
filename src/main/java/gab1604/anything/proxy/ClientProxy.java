package gab1604.anything.proxy;

import gab1604.anything.Anything;
import gab1604.anything.module.Module;
import gab1604.anything.module.ModuleManager;
import gab1604.anything.module.gui.Hud;
import gab1604.anything.module.mods.AutoClicker;
import gab1604.anything.module.mods.HudMods;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends ServerProxy {

	@Override
	public void registerModules() {
		ModuleManager.addModule(new AutoClicker());
		ModuleManager.addModule(new HudMods());
		for (Module module : ModuleManager.getModuleList()) {
			module.onEnable();
		}
	}
	
	@Override
	public void registerRenders() {
		ModuleManager.registerHud();
	}
	
	@Override
	public void registerEvents() {
		
	}
	
	@Override
	public void registerAll() {
		
	}
}
