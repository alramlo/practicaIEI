package Logica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Consulta1 extends Conexion{
	Statement s,s2,s3,s4; 
	ResultSet rs = null,tarjetas=null,cliente=null;
	String consulta ="";
	public void transacionesAux() throws SQLException{
		
		try{
			s=this.mysql.createStatement();
			
			//Borrado
			s.executeUpdate("DELETE FROM mydb.transaccionesaux");
			s.executeUpdate("DELETE FROM mydb.listadoclientes");
			
			//LLenado de transacciones desde db1
			System.out.println("Transacciones de db1");
			s.executeUpdate("INSERT INTO mydb.transaccionesaux (tarjeta, importe, emisor) SELECT NumTarjeta, Importe, EmisorTarjeta FROM db1.transacciones");
			
			//LLenado de transacciones desde derby
			System.out.println("Transacciones de derby");
			s=this.derby.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=s.executeQuery("SELECT NumeroTarjeta, Importe, EmisorTarjeta FROM APP.TRANSACCIONES");
			
			//Creación de la consulta
			System.out.println("Creación de consulta Derby");
			consulta="INSERT INTO mydb.transaccionesaux (tarjeta, importe, emisor) VALUES ";

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
			
			
			//tarjetas diferentes que hay en todas las transacciones
			tarjetas=s.executeQuery("SELECT DISTINCT tarjeta FROM mydb.transaccionesaux");
			
			//calculo del monto
			
			s2=this.mysql.createStatement();
			s3=this.mysql.createStatement();
			s4=this.mysql.createStatement();
			
			while(tarjetas.next()){
				//cliente
				cliente=s2.executeQuery("SELECT nombreCliente FROM db3.clientes WHERE NumTarjeta='"+tarjetas.getString(1)+"'");
				if(cliente.next()){
					//monto
					rs=s3.executeQuery("SELECT SUM(importe) FROM mydb.transaccionesaux WHERE tarjeta='"+tarjetas.getString(1)+"'");
					//Insert de la tupla
					if(rs.next()){
						//s4.executeUpdate("INSERT INTO mydb.listadoclientes (nombreCliente, numeroTarjeta, emisor, montoOperaciones) "
								//+ "VALUES ('"+cliente.getString(1)+"', '"+tarjetas.getString(1)+"', '"+tarjetas.getString(2)+"', "+rs.getFloat(1)+")");
						s4.executeUpdate("INSERT INTO mydb.listadoclientes (nombreCliente, numeroTarjeta, montoOperaciones) "
								+ "VALUES ('"+cliente.getString(1)+"', '"+tarjetas.getString(1)+"', "+rs.getFloat(1)+")");
					}
				}
			}
			
		}catch(SQLException e){
			System.out.println("Error en Consulta1.transacionesAux(): "+e);
		}
		
	}

}
