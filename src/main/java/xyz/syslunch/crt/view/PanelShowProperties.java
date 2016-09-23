package xyz.syslunch.crt.view;

import javax.swing.JPanel;

import xyz.syslunch.crt.SoftwareProperties;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Color;

public class PanelShowProperties extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2066729458673506625L;
	SoftwareProperties sp = new SoftwareProperties();
	JLabel lb_hasCatraca, lb_urlCatraca, lb_url;

	/**
	 * Create the panel.
	 */
	public PanelShowProperties() {
		setBackground(Color.WHITE);
		sp.readFile();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lb_titulo = new JLabel("PROPRIEDADES DO SOFTWARE");
		lb_titulo.setFont(new Font("Dialog", Font.BOLD, 40));
		GridBagConstraints gbc_lb_titulo = new GridBagConstraints();
		gbc_lb_titulo.gridwidth = 2;
		gbc_lb_titulo.insets = new Insets(0, 0, 5, 0);
		gbc_lb_titulo.gridx = 0;
		gbc_lb_titulo.gridy = 0;
		add(lb_titulo, gbc_lb_titulo);
		
		JLabel lblNewLabel_2 = new JLabel("URL:");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		lb_url = new JLabel(sp.getPropertie("URL"));
		lb_url.setFont(new Font("Dialog", Font.BOLD, 20));
		GridBagConstraints gbc_lb_url = new GridBagConstraints();
		gbc_lb_url.insets = new Insets(0, 0, 5, 0);
		gbc_lb_url.anchor = GridBagConstraints.WEST;
		gbc_lb_url.gridx = 1;
		gbc_lb_url.gridy = 1;
		add(lb_url, gbc_lb_url);
		
		JLabel lb_urlCat = new JLabel("URL Catraca:");
		lb_urlCat.setFont(new Font("Dialog", Font.BOLD, 20));
		GridBagConstraints gbc_lb_urlCat = new GridBagConstraints();
		gbc_lb_urlCat.anchor = GridBagConstraints.EAST;
		gbc_lb_urlCat.insets = new Insets(0, 0, 5, 5);
		gbc_lb_urlCat.gridx = 0;
		gbc_lb_urlCat.gridy = 2;
		add(lb_urlCat, gbc_lb_urlCat);
		
		lb_urlCatraca = new JLabel(sp.getPropertie("URLCatraca"));
		lb_urlCatraca.setFont(new Font("Dialog", Font.BOLD, 20));
		GridBagConstraints gbc_lb_urlCatraca = new GridBagConstraints();
		gbc_lb_urlCatraca.insets = new Insets(0, 0, 5, 0);
		gbc_lb_urlCatraca.anchor = GridBagConstraints.WEST;
		gbc_lb_urlCatraca.gridx = 1;
		gbc_lb_urlCatraca.gridy = 2;
		add(lb_urlCatraca, gbc_lb_urlCatraca);
		
		JLabel lb_tituloHasCatraca = new JLabel("Has Catraca?");
		lb_tituloHasCatraca.setFont(new Font("Dialog", Font.BOLD, 20));
		GridBagConstraints gbc_lb_tituloHasCatraca = new GridBagConstraints();
		gbc_lb_tituloHasCatraca.anchor = GridBagConstraints.EAST;
		gbc_lb_tituloHasCatraca.insets = new Insets(0, 0, 0, 5);
		gbc_lb_tituloHasCatraca.gridx = 0;
		gbc_lb_tituloHasCatraca.gridy = 3;
		add(lb_tituloHasCatraca, gbc_lb_tituloHasCatraca);
		
		lb_hasCatraca = new JLabel(sp.getPropertie("hasCatraca"));
		lb_hasCatraca.setFont(new Font("Dialog", Font.BOLD, 20));
		GridBagConstraints gbc_lb_hasCatraca = new GridBagConstraints();
		gbc_lb_hasCatraca.anchor = GridBagConstraints.WEST;
		gbc_lb_hasCatraca.gridx = 1;
		gbc_lb_hasCatraca.gridy = 3;
		add(lb_hasCatraca, gbc_lb_hasCatraca);

	}
	
	public void updateInfos(){
		lb_hasCatraca.setText(sp.getPropertie("hasCatraca"));
		lb_urlCatraca.setText(sp.getPropertie("URLCatraca"));
		lb_url.setText(sp.getPropertie("URL"));
	}
}
