package Presentacion;

import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

import Logica.Consulta3;
import Modelo.Consulta3DTO;

public class TablaConsulta3 extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private JTable tablaConsulta3DTOs;
	private TableModel tablaConsulta3DTOModel;
	
	private Consulta3 consulta3DAO;
	private ResultSet rsResultado;

	public TablaConsulta3() {
		setResizable(false);
		setPreferredSize(new Dimension(600, 500));
		setBounds(100, 100, 835, 475);
		setLocationRelativeTo(null);
		{
			tablaConsulta3DTOModel = new TablaConsulta3Model();
			tablaConsulta3DTOs = new JTable();
			
			tablaConsulta3DTOs.setBounds(10, 11, 799, 415);
			tablaConsulta3DTOs.setModel(tablaConsulta3DTOModel);
			tablaConsulta3DTOs.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
			tablaConsulta3DTOs.setRowHeight(25);
			
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment( JLabel.LEFT );
			for(int i=0; i<4; i++)
			{
				tablaConsulta3DTOs.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
			}
		}
		
		getContentPane().setLayout(null);
		JScrollPane scrollPane = new JScrollPane(tablaConsulta3DTOs);
//		scrollPane.add(tablaConsulta3DTOs);
		scrollPane.setBounds(10, 10, 799, 417);
		getContentPane().add(scrollPane);
		
		setTitle("IEI Consulta 3 - Listado de tarjetas sospechas, con m\u00E1s de 5.000 euros en operaciones:");
		
		
	}
	
	class TablaConsulta3Model extends AbstractTableModel {

		private static final long serialVersionUID = 1L;
		// Columnas de la tabla
		private String[] columnas = {"ID OPERACIÓN", "NÚMERO DE TARJETA", "EMISOR", "IMPORTE TOTAL"};
		// Datos que muestra la tabla
		private ArrayList<Consulta3DTO> data = new ArrayList<Consulta3DTO>();

		public int getColumnCount() {
			return columnas.length;
		}
		public int getRowCount() {
			return data.size();
		}
		public String getColumnName(int col) {
			return columnas[col];
		}
		// Este método se dispara cada vez que la tabla necesita el valor de un campo
		public Object getValueAt(int row, int col) {
			Consulta3DTO c3 = data.get(row);
			switch(col){
			case 0: return c3.getIdOperacion();
			case 1: return c3.getNumTarjeta();
			case 2: return c3.getEmisor();
			case 3: return c3.getImporteTotal();
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
		public void addRow(Consulta3DTO row) {
			data.add(row);
			this.fireTableDataChanged();
		}
		public void delRow(int row) {
			data.remove(row);
			this.fireTableDataChanged();
		}
	}
	
	public void cargaConsulta3DTO(){
		try{
				TablaConsulta3Model model = (TablaConsulta3Model)tablaConsulta3DTOs.getModel();
				model.clear();
				
				consulta3DAO = new Consulta3();
				rsResultado = consulta3DAO.getResultado();
				Consulta3DTO c3 = null;
				while (rsResultado.next()){
					c3 = new Consulta3DTO();
						c3.setIdOperacion(rsResultado.getInt("idOperacion"));
						c3.setNumTarjeta(rsResultado.getString("numeroTarjeta"));
						c3.setEmisor(rsResultado.getString("emisor"));
						c3.setImporteTotal(rsResultado.getFloat("importe"));
					model.addRow(c3);
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
