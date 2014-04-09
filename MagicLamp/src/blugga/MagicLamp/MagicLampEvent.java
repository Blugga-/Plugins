package blugga.MagicLamp;
     
    import net.minecraft.server.v1_7_R1.WorldServer;
     



    import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.craftbukkit.v1_7_R1.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Bukkit;
import org.bukkit.Material;
     
    public class MagicLampEvent implements Listener {
       
        public MagicLamp plugin;
       
        public MagicLampEvent(MagicLamp plugin)
        {
                this.plugin = plugin;
        }
       
       
         @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
     public void onPlayerInteract(PlayerInteractEvent e)
     {
             Player player = e.getPlayer();
             
             if (e.getAction() != Action.RIGHT_CLICK_BLOCK || player.getItemInHand() == null || player.getItemInHand().getType() != Material.FLINT_AND_STEEL || !player.hasPermission("magiclamp.use") || player.isSneaking())
                     return;
 
                Block block = e.getClickedBlock();
                BlockState blockState = block.getState();
                Material material = block.getType();
 
                if (material == Material.REDSTONE_LAMP_ON || material == Material.REDSTONE_LAMP_OFF)
                {
                        e.setCancelled(true);
                        BlockPlaceEvent checkBuildPerms = new BlockPlaceEvent(block, blockState, block, new ItemStack(material == Material.REDSTONE_LAMP_ON ? Material.REDSTONE_LAMP_OFF : Material.REDSTONE_LAMP_ON), player, true);
                        Bukkit.getPluginManager().callEvent(checkBuildPerms);
 
                        if (checkBuildPerms.isCancelled())
                                return;
 
                        switchLamp(block, material == Material.REDSTONE_LAMP_ON ? false : true);
                }
     }
     
    @SuppressWarnings("deprecation")
    private void switchLamp(Block b, boolean lighting)
    {
    WorldServer ws = ((CraftWorld)b.getWorld()).getHandle();
     
    boolean mem = ws.isStatic;
    if (lighting)
    {
    if (!mem) {
    ws.isStatic = true;
    }
    b.setTypeIdAndData(Material.REDSTONE_LAMP_ON.getId(), (byte)0, false);
    if (!mem) {
    ws.isStatic = false;
    }
    }
    else
    {
    b.setTypeIdAndData(Material.REDSTONE_LAMP_OFF.getId(), (byte)0, false);
    }
    }
    }
   
  



                       
                         
                         
                    

		    	
		     
	
	     
			
			
			
	
		
		
			
			
			
		     
		     
		    	
		   
		    	
		    	
	
			        
			 
			
		
			
							
				
					
			


	
		
		
			
				
					
	
					
						
					
						
							
				
			
				
		
		
		
			
		
	  


