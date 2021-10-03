package academy.digitallab.store.product.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="tbl_categories")
@Getter
@Setter //getter and setter ->  @Data
@Data //genera implements de hashcode, toString y equals
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;//si el nombre del atributo en la bd es igual al nombre del atributo de la clase, no drtá necesario agregar la anotacion de @columna() con el nombre de la columna identificable

}
