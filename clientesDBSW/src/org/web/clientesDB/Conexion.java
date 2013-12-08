package org.web.clientesDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	
	private Connection mysql;

	
	public Conexion(){
			
			this.mysql=null;	
	}

	public Connection conectar(){
		try{
			
		Class.forName("com.mysql.jdbc.Driver");
		mysql = DriverManager.getConnection("jdbc:mysql://db4free.net/practica4", "iei2013", "123456");
		return mysql;
		
		} catch (Exception e){
			System.out.println("Error al conectar"); 
			e.printStackTrace();
			return null;

		}
		
	}
	
	public void cerrar(){
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
