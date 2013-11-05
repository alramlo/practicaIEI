package Logica;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.text.TabableView;

public class TestLogica {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		ResultSet rs =null;
		
		System.out.println("------------ Empezamos la prueba----------");
		
		TablaAux ta = new TablaAux();
		Consulta1 c1 = new Consulta1();
		
		ta.ejecutar();
		ta.cerrar();
		
		c1.ejecutar();
		c1.cerrar();
		
		System.out.println("------------ Terminamos la prueba----------");

	}

}
