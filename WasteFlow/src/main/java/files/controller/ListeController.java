package files.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import files.model.FirmaService;
import files.util.LoginUtil;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("${app.url.liste}")
public class ListeController {

    @Autowired
    private FirmaService fc;

    @Value("${app.url.login}")
    private String LOGIN_URL;
    @Value("${app.url.logout")
    private String LOGOUT_URL;
    @Value("${app.message.requiresLogin}")
    private String REQUIRES_LOGIN_MESSAGE;

    @GetMapping
    public String hentListe(HttpSession session, RedirectAttributes ra, Model model) {

        if (!LoginUtil.isUserSignedIn(session)) {
            ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
            return "redirect:" + LOGIN_URL;
        }
        model.addAttribute("deltakerlist", fc.finnAlleDeltakere());

        return "listeView";
    }


}
