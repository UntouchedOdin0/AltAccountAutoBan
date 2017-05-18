package at.atjontv.AltAccountAutoBan;

import java.sql.Connection;
import java.sql.SQLException;

import com.huskehhh.mysql.mysql.*;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	private static MySQL MySQL = new MySQL("213.202.229.156", "3306", "altautoban_users", "altautoban", "S6QR6ammNc9UZJTa");
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
