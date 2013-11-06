package Presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import Logica.Consulta1;
import Modelo.Consulta1DTO;

public class TablaConsulta1 extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private Consulta1 consulta1DAO;
	private ResultSet rsResultado;
//	private List<Consulta1DTO> listaConsulta1DTO;

	/**
	 * Create the dialog.
	 */
	public TablaConsulta1() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			table = new JTable();
			contentPanel.add(table, BorderLayout.CENTER);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnCerrar = new JButton("Cerrar");
				btnCerrar.setActionCommand("Cancel");
				buttonPane.add(btnCerrar);
			}
		}
	}
	
	class TablaConsultaModel extends AbstractTableModel {

		private static final long serialVersionUID = 1L;
		// Columnas de la tabla
		private String[] columnNames = { "ID CLIENTE", "NOMBRE CLIENTE", "TARJETA", "EMISOR", "MONTO OPERACIONES"};
		// Datos que muestra la tabla
		private ArrayList<Consulta1DTO> data = new ArrayList<Consulta1DTO>();

		public int getColumnCount() {
			return columnNames.length;
		}
		public int getRowCount() {
			return data.size();
		}
		public String getColumnName(int col) {
			return columnNames[col];
		}
		// Este método se dispara cada vez que la tabla necesita el valor de un campo
		public Object getValueAt(int row, int col) {
			Consulta1DTO c1 = data.get(row);
			switch(col){
			case 0: return c1.getIdCliente();
			case 1: return c1.getNombreCliente();
			case 2: return c1.getNumTarjeta();
			case 3: return c1.getEmisor();
			case 4: return c1.getMontoOperaciones();
			default: return null;
			}
		}
		public void clear(){
			data.clear();
		}
		/*
		 * JTable uses this method to determine the default renderer/
		 * editor for each cell. If we didn't implement this method,
		 * then the last column would contain text ("true"/"false"),
		 * rather than a check box.
		 */
		public Class<? extends Object>getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}
		public void addRow(Consulta1DTO row) {
			data.add(row);
			this.fireTableDataChanged();
		}
		public void delRow(int row) {
			data.remove(row);
			this.fireTableDataChanged();
		}
	}
	
	public void cargaConsulta1DTO(){
		try{
				TablaConsultaModel model=(TablaConsultaModel)table.getModel();
				model.clear();
				
				consulta1DAO = new Consulta1();
				rsResultado = consulta1DAO.getResultado();
//				listaConsulta1DTO =  new ArrayList<Consulta1DTO>();
				Consulta1DTO c1 = null;
				while (rsResultado.next()){
					c1 = new Consulta1DTO();
						c1.setIdCliente(rsResultado.getInt(1));
						c1.setNombreCliente(rsResultado.getString(2));
						c1.setNumTarjeta(rsResultado.getString(3));
						c1.setEmisor(rsResultado.getString(4));
						c1.setMontoOperaciones(rsResultado.getFloat(5));
					model.addRow(c1);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e){
				JOptionPane.showMessageDialog(this,e.getMessage(),"ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
	}
}
