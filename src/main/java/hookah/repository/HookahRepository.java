package hookah.repository;

import hookah.entity.Hookah;
import org.springframework.data.repository.CrudRepository;

public interface HookahRepository extends CrudRepository<Hookah, Long> {
}
