package belle.sangthong.webshop.repository;

import belle.sangthong.webshop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

}
