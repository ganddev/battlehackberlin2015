package de.quisina.battlehackcustomer.models;

import android.provider.BaseColumns;
import android.util.Log;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by bjornahlfeld on 20.06.15.
 */
@Table(name = "orders" , id = BaseColumns._ID)
public class Order extends Model implements JsonDeserializer<Order> {


    private static final String TAG = Order.class.getSimpleName() ;

    @Column(name = "transaction_id")
    private long transactionId;

    @Column(name ="status")
    private String status;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "meal_name")
    private String name;

    @Column(name = "customer_name")
    private String customerName;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public Order() { super(); }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public Order deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Order order = new Order();
        JsonObject object = json.getAsJsonObject();
        if(!object.get("id").isJsonNull()) {
            order.setId(object.get("id").getAsLong());
        }

        if(!object.get("transaction_id").isJsonNull()) {
            order.setTransactionId(object.get("transaction_id").getAsLong());
        }
        if(!object.get("created_at").isJsonNull()) {
            SimpleDateFormat sdf = new SimpleDateFormat("");
            try {
                order.setCreatedAt(sdf.parse(object.get("created_at").getAsString()));
            }catch (ParseException e) {
                Log.e(TAG, e.getMessage());
            }
        }
        if(!object.get("name").isJsonNull()) {
            order.setName(object.get("name").getAsString());
        }
        if(!object.get("account").isJsonNull()) {
            JsonObject account = object.get("account").getAsJsonObject();
            if(!account.get("name").isJsonNull()) {
                order.setCustomerName(account.get("name").getAsString());
            }
        }

        return order;
    }
}
