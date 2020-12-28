package spring.brewery.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import spring.brewery.web.model.CustomerDTO;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getCostumerById(UUID costumerId) {
        //We should invoke the builder to make a pseudo constructor with the class's parameters
        return CustomerDTO.builder().costumerId(UUID.randomUUID()).costumerName("Jhon").build();
    }

    @Override
    public CustomerDTO saveNewCostumer(CustomerDTO customerDTO) {
        return CustomerDTO.builder().costumerId(UUID.randomUUID()).build();
    }

    @Override
    public void updateCostumerById(UUID costumerId, CustomerDTO customerDTO) {
        //to implement
    }

    @Override
    public void deleteCostumerById(UUID costumerId) {
        log.debug("Deleting a costumer");
    }
}
