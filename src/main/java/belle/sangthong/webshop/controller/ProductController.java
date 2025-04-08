package belle.sangthong.webshop.controller;

import belle.sangthong.webshop.model.Product;
import belle.sangthong.webshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public String searchProduct(@RequestParam String name, Model model) {
        Product product = productService.getProduct(name);
        model.addAttribute("product", product);
        return "product";
    }

    @GetMapping("/products")
    public String showProductPage(Model model) {
        List<String> categories = productService.getAllCategories();
        model.addAttribute("categories", categories);
        return "product";
    }

}
