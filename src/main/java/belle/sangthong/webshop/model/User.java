package belle.sangthong.webshop.model;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String password;

    public User() {         // tom konstruktor måste alltid finnas pga JPA
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {      //kan behålla kvar denna setter ifall man vill ändra lösenord på en användare i framtiden
        this.password = password;
    }
}
