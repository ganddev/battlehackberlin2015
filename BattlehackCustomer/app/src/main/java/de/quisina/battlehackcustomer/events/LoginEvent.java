package de.quisina.battlehackcustomer.events;

/**
 * Created by bjornahlfeld on 20.06.15.
 */
public class LoginEvent {

    private boolean succeed;

    public boolean isSucceed() {
        return succeed;
    }

    public void setSucceed(boolean succeed) {
        this.succeed = succeed;
    }

    public LoginEvent(boolean b) {
        succeed = b;

    }
}
