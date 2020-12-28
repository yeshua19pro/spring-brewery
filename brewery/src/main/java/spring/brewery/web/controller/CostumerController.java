package spring.brewery.web.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import spring.brewery.services.CostumerService;
import spring.brewery.web.model.CostumerDTO;

import javax.validation.Valid;
import java.util.UUID;

/**
 *This class handle a get mapping to return back a beer id
 */
@Validated
@RestController
@RequestMapping("/api/v1/costumer")
public class CostumerController {
    private final CostumerService costumerService;

    public CostumerController(CostumerService costumerService) {
        this.costumerService = costumerService;
    }

    @GetMapping({"/{costumerId}"}) //Path parameter || Path variable
    //I'm being specific in @pathvariable, but it's not necessary 'cause mapping & variable has the same name
    public ResponseEntity<CostumerDTO> getCostumer(@PathVariable("costumerId") UUID costumerId){

        return new ResponseEntity<>(costumerService.getCostumerById(costumerId), HttpStatus.OK);
    }

    @PostMapping //This create a new Costumer
    public ResponseEntity handlePost (@Valid @RequestBody CostumerDTO costumerDTO){ //RequestBody is used to get the object, otherwise I get an empty object

        CostumerDTO savedDto = costumerService.saveNewCostumer(costumerDTO);

        HttpHeaders headers = new HttpHeaders();
        //todo add host to utl on "headerValue" actually is the same as http://localhost:8080/api/v1/beer
        headers.add("Location","/api/v1/costumer/"+savedDto.getCostumerId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{costumerId}"})
    public ResponseEntity handleUpdateById (@PathVariable("costumerId") UUID costumerId, @Valid @RequestBody CostumerDTO costumerDTO){

        costumerService.updateCostumerById(costumerId, costumerDTO);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{costumerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT) //This allows to use HttpStatus for responses of the controller
    public void deleteCostumerById (@PathVariable("costumerId") UUID costumerId){

        costumerService.deleteCostumerById(costumerId);
    }



}
