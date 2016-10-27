package xyz.syslunch.crt.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONException;
import org.json.JSONObject;

import xyz.syslunch.crt.GetJSON;
import xyz.syslunch.crt.ShowClockCatraca;
import xyz.syslunch.crt.SoftwareProperties;
import xyz.syslunch.crt.view.mp3.GetMP3;

import java.awt.CardLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DefaultView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8369060012434391403L;
	private JPanel contentPane, panelCardlayout;
	private CardLayout cl;
	private JTextField tf_codigo;
	private GetJSON getJSON = new GetJSON(), getCatraca;
	private SoftwareProperties sp = new SoftwareProperties();
	private JLabel lb_unidade;
	private long time = 0l, timeTest = 0l;

	GetMP3 audioErro = new GetMP3("erro.mp3", true);
	GetMP3 audioAviso = new GetMP3("aviso.mp3", true);
	GetMP3 audioBomAlmoco = new GetMP3("bomalmoco.mp3", true);
	GetMP3 audioFelizAniversario = new GetMP3("felizaniversario.mp3", true);
	
	Thread aErro, aAviso, aBomAlmoco, aFelizAniversario, catraca, lCatraca;
	ShowClockCatraca scl;
	

	final PanelSuccessTicket panel_successTicket = new PanelSuccessTicket();
	final PanelSuccessEmployee panel_successEmployee = new PanelSuccessEmployee();
	final PanelSuccessEmployeeBirth panel_successEmployeeBirth = new PanelSuccessEmployeeBirth();
	final PanelError panel_error = new PanelError();
	final PanelWarning panel_alert = new PanelWarning();
	final PanelLoading panel_loading = new PanelLoading();
	final PanelClock panel_clock = new PanelClock();
	final PanelSuccessCRT panel_successCRT = new PanelSuccessCRT();
	final PanelShowProperties panel_showProperties = new PanelShowProperties();
	
	java.util.Timer Timer = new java.util.Timer();

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
		setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		setBackground(Color.LIGHT_GRAY);
		setTitle("CRT - SysLunch");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 710);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0,77,113));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(new Color(0,77,113));
		contentPane.add(panelHeader, BorderLayout.NORTH);
		GridBagLayout gbl_panelHeader = new GridBagLayout();
		gbl_panelHeader.columnWidths = new int[] {522, 0, 0, 0};
		gbl_panelHeader.rowHeights = new int[]{0, 0, 0};
		gbl_panelHeader.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelHeader.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelHeader.setLayout(gbl_panelHeader);
		
		JLabel lb_SyslunchCrt = new JLabel("Syslunch CRT");
		lb_SyslunchCrt.setForeground(Color.WHITE);
		lb_SyslunchCrt.setFont(new Font("Dialog", Font.BOLD, 20));
		GridBagConstraints gbc_lb_SyslunchCrt = new GridBagConstraints();
		gbc_lb_SyslunchCrt.anchor = GridBagConstraints.WEST;
		gbc_lb_SyslunchCrt.insets = new Insets(0, 0, 5, 5);
		gbc_lb_SyslunchCrt.gridx = 0;
		gbc_lb_SyslunchCrt.gridy = 0;
		panelHeader.add(lb_SyslunchCrt, gbc_lb_SyslunchCrt);
		
		GridBagConstraints gbc_lb_situacao = new GridBagConstraints();
		gbc_lb_situacao.anchor = GridBagConstraints.EAST;
		gbc_lb_situacao.insets = new Insets(0, 0, 5, 5);
		gbc_lb_situacao.gridx = 1;
		gbc_lb_situacao.gridy = 0;
		lb_situacao.setFont(new Font("Dialog", Font.BOLD, 25));
		lb_situacao.setHorizontalAlignment(SwingConstants.LEFT);
		lb_situacao.setForeground(Color.WHITE);
		panelHeader.add(lb_situacao, gbc_lb_situacao);
		
		lb_unidade = new JLabel("-");
		lb_unidade.setFont(new Font("Dialog", Font.PLAIN, 25));
		lb_unidade.setForeground(Color.WHITE);
		lb_unidade.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lb_unidade = new GridBagConstraints();
		gbc_lb_unidade.anchor = GridBagConstraints.EAST;
		gbc_lb_unidade.insets = new Insets(0, 0, 5, 0);
		gbc_lb_unidade.gridx = 2;
		gbc_lb_unidade.gridy = 0;
		panelHeader.add(lb_unidade, gbc_lb_unidade);
		
		if(!sp.getPropertie("CRT").equals("")){
			this.getCRT(Integer.parseInt(sp.getPropertie("CRT")));
		}
		
		panelCardlayout = new JPanel();
		panelCardlayout.setBackground(Color.WHITE);
		cl = new CardLayout(0,0);
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
		
		JLabel lb_codigoBarras = new JLabel("Por favor, passe o código de barras no leitor:");
		lb_codigoBarras.setFont(new Font("Dialog", Font.BOLD, 30));
		GridBagConstraints gbc_lb_codigoBarras = new GridBagConstraints();
		gbc_lb_codigoBarras.insets = new Insets(0, 0, 5, 0);
		gbc_lb_codigoBarras.gridx = 0;
		gbc_lb_codigoBarras.gridy = 0;
		panelLer.add(lb_codigoBarras, gbc_lb_codigoBarras);
		
		tf_codigo = new JTextField();
		tf_codigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					getResponse(tf_codigo.getText().toUpperCase());
			}
		});
		tf_codigo.setHorizontalAlignment(SwingConstants.CENTER);
		tf_codigo.setFont(new Font("Dialog", Font.PLAIN, 30));
		GridBagConstraints gbc_tf_codigo = new GridBagConstraints();
		gbc_tf_codigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_codigo.gridx = 0;
		gbc_tf_codigo.gridy = 1;
		panelLer.add(tf_codigo, gbc_tf_codigo);
		tf_codigo.setColumns(10);
		
		panelCardlayout.add(panel_successTicket, "successTicket");
		
		panelCardlayout.add(panel_successEmployee, "successEmployee");
		
		panelCardlayout.add(panel_successEmployeeBirth, "successEmployeeBirth");
		
		panelCardlayout.add(panel_error, "error");
		
		panelCardlayout.add(panel_alert, "alert");
		
		panelCardlayout.add(panel_loading, "loading");
		
		panelCardlayout.add(panel_clock, "clock");
		
		panelCardlayout.add(panel_successCRT, "successCRT");
		
		panelCardlayout.add(panel_showProperties, "showProperties");
		
		Timer timer = new Timer(1000, ver);
		Timer ping = new Timer(60000, this.ping);
		timer.start();
		ping.start();
		
		cl.show(panelCardlayout, "clock");
	}
	
	ActionListener ver = (
    	new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			showClockInTime();
    		}
        }
    );
	
	ActionListener ping = (
		new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					URL ping = new URL(sp.getPropertie("URL")+"CRT/ajax/ping.php?idCRT="+sp.getPropertie("CRT"));
					JSONObject json = new JSONObject(ping.openStream());
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	);
	
	ActionListener catracaTravada = (
    	new ActionListener(){
    		public void actionPerformed(ActionEvent e){
				cl.show(panelCardlayout, "clock");
    		}
        }
    );
	private final JLabel lb_situacao = new JLabel("-");
	
	private void showClockInTime(){
		timeTest = new java.util.Date().getTime();
		if(time > (timeTest-1000) && time < timeTest+100){
			cl.show(panelCardlayout, "clock");
		}
	}
	
	private void setLimitDisplayTime(long t){
		time = (t*1000)+new java.util.Date().getTime();
	}
	
	private void getCRT(int id){
		getJSON.clear();
		getJSON.setIdCRT(id);
		JSONObject jo = getJSON.getCRT();
		lb_unidade.setText("Local: " + jo.getInt("idCRT") + " - " +jo.getString("nomeCRT"));
		sp.changeCRT(jo.getString("idCRT"));
	}
	
	private void getResponse(String code){
		tf_codigo.setText("");
		
		cl.show(panelCardlayout, "loading");
		
		if(code.equals("CRT_PRODUCTION")){
			sp.changeURL("http://www.syslunch.xyz/");
			cl.show(panelCardlayout, "clock");
			 lb_situacao.setText("PRODUÇÃO");
			tf_codigo.setText("");
		}if(code.equals("CRT_LOCALHOST")){
			sp.changeURL("http://localhost/");
			cl.show(panelCardlayout, "clock");
			 lb_situacao.setText("PRODUÇÃO");
			tf_codigo.setText("");
		}else if(code.equals("CRT_TEST")){
			sp.changeURL("http://10.1.2.30/almoco/");
			cl.show(panelCardlayout, "clock");
			 lb_situacao.setText("TESTE");
			tf_codigo.setText("");
		}else if(code.equals("CATRACA_ON")){
			sp.changeHasCatraca("true");
			cl.show(panelCardlayout, "clock");
			 lb_situacao.setText("CATRACA ATIVADA");
			tf_codigo.setText("");
		}else if(code.equals("CATRACA_OFF")){
			sp.changeHasCatraca("false");
			cl.show(panelCardlayout, "clock");
			 lb_situacao.setText("CATRAVA DESATIVADA");
			tf_codigo.setText("");
		}else if(code.equals("SHOW_INFOS")){
			panel_showProperties.updateInfos();
			cl.show(panelCardlayout, "showProperties");
			tf_codigo.setText("");
			setLimitDisplayTime(20l);
		}else{
			getJSON.clear();
			getJSON.setBarcode(code);
			JSONObject jo = getJSON.get();
			if(jo.has("isCRT")){
				if(jo.getBoolean("isCRT")){
					getJSON.setIdCRT(jo.getInt("idCRT"));
					lb_unidade.setText("Local: " + jo.getInt("idCRT") + " - " +jo.getString("nomeCRT"));
					sp.changeCRT(jo.getString("idCRT"));
					cl.show(panelCardlayout, "successCRT");
					setLimitDisplayTime(20l);
				}
			}else{
				if(jo.getInt("sucesso") == 1){
					if(jo.getInt("isTicket") == 0){
						// Employees
						if(jo.getInt("aniversario") == 1){
							// BOM ALMOÇO FUNCIONÁRIO E FELIZ ANIVERSÁRIO!
							try {
								panel_successEmployeeBirth.setNomeFuncionario(jo.getString("nomeFuncionario"));
								if(!jo.getBoolean("isGratuito")){
									panel_successEmployeeBirth.setSaldoFuncionario(jo.getInt("saldo"));
								}else{
									panel_successEmployeeBirth.clearSaldoFuncionario();
								}
								panel_successEmployeeBirth.setTipoAlmoco(jo.getString("texto"));
								if(jo.has("foto")){
									panel_successEmployeeBirth.setImage(new URL(sp.getPropertie("URL") + "CRT/" + jo.getString("foto")));
								}else{
									panel_successEmployeeBirth.setImage(new URL(sp.getPropertie("URL") + sp.getPropertie("fotoPadrao")));
								}
								cl.show(panelCardlayout, "successEmployeeBirth");
							} catch (MalformedURLException e) {
								e.printStackTrace();
							} catch (JSONException e) {
								e.printStackTrace();
							}
							aBomAlmoco = new Thread(audioBomAlmoco);
							aFelizAniversario = new Thread(audioFelizAniversario);
							aBomAlmoco.start();
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							aFelizAniversario.start();
						}else{
							// BOM ALMOÇO FUNCIONÁRIO
							try {
								panel_successEmployee.setNomeFuncionario(jo.getString("nomeFuncionario"));
								if(!jo.getBoolean("isGratuito")){
									panel_successEmployee.setSaldoFuncionario(jo.getInt("saldo"));
								}else{
									panel_successEmployee.clearSaldoFuncionario();
								}
								panel_successEmployee.setTipoAlmoco(jo.getString("texto"));
								if(jo.has("foto")){
									panel_successEmployee.setImage(new URL(sp.getPropertie("URL") + "CRT/" + jo.getString("foto")));
								}else{
									panel_successEmployee.setImage(new URL(sp.getPropertie("URL") + sp.getPropertie("fotoPadrao")));
								}
								cl.show(panelCardlayout, "successEmployee");
								aBomAlmoco = new Thread(audioBomAlmoco);
								aBomAlmoco.start();
							} catch (MalformedURLException e) {
								e.printStackTrace();
							} catch (JSONException e) {
								e.printStackTrace();
							}
						}
						
					}else{
						// BOM ALMOÇO TICKET
						panel_successTicket.setTipoTicket(jo.getString("texto"));
						cl.show(panelCardlayout, "successTicket");
						aBomAlmoco = new Thread(audioBomAlmoco);
						aBomAlmoco.start();
					}
					if(sp.getPropertie("hasCatraca").equals("true")){
						setLimitDisplayTime(-2l);
						// Libera a catraca!
						getCatraca = new GetJSON();
						catraca = new Thread(getCatraca);
						scl = new ShowClockCatraca(cl, panelCardlayout, catraca);
						lCatraca = new Thread(scl);
						catraca.start();
						lCatraca.start();
					}else{
						setLimitDisplayTime(20l);
					}
				}else{
					if(jo.has("tipo")){
						if(jo.getInt("tipo") == 2){
								panel_alert.setAlert(jo.getString("motivo"));
								cl.show(panelCardlayout, "alert");
								aAviso = new Thread(audioAviso);
								aAviso.start();
						}else{
							panel_error.setError(jo.getString("motivo"));
							cl.show(panelCardlayout, "error");
							aErro = new Thread(audioErro);
							aErro.start();
						}
					}else{
						panel_error.setError(jo.getString("motivo"));
						cl.show(panelCardlayout, "error");
						aErro = new Thread(audioErro);
						aErro.start();
					}
					setLimitDisplayTime(20l);
				}
			}
		}
	}

}
