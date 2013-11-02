package Logica;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Conexion {
	
	protected Connection mysql;
	protected Connection derby;
	protected String sourceMysql;
	protected String sourceDerby;
	
	public Conexion(){
			
			this.mysql=null;
			this.derby=null;
			this.sourceMysql="jdbc:mysql://localhost:3306/";
			this.sourceDerby="jdbc:derby://localhost/c:/DerbyDB/DB2";	
	}

	public void conectar() throws ClassNotFoundException{
		try{
			
		Class.forName("com.mysql.jdbc.Driver");
		mysql = DriverManager.getConnection (sourceMysql,"root", "");
		
		Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
		derby = DriverManager.getConnection(sourceDerby);
		
		} catch (Exception e){
			System.out.println("Error al conectar: "+e); 
		}
	}

}
