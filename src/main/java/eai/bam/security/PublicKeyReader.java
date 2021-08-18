package eai.bam.security;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;

public class PublicKeyReader {

  public static PublicKey getpublicKey(String filename)
    throws Exception {
	  
	  InputStream in = new FileInputStream(filename);
	    ObjectInputStream oin = new ObjectInputStream(new BufferedInputStream(
	            in));
	    try {
	        BigInteger m = (BigInteger) oin.readObject();
	        BigInteger e = (BigInteger) oin.readObject();
	        KeyFactory fact = KeyFactory.getInstance("RSA");
	            return fact.generatePublic(new RSAPublicKeySpec(m, e));
	     
	    } catch (Exception e) {
	        throw new RuntimeException("Erreur de sérialisation parasite", e);
	    } finally {
	        oin.close();
	        System.out.println("Fermeture de lecture fichier .");
	    }
	    
  }
}