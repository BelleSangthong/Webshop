package belle.sangthong.webshop.controller;

import belle.sangthong.webshop.model.User;
import belle.sangthong.webshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    String getUserPage(Model model) {
        model.addAttribute("user", new User());
        return "userpage";
    }


}
