package Presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

public class InfoEquipo extends JDialog {

	private static final long serialVersionUID = 1L;

	public InfoEquipo() {
		setBounds(100, 100, 357, 455);
		setTitle("IEI 2013 - Equipo");
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pr\u00E1ctica realizada por:", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
		panel_1.setBounds(10, 11, 321, 395);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(SystemColor.inactiveCaption, 1, true));
		panel_2.setBounds(31, 33, 259, 99);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(128, 128, 128), SystemColor.activeCaption));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(InfoEquipo.class.getResource("/Resouces/sergio.png")));
		lblNewLabel.setBounds(10, 9, 66, 80);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sergio Campoy Aranu");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(86, 15, 163, 34);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblSercamainfupves = new JLabel("sercama5@inf.upv.es");
		lblSercamainfupves.setForeground(SystemColor.textHighlight);
		lblSercamainfupves.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblSercamainfupves.setBounds(86, 45, 163, 31);
		panel_2.add(lblSercamainfupves);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(SystemColor.inactiveCaption));
		panel_3.setLayout(null);
		panel_3.setBounds(31, 154, 259, 99);
		panel_1.add(panel_3);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(InfoEquipo.class.getResource("/Resouces/alberto.png")));
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(128, 128, 128), SystemColor.activeCaption));
		label.setBounds(10, 9, 66, 80);
		panel_3.add(label);
		
		JLabel lblAlbertoRamrezLosilla = new JLabel("Alberto Ram\u00EDrez Losilla");
		lblAlbertoRamrezLosilla.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblAlbertoRamrezLosilla.setBounds(86, 15, 163, 34);
		panel_3.add(lblAlbertoRamrezLosilla);
		
		JLabel lblAlramloinfupves = new JLabel("alramlo@inf.upv.es");
		lblAlramloinfupves.setForeground(SystemColor.textHighlight);
		lblAlramloinfupves.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblAlramloinfupves.setBounds(86, 45, 163, 31);
		panel_3.add(lblAlramloinfupves);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(SystemColor.inactiveCaption));
		panel_4.setLayout(null);
		panel_4.setBounds(31, 275, 259, 99);
		panel_1.add(panel_4);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(InfoEquipo.class.getResource("/Resouces/pepe.png")));
		label_3.setHorizontalTextPosition(SwingConstants.CENTER);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(128, 128, 128), SystemColor.activeCaption));
		label_3.setBounds(10, 9, 66, 80);
		panel_4.add(label_3);
		
		JLabel lblJosSanchoMonrabal = new JLabel("Jos\u00E9 Sancho Monrabal");
		lblJosSanchoMonrabal.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblJosSanchoMonrabal.setBounds(86, 15, 163, 34);
		panel_4.add(lblJosSanchoMonrabal);
		
		JLabel lblJosanmoninfupves = new JLabel("josanmon@inf.upv.es");
		lblJosanmoninfupves.setForeground(SystemColor.textHighlight);
		lblJosanmoninfupves.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblJosanmoninfupves.setBounds(86, 45, 163, 31);
		panel_4.add(lblJosanmoninfupves);

	}
}
