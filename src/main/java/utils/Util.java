package utils;

public class Util {
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
