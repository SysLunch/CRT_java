package xyz.syslunch.crt;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
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
	
	public GetMP3(String audioFile, Boolean t){
		InputStream is = null;
		BufferedInputStream bis = null;
		try {
			is = getClass().getResourceAsStream(audioFile);
		    bis = new BufferedInputStream(is);
		    play = new Player(bis);
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
			e.printStackTrace();
		}
	}
	
	public void run(){
		play();
	}
}
