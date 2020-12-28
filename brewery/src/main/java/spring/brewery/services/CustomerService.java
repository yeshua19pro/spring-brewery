package spring.brewery.services;

import java.util.UUID;

import spring.brewery.web.model.CustomerDTO;

public interface CustomerService {

    CustomerDTO getCostumerById(UUID costumerId);

    void updateCostumerById(UUID costumerId, CustomerDTO customerDTO);

    CustomerDTO saveNewCostumer(CustomerDTO customerDTO);

    void deleteCostumerById(UUID costumerId);
}
