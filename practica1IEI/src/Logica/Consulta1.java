package Logica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Consulta1 extends Conexion{
	Statement s; 
	ResultSet rs = null;
	String consulta ="";
	public void transacionesAux() throws SQLException{
		
		try{
			//LLenado de transacciones desde db1
			System.out.println("Transacciones de db1");
			s=this.mysql.createStatement();
			s.executeUpdate("DELETE FROM mydb.transaccionesaux");
			s.executeUpdate("INSERT INTO mydb.transaccionesaux (tarjeta, importe, emisor) SELECT NumTarjeta, Importe, EmisorTarjeta FROM db1.transacciones");
			
			//LLenado de transacciones desde derby
			System.out.println("Transacciones de derby");
			s=this.derby.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=s.executeQuery("SELECT NumeroTarjeta, Importe, EmisorTarjeta FROM APP.TRANSACCIONES");
			consulta="INSERT INTO mydb.transaccionesaux (tarjeta, importe, emisor) VALUES ";
			System.out.println("Creación de consulta Derby");

			while(rs.next())
			{
				
				if(rs.isLast())
					consulta=consulta+"('"+rs.getString(1)+"', "+rs.getFloat(2)+", '"+rs.getString(3)+"')";
				else
					consulta=consulta+"('"+rs.getString(1)+"', "+rs.getFloat(2)+", '"+rs.getString(3)+"'),";

			}
			System.out.println("Consulta --> "+consulta);
			System.out.println("Llenado desde Derby");
			s=this.mysql.createStatement();
			s.executeUpdate(consulta);
			
		}catch(SQLException e){
			System.out.println("Error en Consulta1.transacionesAux(): "+e);
		}
		
	}

}
