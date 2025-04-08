package belle.sangthong.webshop.service;

import belle.sangthong.webshop.model.Product;
import belle.sangthong.webshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Service
@SessionScope
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    public Product getProduct(String name) {
        return productRepo.findByName(name);
    }

    public List<String> getAllCategories() {
        List<Product> allProducts = productRepo.findAll();
        List<String> categories = new ArrayList<>();

        for (Product product : allProducts) {
            String category = product.getCategory();
            if (category != null && !categories.contains(category)) {
                categories.add(category);
            }
        }

        return categories;
    }
}
