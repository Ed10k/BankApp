
import javax.crypto.*;
import java.util.*;
import java.security.*;
import java.security.spec.*;

import javax.crypto.spec.*;


public class BankEncrypt {

	private static final Random rand= new SecureRandom();
	
	
	public static SecretKey makeKey(String password) throws NoSuchAlgorithmException, InvalidKeySpecException
	{
		
		SecretKeyFactory kf=SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		KeySpec ks=new PBEKeySpec(password.toCharArray(),makeSalt(),65000,256);
		SecretKey sk= new SecretKeySpec(kf.generateSecret(ks).getEncoded(),"AES");
		return sk;
		
		
	}
	
	public static byte[] makeSalt()
	{
		byte[] salt=new byte[16];
		rand.nextBytes(salt);
		return salt;
	}
	
	public static IvParameterSpec generateIV()
	{
		byte [] iv=new byte[16];
		new SecureRandom().nextBytes(iv);
		IvParameterSpec ivSpec=new IvParameterSpec(iv);
		return ivSpec;
	}
	
	
	public static String encrypt(String input, SecretKey key,IvParameterSpec iv) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchPaddingException
	{
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE,key,iv);
		byte [] text=cipher.doFinal(input.getBytes());
		return Base64.getEncoder().encodeToString(text);
	}
	
	public static String decrypt(String input, SecretKey key, IvParameterSpec iv) throws InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException
	{
		Cipher cipher=Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE,key,iv);
		byte [] text=cipher.doFinal(Base64.getDecoder().decode(input));
		String returnText=new String(text);
		return returnText;
	}
	
	
	
}
