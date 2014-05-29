package auction.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Evgenia
 */
public class BidConfirmation implements Serializable {
    public static final String RESULT_STATUS_REJECTED = "rejected";
    public static final String RESULT_STATUS_WON = "win";
    public static final String RESULT_STATUS_ADDED = "added";

    private String status;
    private String message;

    private BigDecimal topBidPrice;
    private int totalCountOfBids;
    private int topBidUser;

    public BidConfirmation() {}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BigDecimal getTopBidPrice() {
        return topBidPrice;
    }

    public void setTopBidPrice(BigDecimal topBidPrice) {
        this.topBidPrice = topBidPrice;
    }

    public int getTotalCountOfBids() {
        return totalCountOfBids;
    }

    public void setTotalCountOfBids(int totalCountOfBids) {
        this.totalCountOfBids = totalCountOfBids;
    }

    public int getTopBidUser() {
        return topBidUser;
    }

    public void setTopBidUser(int topBidUser) {
        this.topBidUser = topBidUser;
    }
}
