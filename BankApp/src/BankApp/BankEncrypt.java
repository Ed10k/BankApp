package BankApp;

/*
 * @author Grant Anderson. This is the file responsible for encrypting and decrypting within the banking application
 */
import javax.crypto.*;
import java.util.*;
import java.security.*;
import java.security.spec.*;

import javax.crypto.spec.*;


public class BankEncrypt {

	private static final Random rand= new SecureRandom();
	
	/*
	 * @param password, a string that is a creates a key
	 * @throw NoSuchAlgorithException when the algorithm is not recognized
	 * @throw InvalidKeySpecException when SecretKeySpec cannot be generated.
	 * @return sk: the SecretKey 
	 */
	public static SecretKey makeKey(String password) throws NoSuchAlgorithmException, InvalidKeySpecException
	{
		
		SecretKeyFactory kf=SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		KeySpec ks=new PBEKeySpec(password.toCharArray(),makeSalt(),65000,256);
		SecretKey sk= new SecretKeySpec(kf.generateSecret(ks).getEncoded(),"AES");
		return sk;
		
		
	}
	
	/*
	 * method for making salt for the keySpec function. 
	 * @returns salt: a byte array
	 */
	public static byte[] makeSalt()
	{
		byte[] salt=new byte[16];
		rand.nextBytes(salt);
		return salt;
	}
	/*
	 * Generates the Initialization vector
	 * @return ivSpec: a byte array to be used as initialization vector
	 * 
	 */
	public static IvParameterSpec generateIV()
	{
		byte [] iv=new byte[16];
		new SecureRandom().nextBytes(iv);
		IvParameterSpec ivSpec=new IvParameterSpec(iv);
		return ivSpec;
	}
	
	/*
	 * encrypting function.
	 * @return AES encrypted text
	 * @param input: text to be encrypted
	 * @param key: SecretKey used to encrypt
	 * @param iv: IvParameterSpec to be used in the cipher.
	 * @throw IllegalBlockSizeException
	 * @throw BadPaddingException
	 * @throw InvalidKeyException
	 * @throw InvalidAlgorithmParameterException,
	 * @throw NoSuchAlgorithException
	 * @throw NoSuchPaddingException
	 */
	public static String encrypt(String input, SecretKey key,IvParameterSpec iv) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchPaddingException
	{
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE,key,iv);
		byte [] text=cipher.doFinal(input.getBytes());
		return Base64.getEncoder().encodeToString(text);
	}
	
	/*
	 * encrypting function.
	 * @return decrypted
	 * @param input: text to be decrypted
	 * @param key: SecretKey used to decrypt
	 * @param iv: IvParameterSpec to be used in the cipher.
	 * @throw IllegalBlockSizeException
	 * @throw BadPaddingException
	 * @throw InvalidKeyException
	 * @throw InvalidAlgorithmParameterException,
	 * @throw NoSuchAlgorithException
	 * @throw NoSuchPaddingException
	 */
	public static String decrypt(String input, SecretKey key, IvParameterSpec iv) throws InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException
	{
		Cipher cipher=Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE,key,iv);
		byte [] text=cipher.doFinal(Base64.getDecoder().decode(input));
		String returnText=new String(text);
		return returnText;
	}
	
	
	
}

