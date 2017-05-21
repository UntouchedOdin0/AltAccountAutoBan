package at.atjontv.AltAccountAutoBan;

import at.atjontv.AltAccountAutoBan.DataBaseCheck;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinEv implements Listener{

	public PlayerJoinEv(Main plugin){
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	private String Prefix = (char)167+"7["+(char)167+"4AAAB"+(char)167+"7]"+(char)167+"f » ";
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent PJE){
		Player p = PJE.getPlayer();
		String name = p.getName();
		
		if(DataBaseCheck.userInDataBase_A(name) || DataBaseCheck.userInDataBase_B(name) || DataBaseCheck.userInDataBase_C(name)){
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "minecraft:ban "+name+" Alt-Account [Banned throug AltAccountAutoBan by AtjonTV]");
		
			
			for(Player x : Bukkit.getOnlinePlayers()){
				if(x.hasPermission("AAAB.admin")){
					x.sendMessage(Prefix+(char)167+"4"+name+(char)167+"f was an Alt-Account, and got Banned!");
				}
			}
		
		}
	}
}
