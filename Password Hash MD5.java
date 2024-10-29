Java MD5 Hashing Example:
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SimpleMD5Example 
{
  public static void main(String[] args) 
  {
    String passwordToHash = "password";
    String generatedPassword = null;

    try 
    {
      MessageDigest md = MessageDigest.getInstance("MD5");

      md.update(passwordToHash.getBytes());

      byte[] bytes = md.digest();

      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < bytes.length; i++) {
        sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
      }

      generatedPassword = sb.toString();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    System.out.println(generatedPassword);
  }
}


Output:
5f4dcc3b5aa765d61d8327deb882cf99

getSalt() Method:


private static String getSalt() 
    throws NoSuchAlgorithmException, NoSuchProviderException 
{
    SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");

    byte[] salt = new byte[16];

    sr.nextBytes(salt);

    return salt.toString();
}

SaltedMD5Example:
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

public class SaltedMD5Example 
{
    public static void main(String[] args)
            throws NoSuchAlgorithmException, NoSuchProviderException 
    {
        String passwordToHash = "password";
        String salt = getSalt();
        
        String securePassword = getSecurePassword(passwordToHash, salt);

        System.out.println(securePassword);

        String regeneratedPassowrdToVerify =
                getSecurePassword(passwordToHash, salt);

        System.out.println(regeneratedPassowrdToVerify);
    }

    private static String getSecurePassword(String passwordToHash,
            String salt) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            md.update(salt.getBytes());
            
            byte[] bytes = md.digest(passwordToHash.getBytes());
            
            
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
                        .substring(1));
            }
            
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    private static String getSalt()
            throws NoSuchAlgorithmException, NoSuchProviderException 
    {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");

        byte[] salt = new byte[16];

        sr.nextBytes(salt);

        return salt.toString();
    }
}

SHA Hashing Example:

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SHAExample {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String passwordToHash = "password";
        String salt = getSalt();

        String securePassword = get_SHA_1_SecurePassword(passwordToHash, salt);
        System.out.println(securePassword);

        securePassword = get_SHA_256_SecurePassword(passwordToHash, salt);
        System.out.println(securePassword);

        securePassword = get_SHA_384_SecurePassword(passwordToHash, salt);
        System.out.println(securePassword);

        securePassword = get_SHA_512_SecurePassword(passwordToHash, salt);
        System.out.println(securePassword);
    }

    private static String get_SHA_1_SecurePassword(String passwordToHash,
            String salt) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(salt.getBytes());
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
                        .substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    private static String get_SHA_256_SecurePassword(String passwordToHash,
            String salt) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt.getBytes());
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
                        .substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    private static String get_SHA_384_SecurePassword(String passwordToHash,
            String salt) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-384");
            md.update(salt.getBytes());
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
                        .substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    private static String get_SHA_512_SecurePassword(String passwordToHash,
            String salt) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes());
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
                        .substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    // Add salt
    private static String getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt.toString();
    }
}

Output:
8c2d41d257922dd2447922ae28720c8beb3da1c6
01bc1b6bab4c9db909528139e9790dead1f0dc0a91d933c108914309b3c14a49
47afc09191b06e9968c76225f6e6b8c5f7542231a97631503c18b3f1d037fcc339cbf2826a4e7a94a4136ffb184d4446
d40ff6591ac0f91bd281c26cb05be0695e5474e8aa86a793012ffd931c516d2ba90e7782449268d0261945b60816c74e62839b71b745a86833255204a7f92aa3


Java PBKDF2WithHmacSHA1 Hash Example:
public static void main(String[] args) 
    throws NoSuchAlgorithmException, InvalidKeySpecException
{
    String  originalPassword = "password";

    String generatedSecuredPasswordHash 
        = generateStorngPasswordHash(originalPassword);
    System.out.println(generatedSecuredPasswordHash);
}
private static String generateStorngPasswordHash(String password) 
    throws NoSuchAlgorithmException, InvalidKeySpecException
{
    int iterations = 1000;
    char[] chars = password.toCharArray();
    byte[] salt = getSalt();

    PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
    SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

    byte[] hash = skf.generateSecret(spec).getEncoded();
    return iterations + ":" + toHex(salt) + ":" + toHex(hash);
}

private static byte[] getSalt() throws NoSuchAlgorithmException
{
    SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
    byte[] salt = new byte[16];
    sr.nextBytes(salt);
    return salt;
}

private static String toHex(byte[] array) throws NoSuchAlgorithmException
{
    BigInteger bi = new BigInteger(1, array);
    String hex = bi.toString(16);
    
    int paddingLength = (array.length * 2) - hex.length();
    if(paddingLength > 0)
    {
        return String.format("%0"  +paddingLength + "d", 0) + hex;
    }else{
        return hex;
    }
}




