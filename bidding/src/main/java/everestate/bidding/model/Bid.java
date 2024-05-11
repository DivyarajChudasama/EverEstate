package everestate.bidding.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.Instant;

public class Bid {

    @NotBlank(message = "User ID must not be blank")
    private String userId;

    @Positive(message = "Bid amount must be positive")
    private double amount;

    // Property ID for the bid
    private String propertyId;

    //in project, wherever there is time related thing, datatype will be Instant
    @NotNull(message = "Bid time must not be null")
    private Instant time;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    // Constructors, getters, setters
}
