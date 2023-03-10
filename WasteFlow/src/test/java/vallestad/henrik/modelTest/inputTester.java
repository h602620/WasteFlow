package vallestad.henrik.modelTest;

import org.junit.jupiter.api.Test;
import files.model.Deltaker;
import files.model.InputValidator;


import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class inputTester {

    Deltaker deltaker = new Deltaker(94192505,"Henrik", "Vallestad", 'M',"Passord1");

    public inputTester() throws NoSuchAlgorithmException {
    }

    @Test
    public void testValidInput() throws NoSuchAlgorithmException {

        assertEquals(InputValidator.isValidInput(deltaker,"Passord1"),true);
        assertEquals(InputValidator.isValidInput(deltaker,"Cracker1"), false);
    }

}
