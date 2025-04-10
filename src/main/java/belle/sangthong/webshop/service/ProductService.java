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

    public List<Product> getProductsByCategory(String category) {
        List<Product> allProducts = productRepo.findAll();
        List<Product> productsByCategory = new ArrayList<>();

        for (Product product : allProducts) {
            if (product.getCategory() != null && product.getCategory().equalsIgnoreCase(category)) {
                productsByCategory.add(product);
            }
        }

        return productsByCategory;
    }

    public List<Product> searchProductsByName(String name) {
        List<Product> allProducts = productRepo.findAll();
        List<Product> matches = new ArrayList<>();

        for (Product product : allProducts) {
            if (product.getName() != null && product.getName().toLowerCase().contains(name.toLowerCase())) {
                matches.add(product);
            }
        }

        return matches;
    }

    public Product findById(Long id) {
        return productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Produkt hittades inte"));
    }
}
