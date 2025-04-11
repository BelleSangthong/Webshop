package belle.sangthong.webshop.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders") //Undvika namnkonflikter med SQL eftersom att orders är ett reserverat ord
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderid")
    private List<OrderLine> orderLines;

    @ManyToOne
    private User user;

    public Order() {
        this.date = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<OrderLine> getOrderLine() {
        return orderLines;
    }

    public void setOrderLine(List<OrderLine> orderLine) {
        this.orderLines = orderLine;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
