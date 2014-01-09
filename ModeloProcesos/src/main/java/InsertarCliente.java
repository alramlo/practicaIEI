import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class InsertarCliente implements org.activiti.engine.delegate.JavaDelegate {
	
	private Connection mysql;
	private String sourceMysql;
	
	private Integer codigoCliente;
	private Integer codigoArticulo;
	private Integer cantidad;
	private String nombre;
	private String direccion;
	private String poblacion;
	private String email;
	private Date fechaAlta;

	@Override
	public void execute(DelegateExecution arg0) throws Exception {
		// TODO Auto-generated method stub
		
		codigoCliente = (Integer) arg0.getVariable("codigoCliente");
		nombre = (String) arg0.getVariable("nombre");
		direccion = (String) arg0.getVariable("direccion");
		poblacion = (String) arg0.getVariable("poblacion");
		email = (String) arg0.getVariable("email");
		fechaAlta = (Date) arg0.getVariable("fechaAlta");
		conectar();
		insertar();
		
		
		
	}
	
	public void insertar(){
		
		Statement s;
		try {
			s= mysql.createStatement();
			s.executeUpdate("INSERT INTO activiti.clientes (idCliente,nombre,direccion,poblacion,email,fechaAlta,credito) "
					+ "VALUES ("+codigoCliente+", '"+nombre+"', '"+direccion+"', '"+poblacion+"', '"+email+"', "+fechaAlta+", "+2000+")");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void conectar() throws ClassNotFoundException{
			try{
			
			sourceMysql="jdbc:mysql://localhost:3306/";
			Class.forName("com.mysql.jdbc.Driver");
			mysql = DriverManager.getConnection (sourceMysql,"ieiactiviti", "ieiactiviti");
			
			
			} catch (Exception e){
				System.out.println("Error al conectar: "+e); 
				e.printStackTrace();

			}
	}
		

}
