package belle.sangthong.webshop.controller;

import belle.sangthong.webshop.model.User;
import belle.sangthong.webshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String login(String username, String password, Model model) {
        if (userService.authenticate(username, password)) {
            model.addAttribute("message", userService.getWelcomeMessage(username));
            return "welcome";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }


    }

}
