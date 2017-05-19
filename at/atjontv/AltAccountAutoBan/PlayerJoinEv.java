package at.atjontv.AltAccountAutoBan;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		
		Statement statement;
		ResultSet res = null;
		try {
			statement = Main.MySQLConnection.createStatement();
			res = statement.executeQuery("SELECT * FROM DataBase_A WHERE Name = '" + name + "';");
			res.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(res != null){
				if(res.getString("Name") != null)
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "minecraft:ban "+name+" Alt-Account [Banned throug AltAccountAutoBan by AtjonTV]");
			}
		} catch (SQLException e) {
			if(e.getMessage().startsWith("Illegal operation on empty result set.")){
				
			}
			else
				e.printStackTrace();
		}
		
		try {
			statement = Main.MySQLConnection.createStatement();
			res = statement.executeQuery("SELECT * FROM DataBase_B WHERE Name = '" + name + "';");
			res.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(res != null){
				if(res.getString("Name") != null)
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "minecraft:ban "+name+" Alt-Account [Banned throug AltAccountAutoBan by AtjonTV]");
			}
		} catch (SQLException e) {
			if(e.getMessage().startsWith("Illegal operation on empty result set.")){
				
			}
			else
				e.printStackTrace();
		}
	}
}
