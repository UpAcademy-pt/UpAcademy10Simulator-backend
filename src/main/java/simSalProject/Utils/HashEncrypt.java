package simSalProject.Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import simSalProject.models.Account;

public class HashEncrypt {

	public static String encryptHash(String passwordToHash) throws NoSuchAlgorithmException {
		System.out.println("encryptHash: "+passwordToHash);
		byte[] salt = getSalt();
		
		String securePassword = getSecurePassword(passwordToHash, salt);
		System.out.println("Secure Password: "+ securePassword);
		return securePassword;
		
	}

	public static String getSecurePassword(String passwordToHash, byte[] salt) {
		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");

			md.update(salt);
			byte[] bytes = md.digest(passwordToHash.getBytes());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		System.out.println("Password with Hash: "+generatedPassword);
		return generatedPassword;
		
		
	}
	// Add salt
	public static byte[] getSalt() throws NoSuchAlgorithmException {
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		byte[] salt = new byte[16];
		sr.nextBytes(salt);
		return salt;
	}
	
	
}
