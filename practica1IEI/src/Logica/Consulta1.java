package Logica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Consulta1 extends Conexion{
	Statement s; ResultSet rs = null;
	public ResultSet transaciones() throws SQLException{
		
		try{
			s=this.mysql.createStatement();
			rs = s.executeQuery("SELECT NumTarjeta, Importe, EmisorTarjeta FROM db1.transacciones");
			return rs;
			//while(rs.next()){
				
			//}
		}
		catch(SQLException e){
			System.out.println("Error: "+e);
			return null;
		}
		
	}

}
