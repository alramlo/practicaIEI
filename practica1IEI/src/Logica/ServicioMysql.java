package Logica;

import java.sql.Connection;
import java.sql.DriverManager;

public class ServicioMysql {
	
	Connection dbcon=null;
	String sourceURL= "jdbc:mysql://localhost:3306/";
	
	public ServicioMysql(){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			dbcon = DriverManager.getConnection (sourceURL,"root", "");
		
		} catch (Exception e){
			e.printStackTrace(); 
		}
		
	}

}
