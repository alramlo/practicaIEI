package Logica;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestLogica {

	public static void main(String[] args) throws SQLException {

		ResultSet rs =null;
		System.out.println("------------ Empezamos la prueba----------");
		Consulta1 consulta1 = new Consulta1();
		consulta1.transacionesAux();
		System.out.println("Ejecutado proceso de llenado de TransaccionesAux.");
		System.out.println("------------ Terminamos la prueba----------");

	}

}
