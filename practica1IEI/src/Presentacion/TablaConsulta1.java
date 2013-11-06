package Presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
import javax.swing.table.TableModel;

import Logica.Consulta1;
import Modelo.Consulta1DTO;
import javax.swing.JScrollPane;
import java.awt.ScrollPane;

public class TablaConsulta1 extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private JTable tablaConsulta1DTOs;
	private TableModel tablaConsulta1DTOModel;
	
	private Consulta1 consulta1DAO;
	private ResultSet rsResultado;
	
//	private List<Consulta1DTO> listaConsulta1DTO;


	public TablaConsulta1() {
		setPreferredSize(new Dimension(600, 500));
		setBounds(100, 100, 835, 475);
		{
			tablaConsulta1DTOModel = new TablaConsulta1Model();
		}
		getContentPane().setLayout(null);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(10, 10, 799, 417);
		getContentPane().add(scrollPane);
		tablaConsulta1DTOs = new JTable();
//		getContentPane().add(tablaConsulta1DTOs);
		scrollPane.add(tablaConsulta1DTOs);
		tablaConsulta1DTOs.setBounds(10, 11, 799, 415);
		tablaConsulta1DTOs.setModel(tablaConsulta1DTOModel);
		tablaConsulta1DTOs.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		tablaConsulta1DTOs.setRowHeight(25);
		
	}
	
	class TablaConsulta1Model extends AbstractTableModel {

		private static final long serialVersionUID = 1L;
		// Columnas de la tabla
		private String[] columnNames = {"ID CLIENTE", "NOMBRE CLIENTE", "NÚMERO DE TARJETA", "EMISOR", "MONTO OPERACIONES"};
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
				TablaConsulta1Model model = (TablaConsulta1Model)tablaConsulta1DTOs.getModel();
				model.clear();
				
				consulta1DAO = new Consulta1();
				rsResultado = consulta1DAO.getResultado();
//				listaConsulta1DTO =  new ArrayList<Consulta1DTO>();
				Consulta1DTO c1 = null;
				while (rsResultado.next()){
					c1 = new Consulta1DTO();
						c1.setIdCliente(rsResultado.getInt("idCliente"));
						c1.setNombreCliente(rsResultado.getString("nombreCliente"));
						c1.setNumTarjeta(rsResultado.getString("numeroTarjeta"));
						c1.setEmisor(rsResultado.getString("emisor"));
						c1.setMontoOperaciones(rsResultado.getFloat("montoOperaciones"));
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
