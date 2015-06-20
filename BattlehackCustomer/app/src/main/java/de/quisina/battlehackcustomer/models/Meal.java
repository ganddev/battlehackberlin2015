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
@Table(name = "meals" , id = BaseColumns._ID)
public class Meal extends Model implements JsonDeserializer<Meal> {

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private float price;

    public Meal() { super(); }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    

    @Override
    public Meal deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Meal meal = new Meal();
        JsonObject object = json.getAsJsonObject();
        if(!object.get("id").isJsonNull()) {
            meal.setId(object.get("id").getAsLong());
        }
        if(!object.get("name").isJsonNull()) {
            meal.setName(object.get("name").getAsString());
        }
        if(!object.get("price").isJsonNull()) {
            meal.setPrice(object.get("price").getAsFloat());
        }
        return meal;
    }
}
