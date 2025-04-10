package belle.sangthong.webshop.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {
    private List<ShoppingBasketItem> items = new ArrayList<>();

    public void addItem(Product product, int quantity) {
        for (ShoppingBasketItem item : items) {
            if (item.getProduct().getId().equals(product.getId())) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        items.add(new ShoppingBasketItem(product, quantity));
    }

    public void updateItemQuantity(Long productId, int newQuantity) {
        for (ShoppingBasketItem item : items) {
            if (item.getProduct().getId().equals(productId)) {
                item.setQuantity(newQuantity);
                return;
            }
        }
    }

    public void removeItem(Long productId) {
        items.removeIf(item -> item.getProduct().getId().equals(productId));
    }

    public List<ShoppingBasketItem> getItems() {
        return items;
    }

    public void clear() {
        items.clear();
    }

    public double getTotal() {
        return items.stream()
                .mapToDouble(ShoppingBasketItem::getTotalPrice)
                .sum();
    }
}