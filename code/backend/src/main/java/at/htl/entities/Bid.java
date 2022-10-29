package at.htl.entities;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USERS_ID")
    private Users user;
    private LocalDateTime timestamp;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonbTransient
    private Auction auction;

    public Bid() {
        this.timestamp = LocalDateTime.now();
    }

    public Bid(double amount, Users user, Auction auction) {
        this();
        this.amount = amount;
        this.user = user;
        this.timestamp = timestamp;
        this.auction = auction;
    }

    public Long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Users getUsers() {
        return user;
    }

    public void setUsers(Users users) {
        this.user = users;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }
}
