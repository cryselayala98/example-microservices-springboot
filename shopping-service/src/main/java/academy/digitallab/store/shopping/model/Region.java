package academy.digitallab.store.shopping.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Region {

    private Long id;
    private String name;
}
