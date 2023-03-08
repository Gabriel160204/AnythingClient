package gab1604.anything.module.mods;

import java.util.ArrayList;

import org.lwjgl.input.Mouse;

import gab1604.anything.module.Category;
import gab1604.anything.module.Module;
import gab1604.anything.module.Components.Button;
import gab1604.anything.module.gui.Component;
import io.netty.util.internal.ThreadLocalRandom;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AutoClicker extends Module {

	public AutoClicker() {
		super("Auto Clicker", "Click Once, clicks a lot", 0, Category.COMBAT, true);
		addComponent(new Button("Button", "A Button"));
	}
	
	private long lastClick, hold;
    private double min = 13, max = 16;
    private double speed, holdLength;
 
    @SubscribeEvent
    public void onEvent(TickEvent.PlayerTickEvent event) {
        if (!Mouse.isButtonDown(0) ||
			mc.thePlayer.isBlocking() ||
			mc.thePlayer.getCurrentEquippedItem() == null) {
			return;
        }
        Item weaponCheck = mc.thePlayer.getCurrentEquippedItem().getItem();
        if (weaponCheck == Items.diamond_sword ||
            weaponCheck == Items.iron_sword ||
            weaponCheck == Items.stone_sword ||
            weaponCheck == Items.wooden_sword ||
            weaponCheck == Items.golden_sword || 
            weaponCheck == Items.stick) {
            if (System.currentTimeMillis() - lastClick > speed * 1000) {
                lastClick = System.currentTimeMillis();
                if (hold < lastClick) {
                    hold = lastClick;
                }
                int key = mc.gameSettings.keyBindAttack.getKeyCode();
                KeyBinding.setKeyBindState(key, true);
                KeyBinding.onTick(key);
                this.updateVals();
            } else if (System.currentTimeMillis() - hold > holdLength * 1000) {
                KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                this.updateVals();
            }
        }
    }

    private void updateVals() {		
		speed = 1.0 / ThreadLocalRandom.current().nextDouble(min - 0.2, max);
		holdLength = speed / ThreadLocalRandom.current().nextDouble(min, max);
	}

	@Override
	public void actionComponent() {
		Button component = (Button)getComponent("Button");
		if (component.isPressed()) {
			onDisable();
		} else {
			onEnable();
		}
	}

}
