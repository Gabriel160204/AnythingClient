package gab1604.anything;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import gab1604.anything.module.ModuleManager;
import gab1604.anything.module.gui.Hud;
import gab1604.anything.module.mods.AutoClicker;
import gab1604.anything.proxy.ClientProxy;
import gab1604.anything.proxy.ServerProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.event.ClickEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.RenderTickEvent;

@Mod(modid = Reference.MODID, version = Reference.VERSION, name = Reference.NAME, acceptedMinecraftVersions = Reference.ACCEPTED_VERSION)
public class Anything {

	@SidedProxy(serverSide = Reference.SERVER_PROXY_CLASS, clientSide = Reference.CLIENT_PROXY_CLASS)
	public static ClientProxy proxy;
	
	@Mod.Instance(Reference.NAME)
	public static Anything instance;
	
	public static final Logger LOGGER = LogManager.getLogger(Reference.MODID);
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		LOGGER.info("\n\n" + Reference.NAME + " Starting...\n");
		proxy.registerModules();
		proxy.registerRenders();
	}
	
	@EventHandler
	public static void post(FMLPostInitializationEvent event) {
		
	}
	
	@SubscribeEvent
	public void onRender(ClientTickEvent event) {
		if (!Keyboard.isKeyDown(Keyboard.KEY_M)) return;
		FMLCommonHandler.instance().showGuiScreen(new Hud());
	}
}
