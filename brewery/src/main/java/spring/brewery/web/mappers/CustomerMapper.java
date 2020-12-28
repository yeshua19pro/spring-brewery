package spring.brewery.web.mappers;

import org.mapstruct.Mapper;

import spring.brewery.domain.Customer;
import spring.brewery.web.model.CustomerDTO;

@Mapper
public interface CustomerMapper {

    CustomerDTO CostumerToCustomerDTO (Customer customer);

    Customer CostumerDTOToCustomer (CustomerDTO customerDTO);
}
