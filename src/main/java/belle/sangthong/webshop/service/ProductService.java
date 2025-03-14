package belle.sangthong.webshop.service;
import belle.sangthong.webshop.model.Product;
import belle.sangthong.webshop.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public List<Product> getAll() {
        return productRepo.findAll();
    }

    public List<Product> searchProductByName(String name) {
        return productRepo.findByName(name);
    }
}
