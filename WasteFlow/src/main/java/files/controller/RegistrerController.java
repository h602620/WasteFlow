package files.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import files.model.Deltaker;
import files.model.FirmaService;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;


@Controller
@RequestMapping("${app.url.registrer}")
public class RegistrerController {

    @Autowired
    private FirmaService fc;

    @Value("${app.url.login}")
    private String LOGIN_URL;
    @Value("${app.url.kvittering}")
    private String KVITTERING_URL;


    @GetMapping
    public String hentPaameldingSkjema() {
        return "regView"; //navnet på login jsp filen
    }

    @PostMapping
    public String registrerMedlem(
            @RequestParam(name = "mobil") String mobilnummer, @RequestParam(name = "fornavn") String fornavn,
            @RequestParam(name = "etternavn") String etternavn, @RequestParam(name = "passord") String passord,
            @RequestParam(name = "kjonn") String kjonn, RedirectAttributes ra, HttpServletResponse response
    ) throws NoSuchAlgorithmException {


        char gender = kjonn.charAt(0);

        Deltaker deltaker = new Deltaker(Integer.valueOf(mobilnummer), fornavn, etternavn, gender, passord);

        if (!fc.leggTilDeltaker(deltaker)) {
            ra.addFlashAttribute("redirectMessage", "Ein brukar med denne informasjonen er allerede registert, eller noko gjekk galt");
            return "redirect:" + LOGIN_URL;
        }


        //dersom alt blei godkjent, lagre noke av informasjonen i cookies
        Cookie fistname = new Cookie("fornavn",fornavn);
        Cookie lastname = new Cookie("etternavn",etternavn);
        Cookie phonenumber = new Cookie("mobilnr", mobilnummer);
        response.addCookie(fistname); //add firstname to cookies
        response.addCookie(lastname); //add firstname to cookies
        response.addCookie(phonenumber); //add firstname to cookies

        return "redirect:" + KVITTERING_URL;
    }


}
