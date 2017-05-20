package at.atjontv.AltAccountAutoBan;

import java.sql.Connection;
import java.sql.SQLException;

import at.atjontv.AltAccountAutoBan.MySQL.MySQL;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	private static MySQL MySQL = new MySQL(/*<HERE WOULD BE THE SERVER, PORT, DATABASE, USER, PASSWORD OF MY SERVER!>*/);
	public static Connection MySQLConnection = null;
	
	@Override
	public void onEnable() {
		MySQLConnection();
		new PlayerJoinEv(this);
	}
	
	public static void MySQLConnection(){
		try {
			MySQLConnection = MySQL.openConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
