package de.srvn.md5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5-Hashing von Passwörtern
 *
 * @author Markus Moormann
 *
 * @version 16.10.2012
 */
public class MD5 {

  private static final String SALT = "s0mRIdlKvI!-?!§$%&/(";

  public static String md5(String input) {
    String md5;
    if (null == input) {
      return null;
    }
    try {
      //Create MessageDigest object for MD5
      MessageDigest digest = MessageDigest.getInstance("MD5");
      //Update input string in message digest
      digest.update(input.getBytes(), 0, input.length());
      //Converts message digest value in base 16 (hex)
      md5 = new BigInteger(1, digest.digest()).toString(16);
    } catch (NoSuchAlgorithmException e) {
      return null;
    }
    return md5;
  }
  
  public static String md5Salted(String input) {
    return md5(input + SALT);
  }

  public static String md5(char[] password) {
    return md5(String.valueOf(password));
  }
}
