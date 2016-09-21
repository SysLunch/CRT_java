package xyz.syslunch.crt;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class GetMP3 implements Runnable{
	private SoftwareProperties sp = new SoftwareProperties();
	private Player play;
	private URL Url;
	
	public GetMP3(String audioFile){
		try {
			Url = new URL(sp.getPropertie("URL")+"CRT/MP3/"+audioFile);
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
			play.play();
			play = new Player(Url.openStream());
		} catch (JavaLayerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run(){
		play();
	}
}
