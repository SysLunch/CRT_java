package xyz.syslunch.crt.view.mp3;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import xyz.syslunch.crt.SoftwareProperties;

public class GetMP3 implements Runnable{
	private SoftwareProperties sp = new SoftwareProperties();
	private Player play;
	private URL Url;
	private boolean isURL = true;

	private InputStream is = null;
	private BufferedInputStream bis = null;
	
	private String audioFile = null;
	
	public GetMP3(String audioFile){
		this.audioFile = audioFile;
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
		this.audioFile = audioFile;
		try {
			is = getClass().getResourceAsStream(audioFile);
		    bis = new BufferedInputStream(is);
		    play = new Player(bis);
		    isURL = false;
		} catch (JavaLayerException e) {
			e.printStackTrace();
		}
	}
	
	public void play(){
		try {
			play.play();
			while(!play.isComplete());
			if(isURL){
				play = new Player(Url.openStream());
			}else{
				is = getClass().getResourceAsStream(audioFile);
			    bis = new BufferedInputStream(is);
				play = new Player(bis);
			}
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
