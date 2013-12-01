package testCalculadora;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.web.backend.calculadora.CalculadoraStub;
import org.web.backend.calculadora.CalculadoraStub.Divide;
import org.web.backend.calculadora.CalculadoraStub.DivideResponse;

public class TestCalculadora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalculadoraStub stub=null;
		try {
			stub = new CalculadoraStub();
		} catch (AxisFault ae) {
			// TODO: handle exception
			ae.printStackTrace();
		}
		
		Divide operacion = new Divide();
		operacion.setI(10);
		operacion.setJ(2);
		DivideResponse res = null;
		try {
			res = stub.divide(operacion);
		} catch (RemoteException re) {
			// TODO: handle exception
			re.printStackTrace();
		}
		System.out.println("El resultado de 10/2 = "+res.get_return());
	}

}
