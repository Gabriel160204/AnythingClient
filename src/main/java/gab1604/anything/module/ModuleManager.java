package gab1604.anything.module; 

import java.util.ArrayList;

import gab1604.anything.module.gui.Field;
import gab1604.anything.module.gui.Hud;
import net.minecraftforge.common.MinecraftForge;

public class ModuleManager {

	public static ArrayList<Module> modules = new ArrayList<Module>();
	public static Hud hud;
	
	public ModuleManager() {

	}
	
	public static Module getModule(String moduleName) {
		for (Module module : modules) {
			if (module.getName().equalsIgnoreCase(moduleName)) {
				return module;
			}
		}
		return null;
	}
	
	public static ArrayList<Module> getModuleList() {
		return modules;
	}
	
	public static ArrayList<Module> getModulesInCategory(Category category) {
		ArrayList<Module> mods = new ArrayList<Module>();
		for (Module module : modules) {
			if (module.getCategory().name().equalsIgnoreCase(category.name())) {
				mods.add(module);
			}
		}
		return mods;
	}
	
	public static void addModule(Module mod) {
		modules.add(mod);
	}
	
	
	public static void registerHud() {
		hud = new Hud();
		for (Field field : hud.getFieldList()) {
			field.setArrayListModule(getModulesInCategory(field.getCategory()));
		}
	}
}
