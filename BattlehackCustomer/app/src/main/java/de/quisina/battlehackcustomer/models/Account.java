package de.quisina.battlehackcustomer.models;

import android.provider.BaseColumns;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by bjornahlfeld on 20.06.15.
 */
@Table(name = "account", id = BaseColumns._ID)
public class Account extends Model implements JsonDeserializer<Account> {

    @Column(name = "email")
    private String email;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "auth_token")
    private String authToken;

    @Column(name = "role")
    private String role;

    public Account() {super();}

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    @Override
    public Account deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Account account = new Account();
        JsonObject obj = json.getAsJsonObject();
        if(!obj.get("id").isJsonNull()) {
            account.setId(obj.get("id").getAsLong());
        }
        if(obj.get("token") != null && !obj.get("token").isJsonNull()) {
            account.setAuthToken(obj.get("token").getAsString());
        }
        if(!obj.get("name").isJsonNull()) {
            account.setUserName(obj.get("name").getAsString());
        }
        if(!obj.get("email").isJsonNull()) {
            account.setEmail(obj.get("email").getAsString());
        }

        if(!obj.get("role").isJsonNull()) {
            account.setRole(obj.get("role").getAsString());
        }
        return account;
    }
}
