package xyz.syslunch.crt.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JSeparator;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Color;

public class PanelSuccessTicket extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -947505703945582954L;
	JLabel lb_tipoAlmoco;

	/**
	 * Create the panel.
	 */
	public PanelSuccessTicket() {
		setBackground(new Color(12,91,4));
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lb_icone = new JLabel(new ImageIcon(getClass().getResource("icons/checkbox.png"), "checkbox"));
		GridBagConstraints gbc_lb_icone = new GridBagConstraints();
		gbc_lb_icone.insets = new Insets(0, 0, 5, 0);
		gbc_lb_icone.gridx = 0;
		gbc_lb_icone.gridy = 0;
		add(lb_icone, gbc_lb_icone);
		
		JLabel lb_titulo = new JLabel("BOM ALMOÇO!");
		lb_titulo.setForeground(Color.WHITE);
		lb_titulo.setFont(new Font("Dialog", Font.BOLD, 70));
		GridBagConstraints gbc_lb_titulo = new GridBagConstraints();
		gbc_lb_titulo.insets = new Insets(0, 0, 5, 0);
		gbc_lb_titulo.gridx = 0;
		gbc_lb_titulo.gridy = 1;
		add(lb_titulo, gbc_lb_titulo);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 2;
		add(separator, gbc_separator);
		
		lb_tipoAlmoco = new JLabel("[TIPO TICKETS]");
		lb_tipoAlmoco.setFont(new Font("Dialog", Font.BOLD, 25));
		lb_tipoAlmoco.setForeground(Color.WHITE);
		GridBagConstraints gbc_lb_tipoAlmoco = new GridBagConstraints();
		gbc_lb_tipoAlmoco.gridx = 0;
		gbc_lb_tipoAlmoco.gridy = 3;
		add(lb_tipoAlmoco, gbc_lb_tipoAlmoco);

	}
	
	public void setTipoTicket(String type){
		lb_tipoAlmoco.setText(type);
	}

}
