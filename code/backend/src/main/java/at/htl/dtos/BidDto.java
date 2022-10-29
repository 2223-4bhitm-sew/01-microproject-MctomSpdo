package at.htl.dtos;

public class BidDto {
    private Long auctionId;
    private Long userId;
    private double amount;

    public BidDto() {
    }

    public BidDto(Long auctionId, Long userId, double amount) {
        this.auctionId = auctionId;
        this.userId = userId;
        this.amount = amount;
    }

    public Long getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Long auctionId) {
        this.auctionId = auctionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
