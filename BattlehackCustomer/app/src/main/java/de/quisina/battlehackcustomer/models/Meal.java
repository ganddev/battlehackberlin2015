package de.quisina.battlehackcustomer.models;

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
@Table(name = "meals")
public class Meal extends Model implements JsonDeserializer<Meal> {

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private float price;

    public Meal() { super(); }


    @Override
    public Meal deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Meal meal = new Meal();
        JsonObject object = json.getAsJsonObject();


        return meal;
    }
}
