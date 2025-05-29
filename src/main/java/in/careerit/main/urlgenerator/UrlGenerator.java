package in.careerit.main.urlgenerator;

import java.util.Random;

public class UrlGenerator {
	
	private static final String charactes="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final int length=6;
	private static final Random random=new Random();
	
	public static String generateShortCode() {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<length;i++) {
			sb.append(charactes.charAt(random.nextInt(charactes.length())));
			
		}
		return sb.toString();
	}

}
