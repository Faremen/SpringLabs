package hookah.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Table(name = "Users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Логин не заполнен")
    private String login;

    @NotBlank(message = "Пароль не заполнен")
    private String password;

    @NotBlank(message = "Имя не заполнен")
    private String name;

    @Pattern(regexp = "^(8|7)(\\d{3})?[\\d\\- ]{7,10}$", message = "Номер телефон не соответствует формату: 7/8XXXXXXX")
    private String telephone;

    @NotBlank(message = "Электронная почта не заполнена")
    @Email(message = "Это не электронная почта")
    private String email;

    @Enumerated(value = EnumType.STRING)
    @NotBlank(message = "Роль не заполнена")
    private Role Role;
}
