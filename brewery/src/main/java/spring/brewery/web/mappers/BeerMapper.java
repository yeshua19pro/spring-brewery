package spring.brewery.web.mappers;

import org.mapstruct.Mapper;

import spring.brewery.domain.Beer;
import spring.brewery.web.model.BeerDTO;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDTO beerToBeerDTO(Beer beer);

    Beer beerDTOToBeer(BeerDTO beerDTO);

}
