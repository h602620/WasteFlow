package files.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("${app.url.kvittering}")
public class KvitteringController {


    @Value("${app.url.login}")
    private String LOGIN_URL;
    @Value("${app.url.kvittering}")
    private String KVITTERING_URL;

    @GetMapping
    public String hentKvittering(Model model,
                                 @CookieValue(value = "fornavn", defaultValue = "") String fornavn,       //fetch from cookies
                                 @CookieValue(value = "etternavn", defaultValue = "") String etternavn, //fetch from cookies
                                 @CookieValue(value = "mobilnr", defaultValue = "mobilnummer") String mobilnr )      //fetch from cookies
    {
        //henter verdien fra cookies og pusher den til jsp via model, dersom ingen informasjon er lagra får ein standardverdi
        model.addAttribute("fornavn",fornavn);
        model.addAttribute("etternavn",etternavn);
        model.addAttribute("mobilnr",mobilnr);

        return "kvitteringView";
    }

    @GetMapping(value = "/login")
        public String LoggInn() {
            return "redirect:" + LOGIN_URL;
        }


}
