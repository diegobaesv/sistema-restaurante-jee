package utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Util {
	
	public static String encodedTextToUrl(String texto) throws UnsupportedEncodingException {
		//hola quiero hacer una reserva ---> hola%20quiero%20hacer%20
		return URLEncoder.encode(texto, StandardCharsets.UTF_8.name());
	}
	
	public static String extractDataFromPath(String url, int i) {
		String value = null;
		try {
			String split[] = url.split("/");
			value =  i < split.length ? split[i] : null ;
		} catch (Exception e) {
			System.out.println(e);
			value = null;
		}
		return value;
	}
}
