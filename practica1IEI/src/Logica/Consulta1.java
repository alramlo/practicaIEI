package Logica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Consulta1 extends Conexion{
	private Statement s,s2,s3; 
	private ResultSet rs,clientes;
	
	public Consulta1() throws SQLException, ClassNotFoundException{
		
		super();
		this.conectar();
		s=this.mysql.createStatement();
		s2=this.mysql.createStatement();
		s3=this.mysql.createStatement();
	}
	
	public void ejecutar() throws SQLException{
		
		try{
			
			//Primero borramos los datos de la tabla de listado de clientes
			System.out.println("Borrado de listado de clientes");
			s.executeUpdate("DELETE FROM mydb.listadoclientes");
			
			//Listado de clientes
			System.out.println("Obtención de clientes");
			clientes=s.executeQuery("SELECT * FROM db3.clientes");
			
			//calculo del monto
			System.out.println("Cálculo de monto por cliente");
			while(clientes.next()){
					
					//monto
					//System.out.println("Cálculo");
					rs=s2.executeQuery("SELECT SUM(importe) FROM mydb.transaccionesaux WHERE tarjeta='"+clientes.getString(2)+"'");
					//System.out.println("Insercción");
					rs.next();
					s3.executeUpdate("INSERT INTO mydb.listadoclientes (idCliente, nombreCliente, numeroTarjeta, emisor, montoOperaciones) "
									+ "VALUES ("+clientes.getInt(1)+", '"+clientes.getString(7)+"', '"+clientes.getString(2)+"', '"+clientes.getString(6)+"', "+rs.getFloat(1)+")");
			}
			
			
		}catch(SQLException e){
			System.out.println("Error en Consulta1.ejecutar(): "+e);
			e.printStackTrace();
		}
		
	}
	
	public ResultSet getResultado() throws SQLException{
		try{
		
			s=this.mysql.createStatement();
			rs=s.executeQuery("SELECT * FROM mydb.listadoclientes");
			return rs;
		
		}catch(SQLException e){
			System.out.println("Error en Consulta1.getResultado(): "+e);
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
