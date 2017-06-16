package isdaniarf.retailweb.services;

import isdaniarf.retailweb.model.Item;
import isdaniarf.retailweb.model.User;
import isdaniarf.retailweb.model.meta.Types;
import isdaniarf.retailweb.repository.DiscountSchemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Isdaniar_F on 14/06/2017.
 */

@Service
public class BillingEngine {

    @Autowired
    private DiscountSchemeRepository discountSchemeRepository;

    private static final String USER_CUSTOMER_2_YEARS = "USER_CUSTOMER_2_YEARS";
    private static final String USER_EMPLOYEE = "USER_EMPLOYEE";
    private static final String USER_AFFILIATE = "USER_AFFILIATE";
    private static final String PER_100_DOLLAR = "PER_100_DOLLAR";

    private double calculateItemPrice(User user, Item item) {
        double finalPrice = item.getPrice();

        if (item.getType() == Types.ItemType.GROCERY) {
            return finalPrice;
        }

        if (user.getType() == Types.UserType.CUSTOMER) {
            if (Period.between(user.getRegisteredDate(), LocalDate.now()).getYears() >= 2) {
                finalPrice -= finalPrice * discountSchemeRepository.findDiscountByCode(USER_CUSTOMER_2_YEARS);
            }
        } else if (user.getType() == Types.UserType.EMPLOYEE) {
            finalPrice -= finalPrice * discountSchemeRepository.findDiscountByCode(USER_EMPLOYEE);
        } else if (user.getType() == Types.UserType.AFFILIATE) {
            finalPrice -= finalPrice * discountSchemeRepository.findDiscountByCode(USER_AFFILIATE);
        }

        return finalPrice;
    }

    public Double calculateBulkPrice(User user, HashMap<Item, Integer> items) {
        double totalPrice = 0.0;
        double originalPrice = 0.0;

        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            originalPrice += entry.getKey().getPrice() * entry.getValue();
            totalPrice += calculateItemPrice(user, entry.getKey()) * entry.getValue();
        }

        int multiplier = (int) (originalPrice / 100);
        totalPrice -= multiplier * discountSchemeRepository.findDiscountByCode(PER_100_DOLLAR);

        return totalPrice;
    }

}
