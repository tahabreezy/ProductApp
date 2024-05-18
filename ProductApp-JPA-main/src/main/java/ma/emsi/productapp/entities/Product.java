package ma.emsi.productapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Product {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Id;
    private String Name;
    private double Price;
    private int Quantity;
}
