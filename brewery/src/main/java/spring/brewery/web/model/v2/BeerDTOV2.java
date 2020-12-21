package spring.brewery.web.model.v2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 *
 * @author yashuanarvaezp
 */
@Data //This creates getters and setters and hash code methods for us
@NoArgsConstructor
@AllArgsConstructor
@Builder //Implements the builder pattern for us
public class BeerDTOV2 {

    private UUID beerId;
    private String beerName;
    private BeerStyleEnum beerStyle;
    private Long upc;

}
