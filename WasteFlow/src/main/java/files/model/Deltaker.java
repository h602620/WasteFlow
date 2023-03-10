package files.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.security.NoSuchAlgorithmException;

@Entity
@Table(name = "fest", schema = "public")
public class Deltaker {

    @Id
    private Integer mobilnummer;

    private String fornavn;
    private String etternavn;
    private char kjonn;
    private String passord;

    public Deltaker() {
    }

    public Deltaker(Integer mobilnummer, String fornavn, String etternavn, char kjonn, String passord) throws NoSuchAlgorithmException {


        this.mobilnummer = mobilnummer;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.kjonn = kjonn;
        this.passord = passord;

        if (this.isValid()) {
            this.passord = PasswordHandler.hashAndSalt(passord);
        } else {
            this.mobilnummer = null;
            this.fornavn = null;
            this.etternavn = null;
            this.kjonn = 'X';
            this.passord = null;
        }

    }

    public Integer getMobilnummer() {
        return mobilnummer;
    }

    public String getFornavn() {
        return fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public String getPassord() {
        return passord;
    }

    public char getKjonn() {
        return kjonn;
    }


    @Override
    public String toString() {
        return "Deltaker [ mobilnummer=" + mobilnummer +
                ", fornavn=" + fornavn +
                ", etternavn=" + etternavn +
                ", kjonn=" + kjonn + " ]";
    }

    public boolean isValid() { //double check that information follows the rules

        if(mobilnummer == null){ //this means the deltaker is empty
            return false;
        }

        if (mobilnummer.toString().length() != 8) { //if phone number is not 8 characters long do not add
            return false;
        }
        if (fornavn.length() < 2 || fornavn.length() > 20) { //firstname should be between 2 and 20
            return false;
        }
        if (etternavn.length() < 2 || etternavn.length() > 20) { //lastname should be between 2 and 20
            return false;
        }
        if (kjonn != 'M' && kjonn != 'F') { // gender cannot be other than M(male) or F(female)
            return false;
        }

        if (passord == null || passord.length() < 5) { //must have password
            return false;
        }

        return true;
    }

}

