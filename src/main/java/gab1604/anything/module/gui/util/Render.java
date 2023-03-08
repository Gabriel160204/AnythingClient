package gab1604.anything.module.gui.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;

import org.lwjgl.opengl.GL11;

public class Render extends Gui {
	
	private FontRenderer fontRenderer;

    public Render() {
        this.fontRenderer = Minecraft.getMinecraft().fontRendererObj;
    }
}
