package everestate.bidding.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import java.time.Instant;
import java.util.List;

@Document(collection = "bidding_properties")
public class BiddingProperty {
    //in project, wherever there is time related thing, datatype will be Instant
            private String id;
            private String ownerId;
            private String title;
            private String description;
            private String address;
            private String city;
            private String country;
            private double startingPrice;
            private Instant biddingStartTime;
            private Instant biddingEndTime;
    private List<Bid> bids;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(double startingPrice) {
        this.startingPrice = startingPrice;
    }

    public Instant getBiddingStartTime() {
        return biddingStartTime;
    }

    public void setBiddingStartTime(Instant biddingStartTime) {
        this.biddingStartTime = biddingStartTime;
    }

    public Instant getBiddingEndTime() {
        return biddingEndTime;
    }

    public void setBiddingEndTime(Instant biddingEndTime) {
        this.biddingEndTime = biddingEndTime;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }

    // Getters and setters
}
