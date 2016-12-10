package project;

import java.util.*;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;

/**
7
 * This example program shows how AES encryption and decryption can be done in Java.
8
 * Please note that secret key and encrypted text is unreadable binary and hence
9
 * in the following program we display it in hexadecimal format of the underlying bytes.
10
 * @author Jayson
11
 */

 class AESEncryption {
  

    /**
15
     * 1. Generate a plain text for encryption
16
     * 2. Get a secret key (printed in hexadecimal form). In actual use this must
17
     * by encrypted and kept safe. The same key is required for decryption.
18
     * 3.
19
     */

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text to encrypt ");
        String plainText = sc.next();
        SecretKey secKey = getSecretEncryptionKey();
        byte[] cipherText = encryptText(plainText, secKey);
        String decryptedText = decryptText(cipherText, secKey);
         
        System.out.println("Original Text:" + plainText);
        System.out.println("AES Key (Hex Form):"+bytesToHex(secKey.getEncoded()));
        System.out.println("Encrypted Text (Hex Form):"+bytesToHex(cipherText));

        System.out.println("Descrypted Text:"+decryptedText);
         

    }

     
    /**
34
     * gets the AES encryption key. In your actual programs, this should be safely
35
     * stored.
36
     * @return
37
     * @throws Exception
38
     */

    public static SecretKey getSecretEncryptionKey() throws Exception{

        KeyGenerator generator = KeyGenerator.getInstance("AES");

        generator.init(128); // The AES key size in number of bits

        SecretKey secKey = generator.generateKey();

        return secKey;
    }

     

    /**
47
     * Encrypts plainText in AES using the secret key
48
     * @param plainText
49
     * @param secKey
50
     * @return
51
     * @throws Exception
52
     */

    public static byte[] encryptText(String plainText,SecretKey secKey) throws Exception{

        // AES defaults to AES/ECB/PKCS5Padding in Java 7

        Cipher aesCipher = Cipher.getInstance("AES");

        aesCipher.init(Cipher.ENCRYPT_MODE, secKey);

        byte[] byteCipherText = aesCipher.doFinal(plainText.getBytes());

        return byteCipherText;

    }

     

    /**
62
     * Decrypts encrypted byte array using the key used for encryption.
63
     * @param byteCipherText
64
     * @param secKey
65
     * @return
66
     * @throws Exception
67
     */

    public static String decryptText(byte[] byteCipherText, SecretKey secKey) throws Exception {

        // AES defaults to AES/ECB/PKCS5Padding in Java 7

        Cipher aesCipher = Cipher.getInstance("AES");

        aesCipher.init(Cipher.DECRYPT_MODE, secKey);

        byte[] bytePlainText = aesCipher.doFinal(byteCipherText);

        return new String(bytePlainText);

    }

     

    /**

     * Convert a binary byte array into readable hex form
78
     * @param hash
79
     * @return
80
     */

    private static String  bytesToHex(byte[] hash) {

       return DatatypeConverter.printHexBinary(hash);

    }

}


