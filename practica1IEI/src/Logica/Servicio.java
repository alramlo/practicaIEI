package Logica;

import java.sql.Connection;
import java.sql.DriverManager;

public class Servicio {
	
	Connection mysql=null;
	Connection derby=null;
	String sourceURL= "jdbc:mysql://localhost:3306/";
	
	public Servicio(){
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			mysql = DriverManager.getConnection (sourceURL,"root", "");
			
			Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
			derby = DriverManager.getConnection("");

		
		} catch (Exception e){
			e.printStackTrace(); 
		}
		
	}


}
