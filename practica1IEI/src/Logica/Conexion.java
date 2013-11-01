package Logica;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Conexion {
	
	Connection mysql=null;
	Connection derby=null;
	String sourceMysql="jdbc:mysql://localhost:3306/";
	String sourceDerby="jdbc:derby://localhost/c:/DerbyDB/DB2";
	
	public Conexion(){
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			mysql = DriverManager.getConnection (sourceMysql,"root", "");
			
			Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
			derby = DriverManager.getConnection(sourceDerby);

		
		} catch (Exception e){
			e.printStackTrace(); 
		}
		
	}


}
