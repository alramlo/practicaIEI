package Logica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consulta3 extends Conexion{
	
	private Statement s,s3;
	private ResultSet rs, clientes;
	
	public Consulta3 () throws SQLException, ClassNotFoundException{
		
		super();
		this.conectar();
		s=this.mysql.createStatement();
		s3=this.mysql.createStatement();
		
	}
	
	public void ejecutar() throws SQLException{
		
		try{
			
			//Primero borramos
			System.out.println("Borrado del listado de tarjetas sospechosas");
			s.executeUpdate("DELETE FROM mydb.tarjetassospechosas");
			
			//Busqueda de operaciones sospechosas
			System.out.println("Búsqueda de tarjetas sospechosas");
			
			//Listado de clientes con montos superiores a 5000
			clientes=s.executeQuery("SELECT id, idTrans, tarjeta, fecha, emisor, importeTotal, descr FROM (SELECT id, idTrans, tarjeta, fecha, emisor, sum(importe) as importeTotal, descr FROM mydb.transaccionesaux GROUP BY tarjeta) as Consulta  WHERE Consulta.importeTotal > 5000;");
			
			while(clientes.next()){
					
					s3.executeUpdate("INSERT INTO mydb.tarjetassospechosas (idOperacion, numeroTarjeta, emisor, importe) "
									+ "VALUES ("+clientes.getInt("idTrans")+", '"+clientes.getString("tarjeta")+"', '"+clientes.getString("emisor")+"', "+clientes.getFloat("importeTotal")+")");
					
			}
			
			
		}catch(SQLException e){
			System.out.println("Error en Consulta3.ejecutar(): "+e);
			e.printStackTrace();
		}
		
	}
	
	public ResultSet getResultado() throws SQLException{
		try{
		
			s=this.mysql.createStatement();
			rs=s.executeQuery("SELECT * FROM mydb.tarjetassospechosas");
			return rs;
		
		}catch(SQLException e){
			System.out.println("Error en Consulta3.getResultado(): "+e);
			e.printStackTrace();
			return null;

		}


	}
	
	public void cerrar() throws SQLException{
		
		try{
			
			//Cerramos todo
			clientes.close();
			s.close();
			s3.close();
			
		}catch(SQLException e){
			
			System.out.println("Error en Consulta1.cerrar(): "+e);
			e.printStackTrace();
			
		}
		
	}

}
