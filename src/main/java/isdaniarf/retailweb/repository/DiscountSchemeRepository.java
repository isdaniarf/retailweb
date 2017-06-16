package isdaniarf.retailweb.repository;

import isdaniarf.retailweb.model.DiscountScheme;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Isdaniar_F on 16/06/2017.
 */
public interface DiscountSchemeRepository extends CrudRepository<DiscountScheme, Long>{

    DiscountScheme findByCode(String code);

    @Query("SELECT MAX(discount) FROM DiscountScheme WHERE code=:code")
    Double findDiscountByCode(@Param("code") String code);
}
