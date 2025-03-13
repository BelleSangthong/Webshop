package belle.sangthong.webshop.controller;

import belle.sangthong.webshop.model.Product;
import belle.sangthong.webshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/product")
    String getProductPage(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("category", productService.getCategory());
        return "productpage";
    }

    @PostMapping("/search")
    String searchProduct(Model model, String name) {
        productService.searchProduct(name);
        model.addAttribute("productlist", productService.getAll());
        model.addAttribute("product", new Product());
        return "productpage";

    }

    @PostMapping("/product")
    String showCategory(Model model, Product product) {
        model.addAttribute("category", productService.getCategory());
        return "productpage";
    }




}
