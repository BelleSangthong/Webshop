package belle.sangthong.webshop.controller;
import belle.sangthong.webshop.model.User;
import belle.sangthong.webshop.service.ProductService;
import belle.sangthong.webshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @GetMapping("/user")
    String getUserPage(Model model) {
        model.addAttribute("user", new User());
        return "userpage";
    }

    @PostMapping("/login")
    String searchUser(Model model, String name) {
        User user = userService.login(name);
        model.addAttribute("productlist", productService.getAll());
        return "productpage";
    }

}
