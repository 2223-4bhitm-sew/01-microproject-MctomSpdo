package at.htl.dtos;

import at.htl.entities.Product;
import at.htl.entities.Users;

import javax.persistence.*;
import java.time.LocalDateTime;

public class AuctionDto {
    private Long id;
    private String name;
    private LocalDateTime endTs;
    private double price;
    private int bids;

    public AuctionDto(Long id, String name, LocalDateTime endTs, double price, int bids) {
        this.id = id;
        this.name = name;
        this.endTs = endTs;
        this.price = price;
        this.bids = bids;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getEndTs() {
        return endTs;
    }

    public void setEndTs(LocalDateTime endTs) {
        this.endTs = endTs;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBids() {
        return bids;
    }

    public void setBids(int bids) {
        this.bids = bids;
    }
}
