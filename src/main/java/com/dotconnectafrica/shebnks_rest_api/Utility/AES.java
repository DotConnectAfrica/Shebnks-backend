/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotconnectafrica.shebnks_rest_api.Utility;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.KeySpec;
import java.util.Base64;

/**
 *
 * @author jac
 */
public class AES {
    
    public  final String secretKey = "da0k188qL5OiY3eX";
    public  final String salt = "_VSUrIqGV2pHSye1";
    
    public AES()
    {
        
    }
    
    
    public  String encrypt(String strToEncrypt) 
    {
        try
        {
            byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
            IvParameterSpec ivspec = new IvParameterSpec(iv);

            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } 
        catch (Exception e) 
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }
    
    
    
    public  String decrypt(String strToDecrypt) 
    {
        try
        {
            byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
            IvParameterSpec ivspec = new IvParameterSpec(iv);

            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } 
        catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
    
    
    
    public String  Enco_Deco64(String task,String param) 
    {  
        String respo="";
        if(task.endsWith("encode"))
        {
            // Getting encoder  
            Base64.Encoder encoder = Base64.getUrlEncoder();
            // Encoding URL  
            respo = encoder.encodeToString(param.getBytes());  
            System.out.println("Encoded=== "+respo);   
        }
        else if(task.endsWith("decode"))
        {
            // Getting decoder  
            Base64.Decoder decoder = Base64.getUrlDecoder();
            // Decoding URl  
            respo = new String(decoder.decode(param));  
            System.out.println("Decoded=== "+respo);  
        }
          
    return respo;     
    }
    
    
    public static void main (String []args)
    {
        String encrypt = new AES().encrypt("+2542191238");
        System.out.println("Encrypt ------->  " + encrypt);
        String decrypt=new AES().decrypt(encrypt);
        System.out.println("===Decrypted text=== "+decrypt);

    }
}
