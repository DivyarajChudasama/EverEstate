package everestate.bidding.repository;
import everestate.bidding.model.BiddingProperty;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BiddingPropertyRepository extends MongoRepository<BiddingProperty, String> {
}
