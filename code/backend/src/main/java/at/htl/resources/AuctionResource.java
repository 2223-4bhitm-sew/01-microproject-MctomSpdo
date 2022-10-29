package at.htl.resources;

import at.htl.dtos.AuctionDto;
import at.htl.entities.Auction;
import at.htl.entities.Bid;
import at.htl.entities.Product;
import at.htl.repositories.AuctionRepository;
import at.htl.repositories.BidsRepository;
import at.htl.repositories.ProductRepository;
import at.htl.repositories.UsersRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Path("auction")
public class AuctionResource {
    @Inject
    AuctionRepository auctionRepository;

    @Inject
    UsersRepository usersRepository;

    @Inject
    ProductRepository productRepository;

    @Inject
    BidsRepository bidsRepository;

    @GET
    @Path("get-running")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AuctionDto> getRunningAuctions() {
        return auctionRepository.getRunningAuctions().stream()
                .map(a -> new AuctionDto(
                        a.getId(),
                        a.getProduct().getName(),
                        a.getEndTs(),
                        a.getBids().size() == 0 ? a.getStartPrice() : bidsRepository.getLastBid(a.getId()).getAmount(),
                        a.getBids().size()))
                .collect(Collectors.toList());
    }

    @GET
    @Path("{auctionId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Auction getAuctionById(@PathParam("auctionId") Long auctionId) {
        return auctionRepository.getAuctionById(auctionId);
    }

    @POST
    @Path("import-for-user/{userId}")
    public String importForUser(@PathParam("userId") Long userId, String csv) {
        var lines = csv.replace(",",";").replace("\"", "").split("\n");
        var cols = lines[0].split(";");
        var colHeader = new HashMap<String, Integer>();

        for (int i = 0; i < cols.length; i++) {
            switch (cols[i]) {
                case "PRODUCTNAME":
                    colHeader.put("PRODUCTNAME", i);
                    break;
                case "DESCRIPTION":
                    colHeader.put("DESCRIPTION", i);
                    break;
                case "START":
                    colHeader.put("START", i);
                    break;
                case "END":
                    colHeader.put("END", i);
                    break;
                case "START_PRICE":
                    colHeader.put("START_PRICE", i);
                    break;
            }
        }

        var user = usersRepository.findById(userId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        Arrays.stream(lines).skip(1).forEach(line ->
            {
                var dataCols = line.split(";");
                var product = productRepository.findByName(dataCols[colHeader.get("PRODUCTNAME")]);
                if (product == null) {
                    product = productRepository.insertProduct(
                            new Product(
                                    dataCols[colHeader.get("PRODUCTNAME")],
                                    dataCols[colHeader.get("DESCRIPTION")]));
                }
                var newAuction = new Auction(
                        Double.parseDouble(dataCols[colHeader.get("START_PRICE")]),
                        LocalDateTime.parse(dataCols[colHeader.get("START")], formatter),
                        LocalDateTime.parse(dataCols[colHeader.get("END")], formatter),
                        product,
                        user
                );
                auctionRepository.insertAuction(newAuction);
            }
        );

        return String.format("CSV imported... Processed %s lines", lines.length - 1);
    }
}