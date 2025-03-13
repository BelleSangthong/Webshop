package belle.sangthong.webshop.repository;

import belle.sangthong.webshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    void findByName(String name);
}
