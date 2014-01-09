

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class calcularPrecio implements JavaDelegate {
	
	private Connection mysql;
	private String sourceMysql;
	
	private Integer codigoCliente;
	private Integer codigoArticulo;
	private Integer cantidad;

	@Override
	public void execute(DelegateExecution arg0) throws Exception {
		
		codigoCliente = ((Integer) arg0.getVariable("codigoCliente"));
		codigoArticulo = ((Integer) arg0.getVariable("codigoArticulo"));
		cantidad = ((Integer) arg0.getVariable("cantidad"));

		conectar();
		calculaPrecio(arg0);
		
	}
	
private void calculaPrecio(DelegateExecution arg0){
		
	Statement s;
	ResultSet rs = null;

	// Obtenemos el limite de crédito del cliente
	float limiteCredito = 0;
	try {
		s= mysql.createStatement();
		
		s.executeUpdate("SELECT credito FROM activiti.clientes WHERE idCliente = "+ codigoCliente);
		
		rs = s.getResultSet();
		while (rs.next()) {
			limiteCredito = rs.getFloat(1);
		}
		
		rs.close();
		s.close();
		
		
		// Obtenemos el precio del artículo a comprar
		float precio = 0;
		Statement s2 = mysql.createStatement();
		s2.executeUpdate("SELECT precio FROM activiti.articulos WHERE id = "+ codigoArticulo);
		ResultSet rs2 = s2.getResultSet();
		while (rs2.next()) {
			precio = rs2.getFloat(1);
		}

		// Calculamos el precio total y comprobamos si el limite ha sido
		// superado
		float precioTotal = precio * cantidad;

		if (precioTotal > limiteCredito) {
			arg0.setVariable("supera", true);
		} else {
			arg0.setVariable("supera", false);
		}
		
		arg0.setVariable("precioTotal", precioTotal);
		
	} catch (SQLException e) {
		
		e.printStackTrace();
		
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
