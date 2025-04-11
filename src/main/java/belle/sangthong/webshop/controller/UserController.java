package belle.sangthong.webshop.controller;

import belle.sangthong.webshop.model.User;
import belle.sangthong.webshop.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String login(@RequestParam String name, @RequestParam String password, Model model, HttpSession session) {
       if (userService.authenticate(name, password)) {
           User loggedInUser = userService.findByName(name);
           session.setAttribute("user", loggedInUser);
              model.addAttribute("message", userService.getWelcomeMessage(name));
              return "redirect:/welcome";
       } else {
           model.addAttribute("error", "Invalid username or password");
           return "login";
       }
    }

    @GetMapping("/welcome")
    public String showWelcomePage(Model model) {
        User user = userService.getAuthenticatedUser();
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
