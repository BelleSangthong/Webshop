package belle.sangthong.webshop.service;

import belle.sangthong.webshop.model.User;
import belle.sangthong.webshop.repository.UserRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User findByName(String username) {
        return userRepo.findByName(username);
    }

    public boolean authenticate(String username, String password) {
        User user = userRepo.findByName(username);
        return user != null && user.getPassword().equals(password);
    }


    public String getWelcomeMessage(String username) {
        return "Welcome " + username + "!";
    }

    public User getAuthenticatedUser(HttpSession session) {
        return (User) session.getAttribute("user");
    }
}
