package hookah.models.repository;

import hookah.models.data.Hookah;
import org.springframework.data.repository.CrudRepository;

public interface HookahRepository extends CrudRepository<Hookah, Long> {
}
