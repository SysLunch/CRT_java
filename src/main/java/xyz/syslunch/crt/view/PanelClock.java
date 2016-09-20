package xyz.syslunch.crt.view;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.awt.Font;
import java.awt.Color;

public class PanelClock extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1014754252611513885L;
	private Date data;
	private JLabel lb_date, lb_hour;
	private StringBuilder sb;
	private Calendar cal;
	/**
	 * Create the panel.
	 */
	public PanelClock() {
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lb_date = new JLabel("20/09/2016");
		lb_date.setFont(new Font("Dialog", Font.BOLD, 45));
		GridBagConstraints gbc_lb_date = new GridBagConstraints();
		gbc_lb_date.anchor = GridBagConstraints.SOUTH;
		gbc_lb_date.insets = new Insets(0, 0, 5, 0);
		gbc_lb_date.gridx = 0;
		gbc_lb_date.gridy = 0;
		add(lb_date, gbc_lb_date);
		
		lb_hour = new JLabel("00:55:23");
		lb_hour.setFont(new Font("Dialog", Font.BOLD, 60));
		GridBagConstraints gbc_lb_hour = new GridBagConstraints();
		gbc_lb_hour.anchor = GridBagConstraints.NORTH;
		gbc_lb_hour.gridx = 0;
		gbc_lb_hour.gridy = 1;
		add(lb_hour, gbc_lb_hour);
		atualizar();

        Timer time = new Timer(1000,ativar);
        time.start();	

	}
	
	private void atualizar(){
		cal = Calendar.getInstance();
		data = new Date();
		sb = new StringBuilder();
		sb.append(cal.get(Calendar.DAY_OF_MONTH)).append("/").append(cal.get(Calendar.MONTH)+1).append("/").append(cal.get(Calendar.YEAR));
		lb_date.setText(sb.toString());
		sb = new StringBuilder();
		sb.append(cal.get(Calendar.HOUR_OF_DAY)).append(":").append(cal.get(Calendar.MINUTE)).append(":").append(cal.get(Calendar.SECOND));
		lb_hour.setText(sb.toString());
	}
	
    ActionListener ativar = (
    	new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			atualizar();
    		}
        }
    );

}
