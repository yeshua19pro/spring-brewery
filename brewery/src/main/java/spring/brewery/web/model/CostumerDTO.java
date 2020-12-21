package spring.brewery.web.model;

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

public class CostumerDTO {

    private UUID costumerId;
    private String costumerName;
}
