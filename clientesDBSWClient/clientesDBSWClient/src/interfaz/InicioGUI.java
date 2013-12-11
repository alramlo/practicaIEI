package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import org.apache.axis2.AxisFault;
import org.web.clientesdb.ClienteDBSWStub;
import org.web.clientesdb.ClienteDBSWStub.Cliente;
import org.web.clientesdb.ClienteDBSWStub.GetResultadoResponse;
import org.web.clientesdb.SQLExceptionException;

public class InicioGUI {

	private JFrame frmIeiCurso;
	private JButton btnPoblarBD;
	private JLabel lblMensajeCargaOK;
	private JLabel lblAntesDeRealizar;
//	private PoblandoBBDD dialog;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
						UIManager.setLookAndFeel(new NimbusLookAndFeel());
						InicioGUI window = new InicioGUI();
						window.frmIeiCurso.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InicioGUI()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIeiCurso = new JFrame();
		frmIeiCurso.setPreferredSize(new Dimension(800, 400));
		frmIeiCurso.setSize(new Dimension(800, 400));
		frmIeiCurso.setMinimumSize(new Dimension(800, 400));
		frmIeiCurso.setMaximumSize(new Dimension(800, 400));
		frmIeiCurso.setTitle("IEI Curso 2013-2014");
		frmIeiCurso.setBounds(100, 100, 800, 400);
		frmIeiCurso.setLocationRelativeTo(null);
		frmIeiCurso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelNorte = new JPanel();
		panelNorte.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		frmIeiCurso.getContentPane().add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel("IEI Pr\u00E1ctica 2 - ");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 39));
		panelNorte.add(lblTitulo);
		
		JLabel lblSubTitulo = new JLabel("Consumir Servicios Web");
		lblSubTitulo.setFont(new Font("Tahoma", Font.PLAIN, 34));
		panelNorte.add(lblSubTitulo);
		
		JLabel lblIconInfo = new JLabel("");
		lblIconInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InfoEquipo ventanaEquipo = new InfoEquipo();
				ventanaEquipo.setModal(true);
				ventanaEquipo.setLocationRelativeTo(null);
				ventanaEquipo.setVisible(true);
			}
		});
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panelNorte.add(horizontalStrut);
		
		lblIconInfo.setIcon(new ImageIcon(InicioGUI.class.getResource("/resources/information32x32.png")));
		panelNorte.add(lblIconInfo);
		
		JPanel panelCentral = new JPanel();
		frmIeiCurso.getContentPane().add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);
		
		JPanel panelConsulta1 = new JPanel();
		panelConsulta1.setBounds(41, 110, 711, 146);
		panelCentral.add(panelConsulta1);
		panelConsulta1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Consulta:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		panelConsulta1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listado con los clientes y el monto total de las transacciones de su tarjeta:\r\n");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 27, 691, 25);
		panelConsulta1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		JButton btnVerC1 = new JButton("Ver Consulta");
		btnVerC1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablaConsulta ventanaTabla1 = new TablaConsulta();
				ventanaTabla1.setModal(true);
				ventanaTabla1.cargaConsulta();
				ventanaTabla1.setVisible(true);
			}
		});
		btnVerC1.setIcon(new ImageIcon(InicioGUI.class.getResource("/resources/searchDB.png")));
		btnVerC1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVerC1.setBounds(268, 79, 175, 40);
		panelConsulta1.add(btnVerC1);
		
		lblAntesDeRealizar = new JLabel("El almac\u00E9n de datos ya ha sido poblado mediante Clover ETL\r\n");
		lblAntesDeRealizar.setForeground(Color.GRAY);
		lblAntesDeRealizar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAntesDeRealizar.setBounds(53, 53, 514, 40);
		panelCentral.add(lblAntesDeRealizar);
		
		lblMensajeCargaOK = new JLabel("");
		lblMensajeCargaOK.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMensajeCargaOK.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensajeCargaOK.setForeground(Color.RED);
		lblMensajeCargaOK.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMensajeCargaOK.setBounds(41, 53, 711, 40);
		lblMensajeCargaOK.setVisible(false);
		panelCentral.add(lblMensajeCargaOK);
		
		btnPoblarBD = new JButton("Poblar BBDD");
		btnPoblarBD.setEnabled(false);
		btnPoblarBD.setBounds(577, 53, 175, 40);
		panelCentral.add(btnPoblarBD);
		btnPoblarBD.setIcon(new ImageIcon(InicioGUI.class.getResource("/resources/introBD.png")));
		btnPoblarBD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPoblarBD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});	
	}
	
	public static Cliente[] obtenerClientes() {
		// TODO Auto-generated method stub
		ClienteDBSWStub stub = null;
		try {
			stub = new ClienteDBSWStub();
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			GetResultadoResponse respuesta = stub.getResultado();
			Cliente[] arrClientes = respuesta.get_return();
			return arrClientes;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLExceptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
