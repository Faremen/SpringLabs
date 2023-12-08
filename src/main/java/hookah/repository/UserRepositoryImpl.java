package hookah.repository;

import hookah.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositoryImpl extends CrudRepository<User, Long> {
}
