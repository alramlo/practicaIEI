package Logica;

import java.sql.SQLException;

public class TestLogica {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

//		ResultSet rs =null;
		
		System.out.println("------------ Empezamos la prueba----------");
		
//		TablaAux ta = new TablaAux();
//		Consulta1 c1 = new Consulta1();
//		Consulta2 c2 = new Consulta2();
		Consulta3 c3 = new Consulta3();
		
		//ta.ejecutar();
		//ta.cerrar();
		
		//c1.ejecutar();
		//c1.cerrar();
		
		c3.ejecutar();
		c3.cerrar();
		
		System.out.println("------------ Terminamos la prueba----------");

	}

}
