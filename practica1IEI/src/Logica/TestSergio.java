package Logica;

import java.sql.SQLException;

public class TestSergio {
	
	public static void main(String[] args) throws SQLException {
		
		System.out.println("------------ Empezamos la prueba----------");
		
		Conexion co = new Conexion();
		Consulta2 c2 = new Consulta2();
		
		System.out.println("Ejecutado proceso de llenado de mydb.transaccionessin");
		
		try {
			co.conectar();
			c2.llenarTablaTransSinCliente();
			
			//c2.getTarjetasSinClientes();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("------------ Terminamos la prueba----------");

	}
}
