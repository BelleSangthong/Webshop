package belle.sangthong.webshop.controller;

import belle.sangthong.webshop.model.Product;
import belle.sangthong.webshop.model.User;
import belle.sangthong.webshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    String getUserPage(Model model) {
        model.addAttribute("user", new User());
        return "userpage";
    }

    @PostMapping("/searchuser")
    String searchProduct(Model model, String name) {
        List<User> users = userService.searchUserByName(name);
        model.addAttribute("userlist", users);
        model.addAttribute("user", new User());
        return "userpage";
    }

}
