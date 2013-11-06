package Modelo;

public class Consulta1DTO {
	
	private int idCliente;
	private String nombreCliente;
	private String numTarjeta;
	private String emisor;
	private float montoOperaciones;
	
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getNumTarjeta() {
		return numTarjeta;
	}
	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}
	public String getEmisor() {
		return emisor;
	}
	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}
	public float getMontoOperaciones() {
		return montoOperaciones;
	}
	public void setMontoOperaciones(float montoOperaciones) {
		this.montoOperaciones = montoOperaciones;
	}
	
}
