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
import files.model.InputValidator;
import files.util.LoginUtil;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping("${app.url.login}")
public class LogInController {

    @Autowired
    private FirmaService fc;

    @Value("${app.message.illegalInput}")
    private String ILLEGAL_INPUT;
    @Value("${app.message.invalidLogin}")
    private String INVALID_LOGIN;
    @Value("${app.message.invalidUser}")
    private String INVALID_USER;
    @Value("${app.url.login}")
    private String LOGIN_URL;
    @Value("${app.url.registrer}")
    private String REGISTRER_URL;
    @Value("${app.url.liste}")
    private String LISTE_URL;


    @GetMapping
    public String hentLoginSkjema() {
        return "loginView"; //navnet på login jsp filen
    }

    @PostMapping
    public String provAaLoggeInn(@RequestParam String mobilnummer, @RequestParam String passord,
                                 HttpServletRequest request, RedirectAttributes ra) throws NoSuchAlgorithmException {

        Integer mobNr; //this makes sure we run the test on numbers only, otherwise it might crash
        try {
            mobNr = Integer.valueOf(mobilnummer.trim());
        } catch (Exception e){
            mobNr = -1;
        }


        if(mobNr.toString().length() != 8 || passord.length()<5) { //if length of mobnr and password less than five do not test, should automatic crash
            ra.addFlashAttribute("redirectMessage", ILLEGAL_INPUT);
            return "redirect:" + LOGIN_URL;
        }

        Deltaker deltaker = fc.finnDeltakerMedMobnr(mobNr);
        if (deltaker==null) {
            ra.addFlashAttribute("redirectMessage", INVALID_USER);
            return "redirect:" + LOGIN_URL;
        }

        if (!InputValidator.isValidInput(deltaker, passord)) {
            ra.addFlashAttribute("redirectMessage", INVALID_LOGIN);
            return "redirect:" + LOGIN_URL;
        }

        LoginUtil.logInUser(request, mobNr, passord);

        return "redirect:" + LISTE_URL;
    }

    @GetMapping(value = "/registrer")
    public String Registrer() {
        return "redirect:" + REGISTRER_URL;
    }

}