package belle.sangthong.webshop.service;
import belle.sangthong.webshop.model.User;
import belle.sangthong.webshop.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo repository;


    public List<User> searchUserByName(String name) {
        return repository.findByName(name);
    }
}
