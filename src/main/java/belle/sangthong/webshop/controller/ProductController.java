package belle.sangthong.webshop.controller;

import belle.sangthong.webshop.model.Product;
import belle.sangthong.webshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/product")
    String getProductPage(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("productlist", productService.getAll());
        return "productpage";
    }

    @PostMapping("/search")
    String searchProduct(Model model, String name) {
        List<Product> products = productService.searchProductByName(name);
        model.addAttribute("productlist", products);
        model.addAttribute("product", new Product());
        return "productpage";
    }

    @PostMapping("/product")
    String showCategory(Model model, Product product) {
        model.addAttribute("product", productService.getAll());
        return "productpage";
    }




}
