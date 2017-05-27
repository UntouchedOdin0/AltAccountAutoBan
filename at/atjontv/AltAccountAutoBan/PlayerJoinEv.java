package at.atjontv.AltAccountAutoBan;

import at.atjontv.AltAccountAutoBan.DataBaseCheck;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinEvent implements Listener{

	public PlayerJoinEvent(Main plugin){
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	private String Prefix = (char)167+"7["+(char)167+"4AAAB"+(char)167+"7]"+(char)167+"f » ";
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent PJE){
		Player p = PJE.getPlayer();
		String name = p.getName();
		
		if(DataBaseCheck.userInDataBase_A(name) || DataBaseCheck.userInDataBase_B(name) || DataBaseCheck.userInDataBase_C(name)){
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "minecraft:ban "+name+" Banned for using an Alt Account from MC-Leaks.");
		
			
			for(Player x : Bukkit.getOnlinePlayers()){
				if(x.hasPermission("AAAB.admin")){
					x.sendMessage(Prefix+(char)167+"4"+name+(char)167+" was an Alt Account, and got Banned!");
				}
			}
		
		}
	}
}
