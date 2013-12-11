package interfaz;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

import org.web.clientesdb.ClienteDBSWStub.Cliente;

public class TablaConsulta extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private JTable tablaConsulta1DTOs;
	private TableModel tablaConsulta1DTOModel;
	
//	private ResultSet rsResultado;

	public TablaConsulta() {
		setResizable(false);
		setPreferredSize(new Dimension(600, 500));
		setBounds(100, 100, 835, 475);
		setLocationRelativeTo(null);
		{
			tablaConsulta1DTOModel = new TablaConsulta1Model();
			tablaConsulta1DTOs = new JTable();
			
			tablaConsulta1DTOs.setBounds(10, 11, 799, 415);
			tablaConsulta1DTOs.setModel(tablaConsulta1DTOModel);
			tablaConsulta1DTOs.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
			tablaConsulta1DTOs.setRowHeight(25);	

			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment( JLabel.LEFT );
			for(int i=0; i<5; i++)
			{
				tablaConsulta1DTOs.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
			}
			
		}
		
		getContentPane().setLayout(null);
		JScrollPane scrollPane = new JScrollPane(tablaConsulta1DTOs);
//		scrollPane.add(tablaConsulta1DTOs);
		scrollPane.setBounds(10, 10, 799, 417);
		getContentPane().add(scrollPane);
		
		setTitle("IEI Consulta - Listado con los clientes y el monto total de las transacciones de su tarjeta:");
		
		
	}
	
	class TablaConsulta1Model extends AbstractTableModel {

		private static final long serialVersionUID = 1L;
		// Columnas de la tabla
		private String[] columnas = {"ID CLIENTE", "NOMBRE CLIENTE", "NÚMERO DE TARJETA", "EMISOR", "MONTO OPERACIONES"};
		// Datos que muestra la tabla
		private ArrayList<Cliente> data = new ArrayList<Cliente>();

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
			Cliente c1 = data.get(row);
			switch(col){
			case 0: return c1.getIdCliente();
			case 1: return c1.getNombre();
			case 2: return c1.getNumeroTarjeta();
			case 3: return c1.getEmisor();
			case 4: return c1.getMonto();
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
		public void addRow(Cliente row) {
			data.add(row);
			this.fireTableDataChanged();
		}
		public void delRow(int row) {
			data.remove(row);
			this.fireTableDataChanged();
		}
	}
	
	public void cargaConsulta(){
		try{
				TablaConsulta1Model model = (TablaConsulta1Model)tablaConsulta1DTOs.getModel();
				model.clear();
				
				Cliente[] clnt = InicioGUI.obtenerClientes();
				for (Cliente cliente : clnt) {
					model.addRow(cliente);
				}

		} catch (Exception e){
				JOptionPane.showMessageDialog(this,e.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
}
