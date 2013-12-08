package org.web.clientesDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Consulta1 {
	private Statement s; 
	private ResultSet rs;
	private Connection conn;
	
	
	
	
	public Cliente[] getResultado() throws SQLException{
		Conexion conexion=null;
		try{
			conexion = new Conexion();
			conn = conexion.conectar();
			
			if(conn!=null){
				
				s=conn.createStatement();
				rs=s.executeQuery("SELECT * FROM practica4.listadoclientes");
				ArrayList list = new ArrayList();
				while(rs.next()){
					Cliente cliente = new Cliente();
					cliente.setId(rs.getInt("id"));
					cliente.setIdCliente(rs.getInt("idCliente"));
					cliente.setNombre(rs.getString("nombreCliente"));
					cliente.setNumeroTarjeta(rs.getString("numeroTarjeta"));
					cliente.setEmisor(rs.getString("emisor"));
					cliente.setMonto(rs.getFloat("montoOperaciones"));
					list.add(cliente);
					
					
				}
				
				return (Cliente[])list.toArray(new Cliente[list.size()]);
			}
			
			}catch(SQLException e){
				System.out.println("Error en Consulta1.getResultado(): "+e);
				e.printStackTrace();
			}
		
		conexion.cerrar();
		return null;


	}
	

}
