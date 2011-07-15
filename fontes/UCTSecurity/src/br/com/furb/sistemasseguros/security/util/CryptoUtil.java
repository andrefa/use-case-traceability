package br.com.furb.sistemasseguros.security.util;

import java.security.MessageDigest;
import java.util.Arrays;

/**
 * 
 * @author marcos
 *
 */
public class CryptoUtil {
	
	public static String generateHash(String password) throws Exception{
		MessageDigest md = MessageDigest.getInstance("SHA1");
		md.update(password.getBytes());
		byte[] hashSha1 = md.digest();
		return Util.getHexhStringFromBytes(hashSha1);
	}
	
	public static boolean verifyHash(String hash1, String hash2){
		byte[] bhash1 = Util.getBytesFromHexString(hash1);
		byte[] bhash2 = Util.getBytesFromHexString(hash2);
		
		if(Arrays.equals(bhash1, bhash2)){
			return true;
		}
		return false;
	}

}
