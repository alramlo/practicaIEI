package Logica;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Consulta2 extends Conexion{
	
	Statement s, s1, s2; 
	ResultSet rs = null, rs2 = null;
	String consulta="", descOp="", numTar="", emiTar="";
	int idTrans;
	Date fecha;
	Float importe;
	
	public Consulta2(){
		super();
		try {
			this.conectar();
			s=this.mysql.createStatement();
			s1=this.mysql.createStatement();
			s2=this.mysql.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e2){
			e2.printStackTrace();
		}
	}
	
	public void llenarTablaTransSinCliente(){
	
		try {
		
		consulta="SELECT * FROM mydb.transaccionesaux ta HAVING ta.tarjeta NOT IN"
				+ " (SELECT numeroTarjeta FROM mydb.listadoclientes lc)"; 
		s.executeQuery(consulta);
		rs=s.getResultSet();
		
		while(rs.next()){
			idTrans=rs.getInt("idTrans");
			descOp=rs.getString("Descr");
			fecha=rs.getDate("fecha");
			importe=rs.getFloat("importe");
			numTar=rs.getString("tarjeta");
			emiTar=rs.getString("emisor");
			
			consulta="INSERT INTO mydb.transaccionessin (idTrans, descr, fecha, importe, numeroTarjeta, emisorTarjeta) "
					+ "VALUES ("+idTrans+",'"+descOp+"','"+fecha+"',"+importe+",'"+numTar+"','"+emiTar+"')";
			s1.executeUpdate(consulta);
		}
		
		rs.close();
		s.close();
		s1.close();
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void getTarjetasSinClientes(){
		
		consulta="SELECT * FROM mydb.transaccionessin";
		
		try {
			s2.executeQuery(consulta);
			rs2=s2.getResultSet();
			
			s2.close();
			rs2.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
}
