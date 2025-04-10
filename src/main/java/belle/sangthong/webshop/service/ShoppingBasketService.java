package belle.sangthong.webshop.service;

import belle.sangthong.webshop.model.Product;
import belle.sangthong.webshop.model.ShoppingBasket;
import belle.sangthong.webshop.model.ShoppingBasketItem;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@Service
@SessionScope
public class ShoppingBasketService {

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

    public List<ShoppingBasketItem> getItems() {
        return basket.getItems();
    }

    public double getTotal() {
        return basket.getTotal();
    }
}
