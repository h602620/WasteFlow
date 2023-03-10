package files.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import files.util.LoginUtil;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/${app.url.logout}")
public class LogOutController {

    @Value("${app.message.loggedOut}") private String LOGGED_OUT_MESSAGE;
    @Value("${app.url.login}") private String LOGIN_URL;

    @PostMapping
    public String logOut(HttpSession session, RedirectAttributes ra) {

        if (LoginUtil.isUserSignedIn(session)) {
            LoginUtil.logoutUser(session);
        }

        ra.addFlashAttribute("redirectMessage", LOGGED_OUT_MESSAGE);
        return "redirect:" + LOGIN_URL;
    }

}
