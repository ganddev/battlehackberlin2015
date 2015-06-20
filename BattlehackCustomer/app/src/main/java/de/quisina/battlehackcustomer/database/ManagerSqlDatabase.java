package de.quisina.battlehackcustomer.database;

import com.activeandroid.query.Select;

import de.quisina.battlehackcustomer.models.Account;

/**
 * Created by bjornahlfeld on 20.06.15.
 */
public class ManagerSqlDatabase {
    public static Account getAcount() {
        return new Select().from(Account.class).executeSingle();
    }
}
