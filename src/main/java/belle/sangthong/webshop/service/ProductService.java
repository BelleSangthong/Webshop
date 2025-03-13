package belle.sangthong.webshop.service;
import belle.sangthong.webshop.model.Product;
import belle.sangthong.webshop.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    @Autowired
    ProductRepo repository;

    public List<Product> getAll() {
        return repository.findAll();
    }

    public List<Product> searchProductByName(String name) {
        return repository.findByName(name);
    }
}
