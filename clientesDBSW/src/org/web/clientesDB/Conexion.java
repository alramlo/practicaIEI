package org.web.clientesDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	
	private static Connection mysql;
	//protected Connection derby;
	//protected String sourceDerby;
	
	public Conexion(){
			
			this.mysql=null;	
	}

	public static Connection conectar(){
		try{
			
		Class.forName("com.mysql.jdbc.Driver");
		mysql = DriverManager.getConnection ("jdbc:mysql://localhost:3306/","root", "");
		return mysql;
		
		//Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
		//derby = DriverManager.getConnection(sourceDerby);
		
		} catch (Exception e){
			System.out.println("Error al conectar"); 
			e.printStackTrace();
			return null;

		}
		
	}
	
	public static void cerrar(){
		try {
			if (mysql!=null)
				mysql.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Error al cerrar la conexión");
		}
		
	}

}
