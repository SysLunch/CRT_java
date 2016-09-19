package xyz.syslunch.crt.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Color;
import java.awt.Insets;

public class DefaultView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8369060012434391403L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DefaultView frame = new DefaultView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DefaultView() {
		setBackground(Color.LIGHT_GRAY);
		setTitle("CRT - SysLunch");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(new Color(0,77,113));
		contentPane.add(panelHeader, BorderLayout.NORTH);
		GridBagLayout gbl_panelHeader = new GridBagLayout();
		gbl_panelHeader.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panelHeader.rowHeights = new int[]{0, 0, 0};
		gbl_panelHeader.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelHeader.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panelHeader.setLayout(gbl_panelHeader);
		
		JLabel lblSyslunchCrt = new JLabel("Syslunch CRT");
		lblSyslunchCrt.setForeground(Color.WHITE);
		lblSyslunchCrt.setFont(new Font("Dialog", Font.BOLD, 20));
		GridBagConstraints gbc_lblSyslunchCrt = new GridBagConstraints();
		gbc_lblSyslunchCrt.anchor = GridBagConstraints.WEST;
		gbc_lblSyslunchCrt.insets = new Insets(0, 0, 5, 5);
		gbc_lblSyslunchCrt.gridx = 0;
		gbc_lblSyslunchCrt.gridy = 0;
		panelHeader.add(lblSyslunchCrt, gbc_lblSyslunchCrt);
		
		JLabel label = new JLabel("-");
		label.setFont(new Font("Dialog", Font.PLAIN, 25));
		label.setForeground(Color.WHITE);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 2;
		gbc_label.gridy = 0;
		panelHeader.add(label, gbc_label);
		
		JPanel panelCardlayout = new JPanel();
		panelCardlayout.setBackground(Color.WHITE);
		contentPane.add(panelCardlayout, BorderLayout.CENTER);
		panelCardlayout.setLayout(new CardLayout(0, 0));
	}

}
