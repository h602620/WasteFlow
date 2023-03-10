package files.model;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHandler {

    public static String hashAndSalt(String passord) throws NoSuchAlgorithmException { //slår sammen hash og salt
        String pass = "";
        pass += hash(passord);
        pass += salt(passord);
        return pass;
    }

    public static String hash(String passord) throws NoSuchAlgorithmException { //lager en hash256 versjon av passordet

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(passord.getBytes());

        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }

    public static String salt(String password) throws NoSuchAlgorithmException { //lager en salt til passordet
        String salt = "";
        if (password.length() >= 10) {
            salt += password.charAt(9);
        } else {
            salt += password.charAt(4);
        }

        return hash(salt);
    }

}
