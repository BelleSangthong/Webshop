package belle.sangthong.webshop.service;
import belle.sangthong.webshop.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

    @Autowired
    ProductRepo repository;


}
