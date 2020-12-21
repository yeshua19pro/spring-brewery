package spring.brewery.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import spring.brewery.web.model.CostumerDTO;

import java.util.UUID;

@Slf4j
@Service
public class CostumerServiceImpl implements CostumerService {
    @Override
    public CostumerDTO getCostumerById(UUID costumerId) {
        //We should invoke the builder to make a pseudo constructor with the class's parameters
        return CostumerDTO.builder().costumerId(UUID.randomUUID()).costumerName("Jhon").build();
    }

    @Override
    public CostumerDTO saveNewCostumer(CostumerDTO costumerDTO) {
        return CostumerDTO.builder().costumerId(UUID.randomUUID()).build();
    }

    @Override
    public void updateCostumerById(UUID costumerId, CostumerDTO costumerDTO) {
        //to implement
    }

    @Override
    public void deleteCostumerById(UUID costumerId) {
        log.debug("Deleting a costumer");
    }
}
