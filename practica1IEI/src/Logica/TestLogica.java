package Logica;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.text.TabableView;

public class TestLogica {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		ResultSet rs =null;
		
		System.out.println("------------ Empezamos la prueba----------");
		
		Conexion co = new Conexion();
		TablaAux ta = new TablaAux();
		Consulta1 c1 = new Consulta1();
		
		co.conectar();
		ta.ejecutar();
		c1.ejecutar();
		
		System.out.println("------------ Terminamos la prueba----------");

	}

}
