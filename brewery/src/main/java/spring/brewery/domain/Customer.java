package spring.brewery.domain;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //This creates getters and setters and hash code methods for us
@NoArgsConstructor
@AllArgsConstructor
@Builder //Implements the builder pattern for us
public class Customer {
    private UUID costumerId;
    private String costumerName;
}
