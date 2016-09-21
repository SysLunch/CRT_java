package xyz.syslunch.crt;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class ShowClockCatraca implements Runnable {
	
	final CardLayout cl;
	final JPanel jp;
	final Thread catraca;

	public ShowClockCatraca(final CardLayout cl, final JPanel jp, final Thread catraca) {
		this.cl = cl;
		this.jp = jp;
		this.catraca = catraca;
	}
	
	@Override
	public void run() {
		boolean t = true;
		while(t){
			if(!catraca.isAlive()){
				cl.show(jp, "clock");
				t = false;
			}
		}
	}

}
