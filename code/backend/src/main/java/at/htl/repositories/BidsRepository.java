package at.htl.repositories;

import at.htl.dtos.BidDto;
import at.htl.entities.Auction;
import at.htl.entities.Bid;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class BidsRepository implements PanacheRepository<Bid> {
    @Inject
    UsersRepository usersRepository;

    @Inject
    AuctionRepository auctionRepository;


    public List<Bid> getBids(Long auctionId){
        return list("where auction_id = ?1 order", auctionId);
    }

    public List<Bid> getLastFiveBids(Long auctionId){
        return find("auction_id = ?1", Sort.descending("timestamp"),auctionId).range(0,5).list();
    }

    public Bid getLastBid(Long auctionId){
        return find("auction_id = ?1", Sort.descending("timestamp"),auctionId).firstResultOptional().get();
    }

    @Transactional
    public Bid insertBid(BidDto bidDto){
        var newBid = new Bid(
                bidDto.getAmount(),
                usersRepository.findById(bidDto.getUserId()),
                auctionRepository.findById(bidDto.getAuctionId()));
        return getEntityManager().merge(newBid);
    }
}
