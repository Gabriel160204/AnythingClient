package gab1604.anything.module.gui;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;

public abstract class Component {
	
	public String name, description;
	public int x, y, width, height;
	public boolean isOpen;
	public boolean isHover;
	public boolean isDraging;
	public int dragX, dragY;
	
	public Component(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public Component(String name, String description, int x, int y, int width, int height) {
		super();
		this.name = name;
		this.description = description;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}



	public abstract void render();
	
	public abstract void action();
	
	public boolean isClicked(int mouseX, int mouseY) {
		if (mouseX > this.x && mouseX < this.x + this.width &&
			mouseY > this.y && mouseY < this.y + this.height) {
				return true;
			}
		return false;
	}

	public String getName() {
		return this.name;
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

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public boolean isDraging() {
		return isDraging;
	}

	public void setDraging(boolean isDraging) {
		this.isDraging = isDraging;
	}

	public int getDragX() {
		return dragX;
	}

	public void setDragX(int dragX) {
		this.dragX = dragX;
	}

	public int getDragY() {
		return dragY;
	}

	public void setDragY(int dragY) {
		this.dragY = dragY;
	}
	
	public void toggle() {
		
	}
}
