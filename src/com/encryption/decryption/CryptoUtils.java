package com.encryption.decryption;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class CryptoUtils {
	private static final String ALGORTHM = "AES";
	private static final String TRANSFORMATION = "AES";
	public static void encrypt(String key, File inputFile, File outputFile) throws CryptoException {
		 doCrypto(Cipher.ENCRYPT_MODE, key, inputFile, outputFile);
	}
	
	public static void decrypt(String key, File inputFile, File outputFile) throws CryptoException {
        doCrypto(Cipher.DECRYPT_MODE, key, inputFile, outputFile);
    }
	
	 private static void doCrypto (int cipherMode, String key, File inputFile,
     File outputFile) throws CryptoException {
		 
		 Key secretKey = new SecretKeySpec(key.getBytes(), ALGORTHM);
		 try {
			Cipher cipher = Cipher.getInstance(TRANSFORMATION);
			cipher.init(cipherMode, secretKey);
			FileInputStream inputStream = new FileInputStream(inputFile);
			byte[] inputBytes  = new byte[(int) inputFile.length()];
			inputStream.read(inputBytes);
			
			byte[] outputBytes = cipher.doFinal(inputBytes);
			FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);
           
            
            inputStream.close();
            outputStream.close();
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
		
	 
}
