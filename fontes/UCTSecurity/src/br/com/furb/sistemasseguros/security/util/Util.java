package br.com.furb.sistemasseguros.security.util;

public class Util {
	
	private static final String hexDigits = "0123456789abcdef";

	public static String getHexhStringFromBytes(byte[] bytes) {
		StringBuffer buf = new StringBuffer();

		for (int i = 0; i < bytes.length; i++) {
			int j = (bytes[i]) & 0xFF;
			buf.append(hexDigits.charAt(j / 16));
			buf.append(hexDigits.charAt(j % 16));
		}

		return buf.toString();
	}
	
	public static byte[] getBytesFromHexString(String hexa) throws IllegalArgumentException {  
        if (hexa.length() % 2 != 0) {  
            throw new IllegalArgumentException("String hexa inválida");  
        }  
          
        byte[] bytes = new byte[hexa.length() / 2];  
            
        for (int i = 0; i < hexa.length(); i += 2) {  
            bytes[i / 2] = (byte) ((hexDigits.indexOf(hexa.charAt(i)) << 4) | (hexDigits.indexOf(hexa.charAt(i + 1))));  
        }  
        return bytes;  
    } 

}
