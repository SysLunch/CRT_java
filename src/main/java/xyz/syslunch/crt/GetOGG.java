package xyz.syslunch.crt;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;    


public class GetOGG {
	private SoftwareProperties sp = new SoftwareProperties();
	private Player play;
	private URL Url;
	
	public GetOGG(String audioFile){
		try {
			Url = new URL(sp.getPropertie("URL")+"CRT/OGG/"+audioFile);
			play = new Player(Url.openStream());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JavaLayerException e) {
			e.printStackTrace();
		}
	}
	
	public void play(){
		try {
			play.play(0);
		} catch (JavaLayerException e) {
			e.printStackTrace();
		}
	}
}
