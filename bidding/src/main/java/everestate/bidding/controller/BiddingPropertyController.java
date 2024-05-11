package everestate.bidding.controller;

import everestate.bidding.model.BiddingProperty;
import everestate.bidding.service.BiddingPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/bidding/properties")
@Validated
public class BiddingPropertyController {

    @Autowired
    private BiddingPropertyService biddingPropertyService;

    @PostMapping("/add")
    public ResponseEntity<BiddingProperty> addBiddingProperty(@Valid @RequestBody BiddingProperty property) {
        BiddingProperty addedProperty = biddingPropertyService.addBiddingProperty(property);
        System.out.println(property.getTitle());
        return new ResponseEntity<>(addedProperty, HttpStatus.CREATED);
    }

    @PostMapping("/all")
    public ResponseEntity<List<BiddingProperty>> getAllBiddingProperties() {
        List<BiddingProperty> properties = biddingPropertyService.getAllBiddingProperties();
        return new ResponseEntity<>(properties, HttpStatus.OK);
    }

    @PostMapping("/getById")
    public ResponseEntity<BiddingProperty> getPropertyById(@RequestBody @NotBlank String propertyId) {
        return biddingPropertyService.getPropertyById(propertyId)
                .map(property -> new ResponseEntity<>(property, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/update")
    public ResponseEntity<BiddingProperty> updateProperty(@Valid @RequestBody BiddingProperty property) {
        BiddingProperty updatedProperty = biddingPropertyService.updateProperty(property);
        return new ResponseEntity<>(updatedProperty, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteProperty(@RequestBody @NotBlank String propertyId) {
        biddingPropertyService.deleteProperty(propertyId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
