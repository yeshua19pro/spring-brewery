package spring.brewery.services;

import spring.brewery.web.model.BeerDTO;

import java.util.UUID;

public interface BeerService {
    BeerDTO getBeerById(UUID beerId);

    BeerDTO saveNewBeer(BeerDTO beerDTO);

    void updateBeerById(UUID beerId, BeerDTO beerDTO);

    void deleteBeerById(UUID beerId);
}
