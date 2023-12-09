package hookah.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Hookah {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(targetEntity = Tobacco.class)
    @NotNull(message = "Табак не заполнен")
    private Tobacco tobacco;

    @ManyToOne(targetEntity = Filler.class)
    @NotNull(message = "Фильтр не заполнен")
    private Filler filler;
}
