package spring.brewery.web.model;

import java.time.OffsetDateTime;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author yashuanarvaezp
 */
@Data //This creates getters and setters and hash code methods for us
@NoArgsConstructor 
@AllArgsConstructor
@Builder //Implements the builder pattern for us

public class BeerDTO {

    @Null // This not allow the client to set beerId
    private UUID beerId;

    @NotBlank
    private String beerName;

    @NotBlank
    private String beerStyle;

    @Positive
    private Long upc;

    private OffsetDateTime createdDate;
    private OffsetDateTime lastUpdatedDate;
}
