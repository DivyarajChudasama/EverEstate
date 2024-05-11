package everestate.bidding.controller;

import everestate.bidding.model.Bid;
import everestate.bidding.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/bids")
public class BidController {

    @Autowired
    private BidService bidService;

    @PostMapping("/add/{propertyId}")
    public ResponseEntity<Bid> addBid(@PathVariable("propertyId") String propertyId, @Valid @RequestBody Bid bid) {
        // Pass propertyId to the bid service to associate the bid with the property
        Bid addedBid = bidService.addBid(propertyId, bid);
        return new ResponseEntity<>(addedBid, HttpStatus.CREATED);
    }
}
