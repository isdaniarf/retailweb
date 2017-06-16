package isdaniarf.retailweb.repository;

import isdaniarf.retailweb.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Isdaniar_F on 15/06/2017.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findByName(String name);
}
