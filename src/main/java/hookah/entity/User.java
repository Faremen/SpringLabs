package hookah.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

@Entity
@Table(name = "Users")
@Data
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(unique = true)
    @NotBlank(message = "Логин не заполнен")
    private String username;

    @NotBlank(message = "Пароль не заполнен")
    private String password;

    @NotBlank(message = "Имя не заполнен")
    private String name;

    @Column(unique = true)
    @Pattern(regexp = "^(8|7)(\\d{3})?[\\d\\- ]{7,10}$", message = "Номер телефон не соответствует формату: 7/8XXXXXXX")
    private String telephone;

    @Column(unique = true)
    @NotBlank(message = "Электронная почта не заполнена")
    @Email(message = "Это не электронная почта")
    private String email;

    @Enumerated(value = EnumType.STRING)
//    @NotBlank(message = "Роль не заполнена")
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
