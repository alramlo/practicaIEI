package Logica;

import java.sql.SQLException;

public class TestSergio {
	
	public static void main(String[] args) throws SQLException {
		
		System.out.println("------------ Empezamos la prueba----------");
		
		Consulta2 c2 = new Consulta2();
		
		System.out.println("Ejecutado proceso de llenado de mydb.transaccionessin");
		
		c2.ejecutar();
	
		c2.cerrar();
		
		System.out.println("------------ Terminamos la prueba----------");

	}
}
