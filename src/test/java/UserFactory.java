import isdaniarf.retailweb.entities.User;
import isdaniarf.retailweb.entities.meta.Types;

import java.time.LocalDate;

/**
 * Created by Isdaniar_F on 14/06/2017.
 */
public class UserFactory {

    public static User createUser(String name, Types.UserType type, int registeredYears) {
        LocalDate registeredDate = LocalDate.now().minusYears(registeredYears);
        return new User(name, type, registeredDate);
    }
}
