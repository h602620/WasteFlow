package files.model;

import java.security.NoSuchAlgorithmException;

public class InputValidator {


    public static boolean isValidInput(Deltaker deltaker, String inputPassword) throws NoSuchAlgorithmException {

            return isValidPassword(inputPassword, deltaker.getPassord()); //return true if password is correct

    }


    private static boolean isValidPassword(String inputPassword, String storedPassword) throws NoSuchAlgorithmException {
        String pass = PasswordHandler.hashAndSalt(inputPassword);

        if (pass.equals(storedPassword)) { //if the hased and salted version of user input matches the password from database, return true
            return true;
        }

        return false;
    }


}
