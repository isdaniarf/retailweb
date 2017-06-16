package isdaniarf.retailweb.controller;

import isdaniarf.retailweb.model.Item;
import isdaniarf.retailweb.model.User;
import isdaniarf.retailweb.repository.ItemRepository;
import isdaniarf.retailweb.repository.UserRepository;
import isdaniarf.retailweb.services.BillingEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * Created by Isdaniar_F on 16/06/2017.
 */

@RestController
@RequestMapping("/api")
public class BillingRestController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    BillingEngine billingEngine;

    public static final String MSG_USER_OR_ITEM_NOT_FOUND = "User or Item not found";

    @GetMapping(value = "/getPrice")
    public String getDiscountedPrice(@RequestParam(value="user") String userName, @RequestParam(value="item") String itemName,
                                     @RequestParam(value="amount", defaultValue="1") String amount) {

        User user = userRepository.findByName(userName);
        Item item = itemRepository.findByName(itemName);

        HashMap<Item, Integer> bulkItem = new HashMap<>();
        bulkItem.put(item, Integer.parseInt(amount));

        if (user != null && item != null) {
            return billingEngine.calculateBulkPrice(user, bulkItem).toString();
        }

        return MSG_USER_OR_ITEM_NOT_FOUND;
    }
}
