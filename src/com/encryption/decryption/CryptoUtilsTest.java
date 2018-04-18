package com.encryption.decryption;

import java.io.File;

public class CryptoUtilsTest {

	public static void main(String[] args) {
		String key = "thebestsecretkey";
		File inputFile = new File("kuchh.mp4");
		File encryptedFile  = new File("document.encrypted");
		File decryptedFile = new File("documentDecrypted.mp4");
		
		try{
			CryptoUtils.encrypt(key, inputFile, encryptedFile);
			
			CryptoUtils.decrypt(key, encryptedFile, decryptedFile);
		}catch (CryptoException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

	}

}
