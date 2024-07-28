package testing;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//SHA-2
public class PasswordHashingExample {
    public static void main(String[] args) {
//        String password = "123456789012345";//limit 15 char
//        String hashedPassword = hashPassword(password);
//        System.out.println("Hashed password: " + hashedPassword);
    	String hashString="e27a7686b8028cfee7b57d954c3abccfb2a701968925f52bbd482e77be5de0bb";
    	System.out.println(hashString.length());
    }
//    private static String bytesToHex(byte[] hash) {
//        StringBuilder hexString = new StringBuilder(2 * hash.length);
//        for (byte b : hash) {
//            String hex = Integer.toHexString(0xff & b);
//            if (hex.length() == 1) {
//                hexString.append('0');
//            }
//            hexString.append(hex);
//        }
//        return hexString.toString();
//    }
//    public static String hashPassword(String password) throws NoSuchAlgorithmException{
//        MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
//        byte[] passBytes = password.getBytes(StandardCharsets.UTF_8);
//        byte[] passHash = sha256.digest(passBytes);
//        return bytesToHex(passHash);
//    }
}