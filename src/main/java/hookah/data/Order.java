package hookah.data;

import lombok.Data;
import hookah.enums.Hookah;

import javax.validation.constraints.*;

@Data
public class Order {

    @NotNull()
    private long id;

    @NotBlank()
    @Min(value = 1, message = "Номер столика должен быть от 1 до 10")
    @Max(value = 10, message = "Номер столика должен быть от 1 до 10")
    private int selectedTable;

    @NotBlank(message = "Кальян не заполнен")
    private Hookah hookah;

    @NotBlank(message = "Номер телефона не заполнен")
    @Pattern(regexp = "^(8|7)(\\d{3})?[\\d\\- ]{7,10}$", message = "Номер телефон не соответсует формату: 7/8XXXXXXX")
    private String telephone;
}
