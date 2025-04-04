package belle.sangthong.webshop.service;

import belle.sangthong.webshop.model.Product;
import belle.sangthong.webshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    public Product getProduct(String name) {
        return productRepo.findByName(name);

    }
}
