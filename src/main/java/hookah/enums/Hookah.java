package hookah.enums;

import lombok.Data;
import hookah.data.Tobacco;

@Data
public class Hookah {
    private long id;
    private Tobacco tobacco;
    private Filler filler;
}
