package spring.brewery.services;

import spring.brewery.web.model.BeerDTO;
import spring.brewery.web.model.CostumerDTO;

import java.util.UUID;

public interface CostumerService {

    CostumerDTO getCostumerById(UUID costumerId);

    void updateCostumerById(UUID costumerId, CostumerDTO costumerDTO);

    CostumerDTO saveNewCostumer(CostumerDTO costumerDTO);

    void deleteCostumerById(UUID costumerId);
}
