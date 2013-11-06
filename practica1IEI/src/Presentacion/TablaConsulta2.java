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

import Logica.Consulta2;
import Modelo.Consulta2DTO;

public class TablaConsulta2 extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private JTable tablaConsulta2DTOs;
	private TableModel tablaConsulta2DTOModel;
	
	private Consulta2 consulta2DAO;
	private ResultSet rsResultado;

	public TablaConsulta2() {
		setResizable(false);
		setPreferredSize(new Dimension(600, 500));
		setBounds(100, 100, 835, 475);
		{
			tablaConsulta2DTOModel = new TablaConsulta2Model();
			tablaConsulta2DTOs = new JTable();
			
			tablaConsulta2DTOs.setBounds(10, 11, 799, 415);
			tablaConsulta2DTOs.setModel(tablaConsulta2DTOModel);
			tablaConsulta2DTOs.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
			tablaConsulta2DTOs.setRowHeight(25);
			
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment( JLabel.LEFT );
			for(int i=0; i<6; i++)
			{
				tablaConsulta2DTOs.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
			}
		}
		
		getContentPane().setLayout(null);
		JScrollPane scrollPane = new JScrollPane(tablaConsulta2DTOs);
//		scrollPane.add(tablaConsulta2DTOs);
		scrollPane.setBounds(10, 10, 799, 417);
		getContentPane().add(scrollPane);
		
		setTitle("IEI Consulta 2 - Listado de transacciones que no tienen cliente asociado:");
		
		
	}
	
	class TablaConsulta2Model extends AbstractTableModel {

		private static final long serialVersionUID = 1L;
		// Columnas de la tabla
		private String[] columnas = {"ID TRANSACCIÓN", "DESCRIPCIÓN OPERACIÓN", "FECHA", "IMPORTE", "NÚMERO TARJETA", "EMISOR TARJETA"};
		// Datos que muestra la tabla
		private ArrayList<Consulta2DTO> data = new ArrayList<Consulta2DTO>();

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
			Consulta2DTO c2 = data.get(row);
			switch(col){
			case 0: return c2.getIdTransaccion();
			case 1: return c2.getDescripcionOperacion();
			case 2: return c2.getFecha();
			case 3: return c2.getImporte();
			case 4: return c2.getNumTarjeta();
			case 5: return c2.getEmisor();
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
		public void addRow(Consulta2DTO row) {
			data.add(row);
			this.fireTableDataChanged();
		}
		public void delRow(int row) {
			data.remove(row);
			this.fireTableDataChanged();
		}
	}
	
	public void cargaConsulta2DTO(){
		try{
				TablaConsulta2Model model = (TablaConsulta2Model)tablaConsulta2DTOs.getModel();
				model.clear();
				
				consulta2DAO = new Consulta2();
				rsResultado = consulta2DAO.getResultado();
				Consulta2DTO c2 = null;
				while (rsResultado.next()){
					c2 = new Consulta2DTO();
						c2.setIdTransaccion(rsResultado.getInt("idTrans"));
						c2.setDescripcionOperacion(rsResultado.getString("descr"));
						c2.setFecha(rsResultado.getDate("fecha"));
						c2.setImporte(rsResultado.getFloat("importe"));
						c2.setNumTarjeta(rsResultado.getString("numeroTarjeta"));
						c2.setEmisor(rsResultado.getString("emisorTarjeta"));
					model.addRow(c2);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e){
				JOptionPane.showMessageDialog(this,e.getMessage(),"ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
	}
}
