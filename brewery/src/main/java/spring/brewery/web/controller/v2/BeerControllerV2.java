package spring.brewery.web.controller.v2;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import spring.brewery.services.v2.BeerServiceV2;
import spring.brewery.web.model.v2.BeerDTOV2;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 *This class handle a get mapping to return back a beer id
 */
@Validated
@RestController
@RequestMapping("/api/v2/beer")
public class BeerControllerV2 {

    private final BeerServiceV2 beerServiceV2;

    public BeerControllerV2(BeerServiceV2 beerServiceV2) {
        this.beerServiceV2 = beerServiceV2;
    }

    @GetMapping({"/{beerId}"}) //Path parameter || Path variable
    //I'm being specific in @pathvariable, but it's not necessary 'cause mapping & variable has the same name
    public ResponseEntity<BeerDTOV2> getBeer(@NotNull @PathVariable("beerId") UUID beerId){

        return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping //This create a new beer
    public ResponseEntity handlePost (@Valid @RequestBody BeerDTOV2 beerDTO){ //RequestBody is used to get the object, otherwise I get an empty object

        BeerDTOV2 savedDto = beerServiceV2.saveNewBeer(beerDTO);

        HttpHeaders headers = new HttpHeaders();
        //todo add host to utl on "headerValue" actually is the same as http://localhost:8080/api/v1/beer
        headers.add("Location","/api/v2/beer/"+savedDto.getBeerId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity handleUpdateById (@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDTOV2 beerDTO){

        beerServiceV2.updateBeerById(beerId, beerDTO);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT) //This allows to use HttpStatus for responses of the controller
    public void deleteBeerById (@PathVariable("beerId") UUID beerId){

        beerServiceV2.deleteBeerById(beerId);
    }


}
