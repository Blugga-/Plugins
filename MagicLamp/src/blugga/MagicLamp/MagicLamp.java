package blugga.MagicLamp;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MagicLamp extends JavaPlugin {

	@Override
	public void onEnable()
	{
		PluginManager pm = this.getServer().getPluginManager();
		
		pm.registerEvents(new MagicLampEvent(this), this);
		System.out.println("magiclamp actif");
	}
	@Override
	public void onDisable()
	{
		System.out.println("MagicLamp inactif");
	}
}
	


   
