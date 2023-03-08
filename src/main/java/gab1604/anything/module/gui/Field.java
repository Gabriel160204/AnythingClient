package gab1604.anything.module.gui;

import java.util.ArrayList;

import gab1604.anything.module.Category;
import gab1604.anything.module.Module;
import gab1604.anything.module.ModuleManager;

public class Field {
	
	protected ArrayList<Module> modules;
	Category category;
	int x = 10,
		y = 10,
		width = 75,
		height = 25;
	
	public Field(Category category) {
		modules = new ArrayList<Module>();
		this.category = category;
	}
	
	public Category getCategory() {
		return this.category;
	}
	
	public ArrayList<Module> getModuleList() {
		return modules;
	}
	
	public void setArrayListModule(ArrayList<Module> _modules) {
		modules.clear();
		for (Module module : _modules) {
			modules.add(module);
		}
	}
	
	public void addModule(Module module) {
		modules.add(module);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
}
