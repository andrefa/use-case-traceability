package br.com.furb.sistemasseguros.security.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AesUtil {

	public static String encrypt(String key, String message) throws Exception {
		SecretKeySpec skeySpec = new SecretKeySpec(Util.getBytesFromHexString(key), "AES");
		Cipher cipher = Cipher.getInstance("AES");

		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);

		byte[] encrypted = cipher.doFinal((message.getBytes()));
		return Util.getHexhStringFromBytes(encrypted);
	}

	public static String decrypt(String key, String message) throws Exception {
		SecretKeySpec skeySpec = new SecretKeySpec(Util.getBytesFromHexString(key), "AES");
		Cipher cipher = Cipher.getInstance("AES");

		cipher.init(Cipher.DECRYPT_MODE, skeySpec);

		byte[] original = cipher.doFinal(Util.getBytesFromHexString(message));

		String originalString = new String(original);

		return originalString;
	}

	public static String generateKey() throws Exception {
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		kgen.init(128);

		SecretKey skey = kgen.generateKey();
		byte[] key = skey.getEncoded();

		return Util.getHexhStringFromBytes(key);
	}

}