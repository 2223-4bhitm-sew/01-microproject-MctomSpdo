package at.htl.resources;

import at.htl.dtos.BidDto;
import at.htl.entities.Auction;
import at.htl.entities.Bid;
import at.htl.repositories.AuctionRepository;
import at.htl.repositories.BidsRepository;
import at.htl.repositories.UsersRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Path("bid")
public class BidResource {
    @Inject
    BidsRepository bidsRepository;

    @GET
    @Path("/last-for-auction/{auctionId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bid> getLastFiveBids(@PathParam("auctionId") Long auctionId){
        return bidsRepository.getLastFiveBids(auctionId);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertBid(@Context UriInfo uriInfo, BidDto bidDto){
        var bid = bidsRepository.insertBid(bidDto);
        var uri = uriInfo.getAbsolutePathBuilder().path(bid.getId().toString()).build();

        return Response.created(uri).entity(bid).build();
    }
}
