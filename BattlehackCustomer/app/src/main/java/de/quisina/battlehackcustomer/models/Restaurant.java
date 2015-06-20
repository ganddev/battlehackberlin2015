package de.quisina.battlehackcustomer.models;

import android.provider.BaseColumns;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by bjornahlfeld on 20.06.15.
 */
@Table(name = "restaurants", id = BaseColumns._ID)
public class Restaurant extends Model {


    @Column(name = "name")
    private String name;

    public Restaurant() {super();}


}
