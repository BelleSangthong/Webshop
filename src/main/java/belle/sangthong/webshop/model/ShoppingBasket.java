package belle.sangthong.webshop.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {
    private List<OrderLine> items = new ArrayList<>();

    public void addItem(Product product, int quantity) {
        for (OrderLine item : items) {
            if (item.getProduct().getId().equals(product.getId())) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        items.add(new OrderLine(product, quantity));
    }

    public void updateItemQuantity(Long productId, int newQuantity) {
        for (OrderLine item : items) {
            if (item.getProduct().getId().equals(productId)) {
                item.setQuantity(newQuantity);
                return;
            }
        }
    }

    public void removeItem(Long productId) {
        items.removeIf(item -> item.getProduct().getId().equals(productId));
    }

    public List<OrderLine> getItems() {
        return items;
    }

    public void clear() {
        items.clear();
    }

    public double getTotal() {
        double total = 0.0;

        for (OrderLine item : items) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }

        return total;
    }

}