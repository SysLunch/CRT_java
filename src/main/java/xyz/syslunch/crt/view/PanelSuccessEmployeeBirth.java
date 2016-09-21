package xyz.syslunch.crt.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.MediaTracker;
import java.net.URL;
import java.awt.Font;
import java.awt.Color;

public class PanelSuccessEmployeeBirth extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -947505703945582954L;
	JLabel lb_tipoAlmoco, lb_nomeFuncionario, lb_saldoFuncionrio, lb_imagem;
	ImageIcon foto = new ImageIcon();
	private JLabel lblFelizAniversrio;
	

	/**
	 * Create the panel.
	 */
	public PanelSuccessEmployeeBirth() {
		setBackground(new Color(164,4,234));
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{185, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lb_imagem = new JLabel("[FOTO FUNCIONÁRIO]");
		GridBagConstraints gbc_lb_imagem = new GridBagConstraints();
		gbc_lb_imagem.anchor = GridBagConstraints.EAST;
		gbc_lb_imagem.insets = new Insets(10, 0, 5, 5);
		gbc_lb_imagem.gridx = 0;
		gbc_lb_imagem.gridy = 0;
		add(lb_imagem, gbc_lb_imagem);
		
		JLabel lb_icone = new JLabel(new ImageIcon(getClass().getResource("icons/checkbox.png"), "checkbox"));
		lb_icone.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lb_icone = new GridBagConstraints();
		gbc_lb_icone.anchor = GridBagConstraints.WEST;
		gbc_lb_icone.insets = new Insets(0, 0, 5, 0);
		gbc_lb_icone.gridx = 1;
		gbc_lb_icone.gridy = 0;
		add(lb_icone, gbc_lb_icone);
		
		JLabel lb_titulo = new JLabel("BOM ALMOÇO!");
		lb_titulo.setForeground(Color.WHITE);
		lb_titulo.setFont(new Font("Dialog", Font.BOLD, 60));
		GridBagConstraints gbc_lb_titulo = new GridBagConstraints();
		gbc_lb_titulo.gridwidth = 2;
		gbc_lb_titulo.insets = new Insets(0, 0, 5, 0);
		gbc_lb_titulo.gridx = 0;
		gbc_lb_titulo.gridy = 1;
		add(lb_titulo, gbc_lb_titulo);
		
		lblFelizAniversrio = new JLabel("FELIZ ANIVERSÁRIO!!!");
		lblFelizAniversrio.setForeground(Color.WHITE);
		lblFelizAniversrio.setFont(new Font("Dialog", Font.BOLD, 70));
		GridBagConstraints gbc_lblFelizAniversrio = new GridBagConstraints();
		gbc_lblFelizAniversrio.gridwidth = 2;
		gbc_lblFelizAniversrio.insets = new Insets(0, 0, 5, 0);
		gbc_lblFelizAniversrio.gridx = 0;
		gbc_lblFelizAniversrio.gridy = 2;
		add(lblFelizAniversrio, gbc_lblFelizAniversrio);
		
		lb_nomeFuncionario = new JLabel("[NOME FUNCIONÁRIO]");
		lb_nomeFuncionario.setFont(new Font("Dialog", Font.BOLD, 35));
		lb_nomeFuncionario.setForeground(Color.WHITE);
		GridBagConstraints gbc_lb_nomeFuncionario = new GridBagConstraints();
		gbc_lb_nomeFuncionario.gridwidth = 2;
		gbc_lb_nomeFuncionario.insets = new Insets(0, 0, 5, 0);
		gbc_lb_nomeFuncionario.gridx = 0;
		gbc_lb_nomeFuncionario.gridy = 3;
		add(lb_nomeFuncionario, gbc_lb_nomeFuncionario);
		
		lb_tipoAlmoco = new JLabel("[TIPO ALMOÇO]");
		lb_tipoAlmoco.setFont(new Font("Dialog", Font.PLAIN, 25));
		lb_tipoAlmoco.setForeground(Color.WHITE);
		GridBagConstraints gbc_lb_tipoAlmoco = new GridBagConstraints();
		gbc_lb_tipoAlmoco.gridwidth = 2;
		gbc_lb_tipoAlmoco.insets = new Insets(0, 0, 5, 0);
		gbc_lb_tipoAlmoco.gridx = 0;
		gbc_lb_tipoAlmoco.gridy = 4;
		add(lb_tipoAlmoco, gbc_lb_tipoAlmoco);
		
		lb_saldoFuncionrio = new JLabel("[SALDO FUNCIONÁRIO]");
		lb_saldoFuncionrio.setFont(new Font("Dialog", Font.BOLD, 25));
		lb_saldoFuncionrio.setForeground(Color.WHITE);
		GridBagConstraints gbc_lb_saldoFuncionrio = new GridBagConstraints();
		gbc_lb_saldoFuncionrio.gridwidth = 2;
		gbc_lb_saldoFuncionrio.gridx = 0;
		gbc_lb_saldoFuncionrio.gridy = 5;
		add(lb_saldoFuncionrio, gbc_lb_saldoFuncionrio);

	}
	
	public void setTipoAlmoco(String type){
		lb_tipoAlmoco.setText(type);
	}
	
	public void setNomeFuncionario(String name){
		lb_nomeFuncionario.setText(name);
	}
	
	public void setSaldoFuncionario(int saldo){
		lb_saldoFuncionrio.setText("SALDO RESTANTE: "+saldo);
	}
	
	public void clearSaldoFuncionario(){
		lb_saldoFuncionrio.setText("");
	}
	
	public void setImage(URL url){
		foto = new ImageIcon(url);
        while(foto.getImageLoadStatus() == MediaTracker.LOADING);
        lb_imagem.setIcon(foto);
        lb_imagem.setText("");
	}

}
