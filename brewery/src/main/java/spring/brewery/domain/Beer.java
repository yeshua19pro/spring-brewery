package spring.brewery.domain;

import java.sql.Timestamp;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.brewery.web.model.v2.BeerStyleEnum;

@Data //This creates getters and setters and hash code methods for us
@NoArgsConstructor
@AllArgsConstructor
@Builder //Implements the builder pattern for us
public class Beer {
    private UUID beerId;
    private String beerName;
    private BeerStyleEnum beerStyle;
    private Long upc;

    private Timestamp createdDate;
    private Timestamp lastUpdatedDate;
}
