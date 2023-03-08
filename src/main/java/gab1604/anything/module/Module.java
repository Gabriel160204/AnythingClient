package gab1604.anything.module;

import java.util.ArrayList;

import gab1604.anything.module.Components.Button;
import gab1604.anything.module.gui.Component;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

public abstract class Module {
	
	protected static Minecraft mc = Minecraft.getMinecraft();
	
	protected ArrayList<Component> components; // Gui stuff, button, sliders, label, checkbox ...
	protected String name, description;
	protected int keyCode;
	protected Category category;
	protected boolean isActive;
	
	public Module(String name, String description, int keyCode, Category category, boolean active) {
		this.name = name;
		this.description = description;
		this.keyCode = keyCode;
		this.category = category;
		this.isActive = active;
		this.components = new ArrayList<Component>();
	}
	
	public abstract void actionComponent();
	
	public void onEnable() {
		this.isActive = true;
		MinecraftForge.EVENT_BUS.register((Object) this);
	}
	
	public void onDisable() {
		this.isActive = false;
		MinecraftForge.EVENT_BUS.unregister((Object) this);
	}
	
	public int getKeyCode() {
		return keyCode;
	}

	public void setKeyCode(int keyCode) {
		this.keyCode = keyCode;
	}

	public boolean isActived() {
		return isActive;
	}

	public String getName() {
		return this.name;
	}
	
	public Category getCategory() {
		return this.category;
	}

	public ArrayList<Component> getComponents() {
		return components;
	}

	public void setComponents(ArrayList<Component> components) {
		this.components = components;
	}

	public void addComponent(Component component) {
		this.components.add(component);
	}
	
	public Component getComponent(String componentName) {
		for (Component component : this.components) {
			if (component.getName().equalsIgnoreCase(componentName)) {
				return component;
			}
		}
		return null;
	}
}
