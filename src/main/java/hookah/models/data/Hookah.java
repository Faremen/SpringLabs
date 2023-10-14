package hookah.models.data;

import hookah.models.enums.Filler;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import hookah.models.enums.Tobacco;

@Data
public class Hookah {
    private long id;

    @NotNull
    private Tobacco tobacco;

    @NotNull
    private Filler filler;
}
