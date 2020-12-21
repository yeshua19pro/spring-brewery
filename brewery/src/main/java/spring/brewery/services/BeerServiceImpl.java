package spring.brewery.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import spring.brewery.web.model.BeerDTO;

import java.util.UUID;

@Slf4j //This add a logger
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDTO getBeerById(UUID beerId) {

        //We should invoke the builder to make a pseudo constructor with the class's parameters
        return BeerDTO.builder().beerId(UUID.randomUUID()).beerName("Heineken").beerStyle("Drink A Lot").build() ;
    }

    @Override
    public BeerDTO saveNewBeer(BeerDTO beerDTO) {
         return BeerDTO.builder().beerId(UUID.randomUUID()).build();
    }

    @Override
    public void updateBeerById(UUID beerId, BeerDTO beerDTO) {
        //implementation to update the beer by a given id
    }

    @Override
    public void deleteBeerById(UUID beerId) {
        log.debug("Deleting a beer");
    }
}
