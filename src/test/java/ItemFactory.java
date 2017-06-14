import isdaniarf.retailweb.entities.Item;
import isdaniarf.retailweb.entities.meta.Types;

import java.util.HashMap;

/**
 * Created by Isdaniar_F on 14/06/2017.
 */
public class ItemFactory {

    public static Item createItem(String name, Types.Item type, double price) {
        return new Item(name, type, price);
    }

    public static HashMap<Item, Integer> createBulkItem(String name, Types.Item type, double price, Integer amount) {
        HashMap<Item, Integer> itemMap = new HashMap<Item, Integer>();
        itemMap.put(createItem(name, type, price), amount);
        return itemMap;
    }
}
