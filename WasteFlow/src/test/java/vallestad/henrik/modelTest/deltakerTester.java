package vallestad.henrik.modelTest;

import org.junit.jupiter.api.Test;
import files.model.Deltaker;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

public class deltakerTester {

    Deltaker deltaker1 = new Deltaker(94192505, "Henrik", "Vallestad", 'M', "Passord1");
    Deltaker deltaker2 = new Deltaker(9419250, "H", "Vallestad", 'M', "Passord1");
    Deltaker deltaker3 = new Deltaker(94192505, "Henrik", "V", 'M', "Passord1");
    Deltaker deltaker4 = new Deltaker(94192505, "Henrik", "Vallestad", 'A', "Passord1");
    Deltaker deltaker5 = new Deltaker(94192505, "Henrik", "Vallestad", 'M', "");

    public deltakerTester() throws NoSuchAlgorithmException {

    }

    @Test
    public void testIsValid() {
        assertTrue(deltaker1.isValid());
        assertFalse(deltaker2.isValid());
        assertFalse(deltaker3.isValid());
        assertFalse(deltaker4.isValid());
        assertFalse(deltaker5.isValid());

    }

}
