

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class GuardarDatosDenegacion implements JavaDelegate {
	
	private Connection mysql;
	private String sourceMysql;

	private boolean supera;
	private boolean autorizado;
	private Integer codigoArticulo;
	private String motivo;
	private Integer codigoCliente;
	private Integer cantidad;
	
	@Override
	public void execute(DelegateExecution arg0) throws Exception {
		
		supera = (boolean) arg0.getVariable("supera");
		autorizado = (boolean) arg0.getVariable("autorizado");
		motivo = (String) arg0.getVariable("motivo");
		codigoArticulo = (Integer) arg0.getVariable("codigoArticulo");
		codigoCliente = (Integer) arg0.getVariable("codigoCliente");
		cantidad = ((Integer) arg0.getVariable("cantidad"));

		conectar();
	
		Date fechaActual = new Date();
		if(!supera || (supera && autorizado) ){
			Statement s = mysql.createStatement();
			s.executeUpdate("INSERT INTO activiti.pedidos VALUES ("+codigoArticulo+", "+codigoCliente+", "+cantidad+", true, \"\", "+fechaActual);
			s.close();
		}else if(supera && !autorizado){
			Statement s = mysql.createStatement();
			s.executeUpdate("INSERT INTO activiti.pedidos VALUES ("+codigoArticulo+", "+codigoCliente+", "+cantidad+", false, "+motivo+", "+fechaActual);
		}
		
	}
	
	private void conectar() throws ClassNotFoundException{
			try{
			
			sourceMysql="jdbc:mysql://db4free.net:3306/";
			Class.forName("com.mysql.jdbc.Driver");
			mysql = DriverManager.getConnection (sourceMysql,"ieiactiviti", "ieiactiviti");
			
			
			} catch (Exception e){
				System.out.println("Error al conectar: "+e); 
				e.printStackTrace();

			}
	}

}
