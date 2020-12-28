package spring.brewery.web.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import spring.brewery.services.CustomerService;
import spring.brewery.web.model.CustomerDTO;

/**
 *This class handle a get mapping to return back a beer id
 */
@Validated
@RestController
@RequestMapping("/api/v1/costumer")
public class CostumerController {
    private final CustomerService customerService;

    public CostumerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/{costumerId}"}) //Path parameter || Path variable
    //I'm being specific in @pathvariable, but it's not necessary 'cause mapping & variable has the same name
    public ResponseEntity<CustomerDTO> getCostumer(@PathVariable("costumerId") UUID costumerId){

        return new ResponseEntity<>(customerService.getCostumerById(costumerId), HttpStatus.OK);
    }

    @PostMapping //This create a new Customer
    public ResponseEntity handlePost (@Valid @RequestBody CustomerDTO customerDTO){ //RequestBody is used to get the object, otherwise I get an empty object

        CustomerDTO savedDto = customerService.saveNewCostumer(customerDTO);

        HttpHeaders headers = new HttpHeaders();
        //todo add host to utl on "headerValue" actually is the same as http://localhost:8080/api/v1/beer
        headers.add("Location","/api/v1/costumer/"+savedDto.getCostumerId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{costumerId}"})
    public ResponseEntity handleUpdateById (@PathVariable("costumerId") UUID costumerId, @Valid @RequestBody CustomerDTO customerDTO){

        customerService.updateCostumerById(costumerId, customerDTO);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{costumerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT) //This allows to use HttpStatus for responses of the controller
    public void deleteCostumerById (@PathVariable("costumerId") UUID costumerId){

        customerService.deleteCostumerById(costumerId);
    }



}
