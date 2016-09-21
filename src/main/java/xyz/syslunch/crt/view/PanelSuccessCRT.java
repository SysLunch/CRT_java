package xyz.syslunch.crt.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Color;

public class PanelSuccessCRT extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -947505703945582954L;
	JLabel lb_descricaoAviso;

	/**
	 * Create the panel.
	 */
	public PanelSuccessCRT() {
		setBackground(new Color(0,119,189));
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lb_icone = new JLabel(new ImageIcon(getClass().getResource("icons/checkbox.png"), "checkbox"));
		GridBagConstraints gbc_lb_icone = new GridBagConstraints();
		gbc_lb_icone.insets = new Insets(0, 0, 5, 0);
		gbc_lb_icone.gridx = 0;
		gbc_lb_icone.gridy = 0;
		add(lb_icone, gbc_lb_icone);
		
		JLabel lb_titulo = new JLabel("CRT SETADO COM SUCESSO!");
		lb_titulo.setForeground(Color.WHITE);
		lb_titulo.setFont(new Font("Dialog", Font.BOLD, 55));
		GridBagConstraints gbc_lb_titulo = new GridBagConstraints();
		gbc_lb_titulo.insets = new Insets(0, 0, 5, 0);
		gbc_lb_titulo.gridx = 0;
		gbc_lb_titulo.gridy = 1;
		add(lb_titulo, gbc_lb_titulo);

	}
	
	public void setAviso(String aviso){
		lb_descricaoAviso.setText(aviso);
	}

}
