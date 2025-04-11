package belle.sangthong.webshop.service;

import belle.sangthong.webshop.model.OrderLine;
import belle.sangthong.webshop.model.Product;
import belle.sangthong.webshop.model.ShoppingBasket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@Service
@SessionScope
public class ShoppingBasketService {

    @Autowired
    OrderService orderService;

    private ShoppingBasket basket = new ShoppingBasket(); //Ska vara final eller ej?

    public void addProduct(Product product, int quantity) {
        basket.addItem(product, quantity);
    }

    public void updateProductQuantity(Long productId, int newQuantity) {
        basket.updateItemQuantity(productId, newQuantity);
    }

    public void removeProduct(Long productId) {
        basket.removeItem(productId);
    }

    public void clearBasket() {
        basket.clear();
    }

    public List<OrderLine> getItems() {
        return basket.getItems();
    }

    public double getTotal() {
        return basket.getTotal();
    }

    public void checkout() {
        orderService.createOrder(basket.getItems());
    }
}
