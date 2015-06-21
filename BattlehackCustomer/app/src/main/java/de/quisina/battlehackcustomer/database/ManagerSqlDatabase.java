package de.quisina.battlehackcustomer.database;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Select;

import java.util.List;

import de.quisina.battlehackcustomer.models.Account;
import de.quisina.battlehackcustomer.models.Order;
import de.quisina.battlehackcustomer.models.Restaurant;

/**
 * Created by bjornahlfeld on 20.06.15.
 */
public class ManagerSqlDatabase {

    public static Account getAcount() {
        return new Select().from(Account.class).where("auth_token IS NOT NULL").executeSingle();
    }

    public static void saveOrders(List<Order> orders) {
        ActiveAndroid.beginTransaction();
        try {
            for (Order order : orders) {
                order.save();
            }
            ActiveAndroid.setTransactionSuccessful();
        } finally {
            ActiveAndroid.endTransaction();
        }
    }

    public static Account getAccountById(long id) {
        return new Select().from(Account.class).where("_id = ?", id).executeSingle();
    }

    public static Meal getMealById(long id) {
        return new Select().from(Meal.class).where("_id = ?", id).executeSingle();
    }

    public static List<Order> getOpenOrders() {
        return new Select().from(Order.class).execute();
    }


    public static void saveMeals(List<Meal> meals) {
        ActiveAndroid.beginTransaction();
        try {
            for (Meal meal : meals) {
                meal.save();
            }
            ActiveAndroid.setTransactionSuccessful();
        } finally {
            ActiveAndroid.endTransaction();
        }
    }

    public static void saveAccounts(List<Account> customers) {
        ActiveAndroid.beginTransaction();
        try{
            for (Account account : customers) {
                account.save();
            }
            ActiveAndroid.setTransactionSuccessful();
        } finally {
            ActiveAndroid.endTransaction();
        }
    }

    public static Order getOrderById(long id) {
        return new Select().from(Order.class).where("_id = ?" , id).executeSingle();
    }

    public static void saveRestaurants(List<Restaurant> restaurants) {
        ActiveAndroid.beginTransaction();
        try{
            for(Restaurant restaurant : restaurants) {
                restaurant.save();
            }
            ActiveAndroid.setTransactionSuccessful();
        } finally {
            ActiveAndroid.endTransaction();
        }
    }

    public static List<Restaurant> getRestaurants() {
        return new Select().from(Restaurant.class).execute();
    }
}
