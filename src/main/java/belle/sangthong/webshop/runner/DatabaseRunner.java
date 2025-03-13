package belle.sangthong.webshop.runner;

import belle.sangthong.webshop.model.Product;
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
        repository.save(new Product("Banan", 12, "Frukt"));
        repository.save(new Product("Gurka", 20, "Grönsak"));
        repository.save(new Product("Mjölk", 10, "Mejeri"));
        repository.save(new Product("Kaffe", 30, "Dryck"));

    }
}
