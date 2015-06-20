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
@Table(name = "restaurants", id = BaseColumns._ID)
public class Restaurant extends Model implements JsonDeserializer<Restaurant>{


    @Column(name = "name")
    private String name;

    public Restaurant() {super();}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Restaurant deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Restaurant restaurant = new Restaurant();
        JsonObject object = json.getAsJsonObject();
        if(!object.get("id").isJsonNull()) {
            restaurant.setId(object.get("id").getAsLong());
        }
        if(!object.get("name").isJsonNull()) {
            restaurant.setName(object.get("name").getAsString());
        }
        return restaurant;
    }
}
