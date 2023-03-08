package gab1604.anything.module.gui;

import java.io.IOException;
import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import gab1604.anything.module.Category;
import gab1604.anything.module.Module;
import gab1604.anything.module.gui.util.Render;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.RenderTickEvent;
import scala.tools.nsc.typechecker.SuperAccessors.SuperAccTransformer;

public class Hud extends GuiScreen {
	    
		public static ArrayList<Field> fields = new ArrayList<Field>();
		
		public Hud() {
			int newX = 10, newWidth = 75;
			for (Category category : Category.values()) {
				Field field = new Field(category);
				field.setX(newX);
				field.setWidth(newWidth);
				fields.add(field);
				newX += 100;
				newWidth += 100;
			}
		}
		
		public static ArrayList<Field> getFieldList() {
			return fields;
		}
		
		@Override
	    public void initGui() {
	        super.initGui();
	    }
	    
	    @Override
	    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
	    	this.drawDefaultBackground();
	    	for (Field field : fields) {
	    		this.drawRect(field.getX(), 10, field.getWidth(), 25, 0x2200000);
	    		this.drawString(fontRendererObj, field.category.toString(), field.getX() + 10, 14, 0xFFFFFFFF);
	    		for (Module module : field.getModuleList()) {
	    			for (Component component : module.getComponents()) {
	    				component.render();
	    			}
	    		}
	    	}
	    }
	    
	    @Override
	    public void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
	    	super.mouseClicked(mouseX, mouseY, mouseButton);
	    	
	    	for (Field field : fields) {
	    		for (Module module : field.getModuleList()) {
	    			for (Component component : module.getComponents()) {
	    				if (isMouseInRect(mouseX, mouseY, component.getX(), component.getY(), component.getWidth(), component.getHeight())) {
	    					component.action();
	    					module.actionComponent();
	    				}
	    			}
	    		}
	    	}
	    }
	    
	    private boolean isMouseInRect(int mouseX, int mouseY, int rectX, int rectY, int rectWidth, int rectHeight) {
	    	return mouseX >= rectX && mouseX <= rectX + rectWidth &&
	    		   mouseY >= rectY && mouseY <= rectY + rectHeight;
	    }

		@Override
	    protected void actionPerformed(GuiButton button) throws IOException {
	    }
	    
	    @Override
	    public boolean doesGuiPauseGame() {
	        return false;
	    }
	    
	    @Override
	    public void onGuiClosed() {
	        super.onGuiClosed();
	    }
}
