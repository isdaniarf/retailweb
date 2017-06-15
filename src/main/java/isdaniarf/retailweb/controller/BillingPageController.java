package isdaniarf.retailweb.controller;

import isdaniarf.retailweb.model.Item;
import isdaniarf.retailweb.model.User;
import isdaniarf.retailweb.repository.ItemRepository;
import isdaniarf.retailweb.repository.UserRepository;
import isdaniarf.retailweb.services.BillingEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Isdaniar_F on 15/06/2017.
 */

@Controller
public class BillingPageController {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        List<User> users = (List) userRepository.findAll();
        List<Item> items = (List) itemRepository.findAll();

        model.put("users", users);
        model.put("items", items);
        return "billingPage";
    }

    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public String handleSubmit(Map<String, Object> model, @RequestParam("selectedUser") String selectedUser,
                               @RequestParam("selectedItem") String selectedItem, @RequestParam("amount") String amount) {
        List<User> users = (List) userRepository.findAll();
        List<Item> items = (List) itemRepository.findAll();

        User user = users.get(Integer.parseInt(selectedUser) - 1);
        Item item = items.get(Integer.parseInt(selectedItem) - 1);

        HashMap<Item, Integer> bulkItem = new HashMap<Item, Integer>();
        bulkItem.put(item, Integer.parseInt(amount));

        double finalPrice = BillingEngine.calculateBulkPrice(user, bulkItem);

        model.put("users", users);
        model.put("items", items);
        model.put("user", user);
        model.put("item", item);
        model.put("amount", amount);
        model.put("finalPrice", finalPrice);
        return "billingPage";
    }

}
