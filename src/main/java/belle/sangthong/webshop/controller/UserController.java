package belle.sangthong.webshop.controller;

import belle.sangthong.webshop.model.User;
import belle.sangthong.webshop.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, String password, Model model, HttpSession session) {
        if (userService.authenticate(user.getName(), user.getPassword())) {
            User loggedInUser = userService.findByName(user.getName());
            session.setAttribute("user", loggedInUser);
            model.addAttribute("message", userService.getWelcomeMessage(user.getName()));
            return "redirect:/welcome";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    @GetMapping("/welcome")
    public String showWelcomePage(Model model, HttpSession session) {
        User user = userService.getAuthenticatedUser(session);
        if (user != null) {
            model.addAttribute("user", user);
            return "welcome";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

}
