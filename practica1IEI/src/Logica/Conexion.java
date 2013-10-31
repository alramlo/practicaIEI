package Logica;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.PreparedStatement;

public class Conexion {
	
	Connection mysql=null;
	Connection derby=null;
	PreparedStatement consulta=null;
	String sourceMySQL="jdbc:mysql://localhost:3306/";
	String sourceDerby="jdbc:derby://localhost/c:/DerbyDB/DB2";
	
	public Conexion(){
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			mysql = DriverManager.getConnection (sourceMySQL,"root", "");
			
			Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
			derby = DriverManager.getConnection(sourceDerby);

		
		} catch (Exception e){
			e.printStackTrace(); 
		}
		
	}


}
