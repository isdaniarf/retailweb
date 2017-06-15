package isdaniarf.retailweb.services;

import isdaniarf.retailweb.model.Item;
import isdaniarf.retailweb.model.User;
import isdaniarf.retailweb.model.meta.Types;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Isdaniar_F on 14/06/2017.
 */
public class BillingEngine {

    private static final double DISCOUNT_PERCENTAGE_30 = 0.3;
    private static final double DISCOUNT_PERCENTAGE_10 = 0.1;
    private static final double DISCOUNT_PERCENTAGE_5 = 0.05;
    private static final int DISCOUNT_DOLLAR_5 = 5;

    private static double calculateItemPrice(User user, Item item) {
        double finalPrice = item.getPrice();

        if (item.getType() == Types.ItemType.GROCERY) {
            return finalPrice;
        }

        if (user.getType() == Types.UserType.CUSTOMER) {
            if (Period.between(user.getRegisteredDate(), LocalDate.now()).getYears() >= 2) {
                finalPrice -= finalPrice * DISCOUNT_PERCENTAGE_5;
            }
        } else if (user.getType() == Types.UserType.EMPLOYEE) {
            finalPrice -= finalPrice * DISCOUNT_PERCENTAGE_30;
        } else if (user.getType() == Types.UserType.AFFILIATE) {
            finalPrice -= finalPrice * DISCOUNT_PERCENTAGE_10;
        }

        return finalPrice;
    }

    public static double calculateBulkPrice(User user, HashMap<Item, Integer> items) {
        double totalPrice = 0.0;
        double originalPrice = 0.0;

        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            originalPrice += entry.getKey().getPrice() * entry.getValue();
            totalPrice += calculateItemPrice(user, entry.getKey()) * entry.getValue();
        }

        int multiplier = (int) (originalPrice / 100);
        totalPrice -= multiplier * DISCOUNT_DOLLAR_5;

        return totalPrice;
    }

}
