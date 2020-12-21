package spring.brewery.web.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.brewery.services.BeerService;
import spring.brewery.web.model.BeerDTO;

import java.util.UUID;

/**
 *This class handle a get mapping to return back a beer id
 */
@Deprecated
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"}) //Path parameter || Path variable
    //I'm being specific in @pathvariable, but it's not necessary 'cause mapping & variable has the same name
    public ResponseEntity<BeerDTO> getBeer(@PathVariable("beerId") UUID beerId){

        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping //This create a new beer
    public ResponseEntity handlePost (@RequestBody BeerDTO beerDTO){ //RequestBody is used to get the object, otherwise I get an empty object

        BeerDTO savedDto = beerService.saveNewBeer(beerDTO);

        HttpHeaders headers = new HttpHeaders();
        //todo add host to utl on "headerValue" actually is the same as http://localhost:8080/api/v1/beer
        headers.add("Location","/api/v1/beer/"+savedDto.getBeerId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity handleUpdateById (@PathVariable("beerId") UUID beerId, @RequestBody BeerDTO beerDTO){

        beerService.updateBeerById(beerId, beerDTO);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT) //This allows to use HttpStatus for responses of the controller
    public void deleteBeerById (@PathVariable("beerId") UUID beerId){

        beerService.deleteBeerById(beerId);
    }
}
