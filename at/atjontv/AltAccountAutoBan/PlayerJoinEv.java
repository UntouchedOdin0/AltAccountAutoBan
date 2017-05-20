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
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent PJE){
		Player p = PJE.getPlayer();
		String name = p.getName();
		
		if(DataBaseCheck.userInDataBase_A(name) || DataBaseCheck.userInDataBase_B(name)){
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "minecraft:ban "+name+" Using an Alt-Account [Banned throug AltAccountAutoBan by AtjonTV]");
		}
	}
}
