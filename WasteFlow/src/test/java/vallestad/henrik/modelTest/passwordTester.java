package vallestad.henrik.modelTest;

import org.junit.jupiter.api.Test;
import files.model.PasswordHandler;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class passwordTester {

    private String svakPassord = "Passord1"; //veldig svakt passord
    private String sterkPassord = "£89jIO9ARiojfaaf3!$JJIH87wfH@UI"; //Veldig sterkt passord

    @Test
    public void testSalt() throws NoSuchAlgorithmException {
        assertEquals(PasswordHandler.hash("o"), PasswordHandler.salt(svakPassord)); //dersom lenden av passord under 10, så er salt = hash(char nr.5)
        assertEquals(PasswordHandler.hash("i"), PasswordHandler.salt(sterkPassord)); //dersom lenden av passord over 10, så er salt = hash(char nr.10)

    }

    @Test
    public void testHash() throws NoSuchAlgorithmException {
        assertEquals(PasswordHandler.hash(svakPassord).length(), PasswordHandler.hash(sterkPassord).length()); //alle hasher skal være like lange
    }

    @Test
    public void testHashAndSalt() throws NoSuchAlgorithmException {
        String godtSaltaHash = PasswordHandler.hash(svakPassord) + PasswordHandler.salt(svakPassord);

        assertEquals(PasswordHandler.hashAndSalt(svakPassord), godtSaltaHash);
    }


}
