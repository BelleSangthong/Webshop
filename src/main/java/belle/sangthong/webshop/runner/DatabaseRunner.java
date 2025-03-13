package belle.sangthong.webshop.runner;

import belle.sangthong.webshop.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseRunner implements CommandLineRunner {

    @Autowired
    ProductRepo repository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Test hello world");
    }
}
