package gab1604.anything.module.Components;

import gab1604.anything.module.gui.Component;
import gab1604.anything.module.gui.util.Render;
import net.minecraft.client.gui.FontRenderer;

public class Button extends Component {

	public boolean isPressed;
	
	public Button(String name, String description) {
		super(name, description);
		this.x = 10;
		this.y = 10;
		this.width = 20;
		this.height = 20;
		this.isPressed = false;
	}
	
	public Button(String name, String description, int x, int y, int width, int height) {
		super(description, description, x, y, width, height);
		this.isPressed = false;
	}

	@Override
	public void render() {
		if (isPressed)
			Render.drawRect(x, y, width, height, 0x55000000);
		else
			Render.drawRect(x, y, width, height, 0x66FF0000);
	}
	
	public void toggle() {
		this.isPressed = !this.isPressed;
	}

	public boolean isPressed() {
		return isPressed;
	}

	@Override
	public void action() {
		toggle();	
	}
}
