package hookah.models.data;

import jakarta.persistence.*;
import lombok.Data;

import jakarta.validation.constraints.*;

@Entity
@Table(name = "Hookah_Order")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Min(value = 1, message = "Номер столика должен быть от 1 до 10")
    @Max(value = 10, message = "Номер столика должен быть от 1 до 10")
    private int selectedTable;

    @ManyToOne(targetEntity = Hookah.class)
    private Hookah hookah;

    @Pattern(regexp = "^(8|7)(\\d{3})?[\\d\\- ]{7,10}$", message = "Номер телефон не соответсует формату: 7/8XXXXXXX")
    private String telephone;
}
