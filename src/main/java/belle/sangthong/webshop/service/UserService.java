package belle.sangthong.webshop.service;

import belle.sangthong.webshop.model.User;
import belle.sangthong.webshop.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class UserService {

    User user;

    @Autowired
    private UserRepo userRepo;

    public User findByName(String username) {
        return userRepo.findByName(username);
    }

    public boolean authenticate(String username, String password) {
        User user = userRepo.findByName(username);
        if (user != null && user.getPassword().equals(password)) {
            this.user = user;
            return true;
        } else {
            return false;
        }
    }

    public String getWelcomeMessage(String username) {
        return "Welcome " + username + "!";
    }

    public User getAuthenticatedUser() {
        return user;
    }
}
