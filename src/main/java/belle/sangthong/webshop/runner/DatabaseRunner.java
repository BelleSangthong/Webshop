package belle.sangthong.webshop.runner;

import belle.sangthong.webshop.model.Product;
import belle.sangthong.webshop.model.User;
import belle.sangthong.webshop.repository.ProductRepo;
import belle.sangthong.webshop.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseRunner implements CommandLineRunner {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    UserRepo userRepo;

    @Override
    public void run(String... args) throws Exception {
//        productRepo.save(new Product("Banan", 12, "Frukt"));
//        productRepo.save(new Product("Gurka", 20, "Grönsak"));
//        productRepo.save(new Product("Mjölk", 10, "Mejeri"));
//        productRepo.save(new Product("Kaffe", 30, "Dryck"));
//
////        productRepo.deleteById(102);
////        productRepo.deleteById(103);
////        productRepo.deleteById(104);
////        productRepo.deleteById(105);
//
//        userRepo.save(new User("Belle"));


    }
}
