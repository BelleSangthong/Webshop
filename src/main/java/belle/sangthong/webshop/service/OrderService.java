package belle.sangthong.webshop.service;

import belle.sangthong.webshop.model.Order;
import belle.sangthong.webshop.model.OrderLine;
import belle.sangthong.webshop.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private UserService userService;

    public void createOrder(List<OrderLine> items) {
        Order order = new Order();
        order.setOrderLine(items);
        order.setUser(userService.getAuthenticatedUser());
        order.setDate(LocalDateTime.now());
        orderRepo.save(order);
    }
}
