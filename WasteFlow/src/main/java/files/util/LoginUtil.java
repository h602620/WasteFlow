package files.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginUtil {

    private final static int MAX_INTERACTIVE_INTERVAL = 900;

    public static void logoutUser(HttpSession session) {
        session.invalidate();
    }

    public static void logInUser(HttpServletRequest request, Integer mobilnummer, String password) {


        logoutUser(request.getSession());

        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(MAX_INTERACTIVE_INTERVAL);
        session.setAttribute("mobilnummer", mobilnummer);
        session.setAttribute("password", password);

    }

    public static boolean isUserSignedIn(HttpSession session) {
        return session != null
                && session.getAttribute("mobilnummer") != null
                && session.getAttribute("password") != null;

    }
}
