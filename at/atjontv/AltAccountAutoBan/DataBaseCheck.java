package at.atjontv.AltAccountAutoBan;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseCheck {

	public static boolean userInDataBase_A(String name){
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
					return true;
			}
		} catch (SQLException e) {
			if(e.getMessage().startsWith("Illegal operation on empty result set.")){
				return false;
			}
			else
				e.printStackTrace();
		}
		return false;
	}
	
	public static boolean userInDataBase_B(String name){
		Statement statement;
		ResultSet res = null;
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
					return true;
			}
		} catch (SQLException e) {
			if(e.getMessage().startsWith("Illegal operation on empty result set.")){
				return false;
			}
			else
				e.printStackTrace();
		}
		return false;
	}
	
	public static boolean userInDataBase_C(String name){
		Statement statement;
		ResultSet res = null;
		try {
			statement = Main.MySQLConnection.createStatement();
			res = statement.executeQuery("SELECT * FROM DataBase_C WHERE Name = '" + name + "';");
			res.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(res != null){
				if(res.getString("Name") != null)
					return true;
			}
		} catch (SQLException e) {
			if(e.getMessage().startsWith("Illegal operation on empty result set.")){
				return false;
			}
			else
				e.printStackTrace();
		}
		return false;
	}
	
}
