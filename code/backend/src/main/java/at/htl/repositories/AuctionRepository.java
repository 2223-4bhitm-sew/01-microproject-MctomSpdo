package at.htl.repositories;

import at.htl.dtos.AuctionDto;
import at.htl.entities.Auction;
import at.htl.entities.Product;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.swing.*;
import javax.transaction.Transactional;
import java.lang.reflect.AccessibleObject;
import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class AuctionRepository implements PanacheRepository<Auction> {
    public List<Auction> getRunningAuctions() {
        return list("start_ts <= ?1 and end_ts >= ?1", LocalDateTime.now());
    }

    public Auction getAuctionById(Long auctionId) {
        return findById(auctionId);
    }

    @Transactional
    public Auction insertAuction(Auction newAuction){
        return getEntityManager().merge(newAuction);
    }
}
