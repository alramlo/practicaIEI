package Presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class InicioGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioGUI window = new InicioGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InicioGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelNorte = new JPanel();
		frame.getContentPane().add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel("IEI Pr\u00E1ctica 1 - ");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 42));
		panelNorte.add(lblTitulo);
		
		JLabel lblSubTitulo = new JLabel("Integraci\u00F3n de datos");
		lblSubTitulo.setFont(new Font("Tahoma", Font.PLAIN, 38));
		panelNorte.add(lblSubTitulo);
		
		JPanel panelCentral = new JPanel();
		frame.getContentPane().add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);
		
		JPanel panelConsulta1 = new JPanel();
		panelConsulta1.setBounds(36, 17, 711, 109);
		panelCentral.add(panelConsulta1);
		panelConsulta1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Consulta 1", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		panelConsulta1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listado con los clientes y el monto total de las transacciones de su tarjeta:\r\n");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(10, 14, 691, 25);
		panelConsulta1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		JButton btnVerC1 = new JButton("Ver Consulta 1");
		btnVerC1.setIcon(new ImageIcon(InicioGUI.class.getResource("/Resouces/searchDB.png")));
		btnVerC1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVerC1.setBounds(268, 53, 175, 40);
		panelConsulta1.add(btnVerC1);
		
		JPanel panelConsulta2 = new JPanel();
		panelConsulta2.setLayout(null);
		panelConsulta2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Consulta 2", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		panelConsulta2.setBounds(36, 143, 711, 109);
		panelCentral.add(panelConsulta2);
		
		JLabel lblListadoDeTransacciones_1 = new JLabel("Listado de transacciones que no tienen cliente asociado:");
		lblListadoDeTransacciones_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblListadoDeTransacciones_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblListadoDeTransacciones_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblListadoDeTransacciones_1.setBounds(10, 14, 691, 25);
		panelConsulta2.add(lblListadoDeTransacciones_1);
		
		JButton btnVerC2 = new JButton("Ver Consulta 2");
		btnVerC2.setIcon(new ImageIcon(InicioGUI.class.getResource("/Resouces/searchDB.png")));
		btnVerC2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVerC2.setBounds(268, 53, 175, 40);
		panelConsulta2.add(btnVerC2);
		
		JPanel panelConsulta3 = new JPanel();
		panelConsulta3.setLayout(null);
		panelConsulta3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Consulta 3", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		panelConsulta3.setBounds(36, 269, 711, 109);
		panelCentral.add(panelConsulta3);
		
		JLabel lblListadoDeTarjetas_1 = new JLabel("Listado de tarjetas sospechas, con m\u00E1s de 5.000 euros en operaciones:");
		lblListadoDeTarjetas_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblListadoDeTarjetas_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblListadoDeTarjetas_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblListadoDeTarjetas_1.setBounds(10, 14, 691, 25);
		panelConsulta3.add(lblListadoDeTarjetas_1);
		
		JButton btnVerC3 = new JButton("Ver Consulta 3");
		btnVerC3.setIcon(new ImageIcon(InicioGUI.class.getResource("/Resouces/searchDB.png")));
		btnVerC3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVerC3.setBounds(268, 53, 175, 40);
		panelConsulta3.add(btnVerC3);
		
		JLabel lblCargaDeDatos = new JLabel("Carga de datos :\r\n");
		lblCargaDeDatos.setForeground(Color.RED);
		lblCargaDeDatos.setBounds(304, 406, 175, 26);
		panelCentral.add(lblCargaDeDatos);
		lblCargaDeDatos.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCargaDeDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargaDeDatos.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnPoblarBD = new JButton("Poblar BBDD");
		btnPoblarBD.setBounds(304, 432, 175, 40);
		panelCentral.add(btnPoblarBD);
		btnPoblarBD.setIcon(new ImageIcon(InicioGUI.class.getResource("/Resouces/introBD.png")));
		btnPoblarBD.setFont(new Font("Tahoma", Font.PLAIN, 16));
	}
}
