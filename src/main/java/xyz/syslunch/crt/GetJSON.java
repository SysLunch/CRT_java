package xyz.syslunch.crt;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONObject;

public class GetJSON implements Runnable {
	private Integer idCRT;
	private String barcode;
	private String url;
	private SoftwareProperties sp;
	
	private int liberado = 0;
	
	public GetJSON(){
		sp = new SoftwareProperties();
		url = sp.getPropertie("URL")+sp.getPropertie("URLConsulta");
	}
	
	public JSONObject get(){
		if(barcode != null){
			try {
				String u = url+"?idCRT="+idCRT+"&codigoBarras="+barcode;
				URL Url = new URL(u);
				Reader r = new InputStreamReader(Url.openStream());
				JSONObject jo = new JSONObject(GetJSON.readAll(r));
				return jo;
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			// Retorna um JSON de Erro
			JSONObject jo = new JSONObject();
			jo.append("sucesso", 0);
			jo.append("erro", 1);
			jo.append("tipo", 1);
			jo.append("motivo", "Não há código de barras lido. Por favor, passe o código de barras no leitor.");
		}
		return null;
	}
	
	public JSONObject getCRT(){
		if(idCRT > 0){
			try {
				String u = url+"?remoteLogin=1&idCRT="+idCRT;
				URL Url = new URL(u);
				Reader r = new InputStreamReader(Url.openStream());
				JSONObject jo = new JSONObject(GetJSON.readAll(r));
				return jo;
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public JSONObject liberaCatraca(){
		try {
			URL Url = new URL(sp.getPropertie("URLCatraca"));
			Reader r = new InputStreamReader(Url.openStream());
			JSONObject jo = new JSONObject(GetJSON.readAll(r));
			return jo;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static String readAll(Reader rd) {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    try {
			while ((cp = rd.read()) != -1) {
			  sb.append((char) cp);
			}
		    return sb.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return null;
	}
	
	public void clear(){
		barcode = null;
	}
	
	public int getIdCRT() {
		return idCRT;
	}
	public void setIdCRT(int idCRT) {
		this.idCRT = idCRT;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		liberaCatraca();
		liberado = 1;
	}
	
	public boolean isLiberado(){
		if(liberado == 1){
			return true;
		}
		return false;
	}
}
