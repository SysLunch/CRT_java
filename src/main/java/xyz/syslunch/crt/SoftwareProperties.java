package xyz.syslunch.crt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class SoftwareProperties {
	private Properties p = new Properties();
	private String name = "configs.properties";
	
	public SoftwareProperties(){
		File file = new File(name);
		if(!file.exists()){
			recordDefault();
		}else{
			readFile();
		}
	}
	
	public void recordDefault(){
		p.setProperty("CRT", "");
		p.setProperty("URL", "http://localhost/");
		p.setProperty("URLConsulta", "CRT/ajax/consulta.php");
		p.setProperty("URLCatraca", "http://10.192.0.7/liberaCatraca.php");
		p.setProperty("hasCatraca", "true");
		p.setProperty("fotoPadrao", "empresas/fotos/foto.png");
		recordInFile();
	}
	
	public void changeCRT(String CRT){
		p.setProperty("CRT", CRT);
		recordInFile();
	}
	
	public void changeURL(String url){
		p.setProperty("URL", url);
		recordInFile();
	}
	
	public void changeHasCatraca(String hasCatraca){
		p.setProperty("hasCatraca", hasCatraca);
		recordInFile();
	}
	
	public String getPropertie(String what){
		readFile();
		return p.getProperty(what);
	}
	
	private void recordInFile(){
		try {
			p.store(new FileWriter(new File(name)), "CRT Properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readFile(){
		try {
			p.load(new FileReader(new File(name)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
