package spring.brewery.web.model;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

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

public class CustomerDTO {

    @Null
    private UUID costumerId;

    @NotBlank
    @Size(min = 3, max = 100) //If min and max value are not specified, they have a default values
    private String costumerName;
}
