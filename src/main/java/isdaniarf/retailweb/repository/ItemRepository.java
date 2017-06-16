package isdaniarf.retailweb.repository;

import isdaniarf.retailweb.model.Item;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Isdaniar_F on 15/06/2017.
 */
public interface ItemRepository extends CrudRepository<Item, Long> {

    Item findByName(String name);

}
