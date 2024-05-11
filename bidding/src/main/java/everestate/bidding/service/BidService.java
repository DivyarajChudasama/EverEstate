package everestate.bidding.service;


import everestate.bidding.model.Bid;
import everestate.bidding.model.BiddingProperty;
import everestate.bidding.repository.BidRepository;
import everestate.bidding.repository.BiddingPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BidService {

    @Autowired
    private BidRepository bidRepository;

    @Autowired
    private BiddingPropertyRepository biddingPropertyRepository;

    public Bid addBid(String propertyId, Bid bid) {
        // Find the corresponding BiddingProperty document
        BiddingProperty property = biddingPropertyRepository.findById(propertyId)
                .orElseThrow(() -> new RuntimeException("Property not found with id: " + propertyId));

        // Update the bids field of the BiddingProperty document
        if (property.getBids() != null)
        property.getBids().add(bid);
        else property.setBids(Collections.singletonList(bid));

        // Save the updated BiddingProperty document
        biddingPropertyRepository.save(property);

        // Save the bid to the repository
        return bidRepository.save(bid);
    }
}