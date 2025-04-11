package belle.sangthong.webshop.controller;

import belle.sangthong.webshop.model.Product;
import belle.sangthong.webshop.service.ProductService;
import belle.sangthong.webshop.service.ShoppingBasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/basket")
public class ShoppingBasketController {

    @Autowired
    private ShoppingBasketService basketService;

    @Autowired
    private ProductService productService;

    @GetMapping
    public String viewBasket(Model model) {
        model.addAttribute("items", basketService.getItems());
        model.addAttribute("total", basketService.getTotal());
        return "basket";
    }

    @PostMapping("/add")
    public String addToBasket(@RequestParam Long productId, @RequestParam int quantity) {
        Product product = productService.findById(productId);
        basketService.addProduct(product, quantity);
        return "redirect:/basket";
    }

    @PostMapping("/update")
    public String updateItem(@RequestParam Long productId, @RequestParam int quantity) {
        basketService.updateProductQuantity(productId, quantity);
        return "redirect:/basket";
    }

    @PostMapping("/remove")
    public String removeFromBasket(@RequestParam Long productId) {
        basketService.removeProduct(productId);
        return "redirect:/basket";
    }

    @PostMapping("/clear")
    public String clearBasket() {
        basketService.clearBasket();
        return "redirect:/basket";
    }

    @PostMapping("/checkout")
    public String checkoutBasket() {
        basketService.checkout();
        return "orderconfirmation";
    }
}
