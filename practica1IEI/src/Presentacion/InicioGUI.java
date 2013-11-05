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
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.border.MatteBorder;

import java.awt.Dimension;

public class InicioGUI {

	private JFrame frmIeiCurso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioGUI window = new InicioGUI();
					window.frmIeiCurso.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public InicioGUI() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIeiCurso = new JFrame();
		frmIeiCurso.setResizable(false);
		frmIeiCurso.setSize(new Dimension(800, 600));
		frmIeiCurso.setMinimumSize(new Dimension(800, 600));
		frmIeiCurso.setMaximumSize(new Dimension(800, 600));
		frmIeiCurso.setTitle("IEI Curso 2013-2014");
		frmIeiCurso.setBounds(100, 100, 800, 600);
		frmIeiCurso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelNorte = new JPanel();
		panelNorte.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		frmIeiCurso.getContentPane().add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel("IEI Pr\u00E1ctica 1 - ");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 42));
		panelNorte.add(lblTitulo);
		
		JLabel lblSubTitulo = new JLabel("Integraci\u00F3n de datos");
		lblSubTitulo.setFont(new Font("Tahoma", Font.PLAIN, 38));
		panelNorte.add(lblSubTitulo);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setPreferredSize(new Dimension(14, 0));
		panelNorte.add(horizontalStrut);
		
		JLabel lblIconInfo = new JLabel("");
		lblIconInfo.setIcon(new ImageIcon(InicioGUI.class.getResource("/Resouces/information32x32.png")));
		panelNorte.add(lblIconInfo);
		
		JPanel panelCentral = new JPanel();
		frmIeiCurso.getContentPane().add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);
		
		JPanel panelConsulta1 = new JPanel();
		panelConsulta1.setBounds(41, 96, 711, 109);
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
		panelConsulta2.setBounds(41, 233, 711, 109);
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
		panelConsulta3.setBounds(41, 370, 711, 109);
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
		lblCargaDeDatos.setVerticalAlignment(SwingConstants.TOP);
		lblCargaDeDatos.setForeground(Color.RED);
		lblCargaDeDatos.setBounds(577, 21, 175, 26);
		panelCentral.add(lblCargaDeDatos);
		lblCargaDeDatos.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCargaDeDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargaDeDatos.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnPoblarBD = new JButton("Poblar BBDD");
		btnPoblarBD.setBounds(577, 38, 175, 40);
		panelCentral.add(btnPoblarBD);
		btnPoblarBD.setIcon(new ImageIcon(InicioGUI.class.getResource("/Resouces/introBD.png")));
		btnPoblarBD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblAntesDeRealizar = new JLabel("Antes de realizar las consultas debe cargar los datos de las bases de datos\r\n");
		lblAntesDeRealizar.setForeground(Color.GRAY);
		lblAntesDeRealizar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAntesDeRealizar.setBounds(41, 38, 526, 40);
		panelCentral.add(lblAntesDeRealizar);
	}
}
