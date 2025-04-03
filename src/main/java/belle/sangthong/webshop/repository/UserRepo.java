package belle.sangthong.webshop.repository;

import belle.sangthong.webshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByName(String name);
}
