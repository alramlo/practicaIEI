package Logica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consulta3 extends Conexion{
	
	private Statement s,s2,s3;
	private ResultSet rs, clientes;
	
	public Consulta3 () throws SQLException, ClassNotFoundException{
		
		super();
		this.conectar();
		s=this.mysql.createStatement();
		s2=this.mysql.createStatement();
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
			clientes=s.executeQuery("SELECT * FROM mydb.listadoclientes WHERE montoOperaciones>5000");
			
			
			
			while(clientes.next()){
					

					rs=s2.executeQuery("SELECT idTrans, tarjeta, emisor, importe FROM mydb.transaccionesaux WHERE tarjeta='"+clientes.getString(4)+"'");
					rs.next();
					s3.executeUpdate("INSERT INTO mydb.tarjetassospechosas (idOperacion, numeroTarjeta, emisor, importe) "
									+ "VALUES ("+rs.getInt(1)+", '"+rs.getString(2)+"', '"+rs.getString(3)+"', "+rs.getFloat(4)+")");
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
			rs.close();
			clientes.close();
			s.close();
			s2.close();
			s3.close();
			
		}catch(SQLException e){
			
			System.out.println("Error en Consulta1.cerrar(): "+e);
			e.printStackTrace();
			
		}
		
	}

}
