package Logica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TablaAux extends Conexion{
	
	private String consulta;
	private Statement s;
	private ResultSet rs;
	
	//Constructor
	public TablaAux() throws ClassNotFoundException{
		super();
		this.s=null;
		this.rs=null;
		this.consulta="";
		this.conectar();
		
	}
	
	public void ejecutar() throws SQLException{
		
		try{
			
			s=this.mysql.createStatement();
			
			//Borrado
			s.executeUpdate("DELETE FROM mydb.transaccionesaux");
			
			//LLenado de transacciones desde db1
			System.out.println("Transacciones de db1");
			s.executeUpdate("INSERT INTO mydb.transaccionesaux (idTrans, tarjeta, fecha, emisor, importe, descr) SELECT IdTransaccion, NumTarjeta, Fecha, EmisorTarjeta, Importe, DescripcionOp  FROM db1.transacciones");
			
			//LLenado de transacciones desde derby
			System.out.println("Transacciones de derby");
			s=this.derby.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=s.executeQuery("SELECT IDTRANSACCION, NUMEROTARJETA, FECHA, EMISORTARJETA, IMPORTE, DESCRIPCIONOP FROM APP.TRANSACCIONES");
			
			//Creación de la consulta de llenado desde derby
			System.out.println("Creación de consulta Derby");
			consulta="INSERT INTO mydb.transaccionesaux (idTrans, tarjeta, fecha, emisor, importe, descr ) VALUES ";

			while(rs.next())
			{
				if(rs.isLast())
					consulta=consulta+"("
										+rs.getInt(1)+", '"
										+rs.getString(2)+"', '"
										+rs.getDate(3)+"', '"
										+rs.getString(4)+"', "
										+rs.getFloat(5)+", '" 
										+rs.getString(6)+"')";
				else
					consulta=consulta+"("
							+rs.getInt(1)+", '"
							+rs.getString(2)+"', '"
							+rs.getDate(3)+"', '"
							+rs.getString(4)+"', "
							+rs.getFloat(5)+", '" 
							+rs.getString(6)+"'),";
			}
			
			System.out.println("Consulta --> "+consulta);
			
			System.out.println("Llenado desde Derby");
			
			s=this.mysql.createStatement();
			s.executeUpdate(consulta);
		
		}catch(SQLException e){
			System.out.println("Error en TablaAux.ejecutar(): "+e);
			
		}
		
	}

}
