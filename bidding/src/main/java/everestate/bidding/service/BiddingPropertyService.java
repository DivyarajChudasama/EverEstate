package everestate.bidding.service;

import everestate.bidding.model.BiddingProperty;
import everestate.bidding.repository.BiddingPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@SpringBootApplication
@Service
public class BiddingPropertyService {
    @Autowired
    private BiddingPropertyRepository biddingPropertyRepository;

    public BiddingProperty addBiddingProperty(BiddingProperty property) {
        return biddingPropertyRepository.save(property);
    }

    public List<BiddingProperty> getAllBiddingProperties() {
        return biddingPropertyRepository.findAll();
    }

    public Optional<BiddingProperty> getPropertyById(String propertyId) {
        return biddingPropertyRepository.findById(propertyId);
    }

    public BiddingProperty updateProperty(BiddingProperty property) {
        return biddingPropertyRepository.save(property);
    }

    public void deleteProperty(String propertyId) {
        biddingPropertyRepository.deleteById(propertyId);
    }
}
