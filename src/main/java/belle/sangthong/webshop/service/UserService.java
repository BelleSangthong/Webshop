package belle.sangthong.webshop.service;
import belle.sangthong.webshop.model.ShoppingCart;
import belle.sangthong.webshop.model.User;
import belle.sangthong.webshop.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@Service
@SessionScope
public class UserService {

    User user;
    ShoppingCart shoppingCart;

    @Autowired
    UserRepo userRepo;

    public User login(String name) {
        List<User> users = userRepo.findByName(name);
        if (!users.isEmpty()) {
            user = users.get(0);
            return user;
        } else {
            user = userRepo.save(new User(name));
            return user;
        }
    }
}
