import isdaniarf.retailweb.entities.Item;
import isdaniarf.retailweb.entities.User;
import isdaniarf.retailweb.entities.meta.Types;
import org.junit.Assert;
import org.junit.Test;
import isdaniarf.retailweb.services.BillingEngine;

import java.util.HashMap;

/**
 * Created by Isdaniar_F on 14/06/2017.
 */
public class BillingTest {


    @Test
    public void getPriceForEmployee() {
        User user = UserFactory.createUser("John", Types.User.EMPLOYEE, 2);
        HashMap<Item, Integer> chart = ItemFactory.createBulkItem("Cabinet", Types.Item.NON_GROCERY, 990, 1);
        double finalPrice = BillingEngine.calculateBulkPrice(user, chart);
        System.out.println(finalPrice);
        Assert.assertTrue(finalPrice == 648); // 990 - 297 - 45
    }

    @Test
    public void getPriceForAfilliate() {
        User user = UserFactory.createUser("Mark", Types.User.AFFILIATE, 1);
        HashMap<Item, Integer> chart = ItemFactory.createBulkItem("Chair", Types.Item.NON_GROCERY, 90, 1);
        double finalPrice = BillingEngine.calculateBulkPrice(user, chart);
        System.out.println(finalPrice);
        Assert.assertTrue(finalPrice == 81); // 90 - 9
    }

    @Test
    public void getPriceForCustomer_MoreThan2Years() {
        User user = UserFactory.createUser("Tony", Types.User.CUSTOMER, 2);
        HashMap<Item, Integer> chart = ItemFactory.createBulkItem("Bed", Types.Item.NON_GROCERY, 990, 1);
        double finalPrice = BillingEngine.calculateBulkPrice(user, chart);
        System.out.println(finalPrice);
        Assert.assertTrue(finalPrice == 895.5); // 990 - 49.5 - 45
    }

    @Test
    public void getPriceForCustomer_LessThan2Years() {
        User user = UserFactory.createUser("John", Types.User.CUSTOMER, 1);
        HashMap<Item, Integer> chart = ItemFactory.createBulkItem("Cabinet", Types.Item.NON_GROCERY, 990, 1);
        double finalPrice = BillingEngine.calculateBulkPrice(user, chart);
        System.out.println(finalPrice);
        Assert.assertTrue(finalPrice == 945); // 990 - 45
    }

    @Test
    public void getPriceForCustomer_MoreThan2Years_Groceries() {
        User user = UserFactory.createUser("Tony", Types.User.CUSTOMER, 2);
        HashMap<Item, Integer> chart = ItemFactory.createBulkItem("Bed", Types.Item.GROCERY, 990, 1);
        double finalPrice = BillingEngine.calculateBulkPrice(user, chart);
        System.out.println(finalPrice);
        Assert.assertTrue(finalPrice == 945); // 990 - 45
    }

    @Test
    public void getPriceForEmployee_MultipleItems() {
        User user = UserFactory.createUser("John", Types.User.EMPLOYEE, 1);
        HashMap<Item, Integer> chart = ItemFactory.createBulkItem("Cabinet", Types.Item.NON_GROCERY, 90, 12);
        double finalPrice = BillingEngine.calculateBulkPrice(user, chart);
        System.out.println(finalPrice);
        Assert.assertTrue(finalPrice == 706); // 1080 - 324 - 50
    }

}
