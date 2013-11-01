package Logica;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestLogica {

	public static void main(String[] args) throws SQLException {

		ResultSet rs =null;
		System.out.println("------------ Empezamos la prueba----------");
		Consulta1 consulta1 = new Consulta1();
		rs=consulta1.transaciones();
		System.out.println("Transacciones:");
		while(rs.next()){
			System.out.println("Id: "+rs.getString(1));
			
		}
		System.out.println("------------ Terminamos la prueba----------");

	}

}
