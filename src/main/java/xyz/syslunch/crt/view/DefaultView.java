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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DefaultView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8369060012434391403L;
	private JPanel contentPane;
	private CardLayout cl;
	private JTextField tf_codigo;

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
		contentPane.setBackground(new Color(0,77,113));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(new Color(0,77,113));
		contentPane.add(panelHeader, BorderLayout.NORTH);
		GridBagLayout gbl_panelHeader = new GridBagLayout();
		gbl_panelHeader.columnWidths = new int[] {0, 0, 0, 0};
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
		cl = new CardLayout(0, 0);
		panelCardlayout.setLayout(cl);
		contentPane.add(panelCardlayout, BorderLayout.CENTER);
		
		JPanel panelLer = new JPanel();
		panelLer.setBackground(Color.WHITE);
		contentPane.add(panelLer, BorderLayout.SOUTH);
		GridBagLayout gbl_panelLer = new GridBagLayout();
		gbl_panelLer.columnWidths = new int[]{0, 0};
		gbl_panelLer.rowHeights = new int[]{0, 0, 0};
		gbl_panelLer.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelLer.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelLer.setLayout(gbl_panelLer);
		
		JLabel lblNewLabel = new JLabel("Por favor, passe o código de barras no leitor:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panelLer.add(lblNewLabel, gbc_lblNewLabel);
		
		tf_codigo = new JTextField();
		tf_codigo.setHorizontalAlignment(SwingConstants.CENTER);
		tf_codigo.setFont(new Font("Dialog", Font.PLAIN, 30));
		GridBagConstraints gbc_tf_codigo = new GridBagConstraints();
		gbc_tf_codigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_codigo.gridx = 0;
		gbc_tf_codigo.gridy = 1;
		panelLer.add(tf_codigo, gbc_tf_codigo);
		tf_codigo.setColumns(10);
		
		final JPanel panel_successTicket = new PanelSuccessTicket();
		panelCardlayout.add(panel_successTicket, "successTicket");
		
		final JPanel panel_successEmployee = new PanelSuccessEmployee();
		panelCardlayout.add(panel_successEmployee, "successEmployee");
		
		final JPanel panel_successEmployeeBirth = new PanelSuccessEmployeeBirth();
		panelCardlayout.add(panel_successEmployeeBirth, "successEmployeeBirth");
		
		final JPanel panel_error = new PanelError();
		panelCardlayout.add(panel_error, "error");
		
		final JPanel panel_alert = new PanelWarning();
		panelCardlayout.add(panel_alert, "alert");
		
		final JPanel panel_loading = new PanelLoading();
		panelCardlayout.add(panel_loading, "loading");
		
		final JPanel panel_clock = new PanelClock();
		panelCardlayout.add(panel_clock, "clock");
		
		cl.show(panelCardlayout, "clock");
	}

}
