package Presentacion;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PoblandoBBDD extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public PoblandoBBDD() {
		setTitle("IEI 2013 - Poblando las BBDD");
		setBounds(100, 100, 411, 255);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblespereUnPoco = new JLabel("Cargando los datos...");
		lblespereUnPoco.setFont(new Font("Verdana", Font.BOLD, 19));
		lblespereUnPoco.setHorizontalTextPosition(SwingConstants.CENTER);
		lblespereUnPoco.setHorizontalAlignment(SwingConstants.CENTER);
		lblespereUnPoco.setBounds(10, 122, 375, 47);
		panel.add(lblespereUnPoco);
		
		JLabel label = new JLabel("");
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Verdana", Font.PLAIN, 14));
		label.setIcon(new ImageIcon(PoblandoBBDD.class.getResource("/Resouces/load60x60CuadradoFondoD6D9E0.gif")));
		label.setBounds(167, 51, 60, 60);
		panel.add(label);

	}
}
