package Logica;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestLogica {

	public static void main(String[] args) throws SQLException {

		ResultSet rs =null;
		
		System.out.println("------------ Empezamos la prueba----------");
		
		Consulta1 consulta1 = new Consulta1();
		System.out.println("Ejecutado proceso de llenado de TransaccionesAux.");
		consulta1.ejecutar();
		
		System.out.println("------------ Terminamos la prueba----------");

	}

}
