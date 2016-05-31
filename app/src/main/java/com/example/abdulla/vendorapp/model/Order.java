package com.example.abdulla.vendorapp.model;

import android.content.Context;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by 8422 on 31/05/16.
 */
public class Order implements Serializable {
    String orderId,UserName,Total;
    ArrayList<Item> item;
    Context context;

    public Order(String orderId, String userName, String total, ArrayList<Item> item, Context context) {
        this.orderId = orderId;
        UserName = userName;
        Total = total;
        this.item = item;
        this.context = context;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }

    public ArrayList<Item> getItem() {
        return item;
    }

    public void setItem(ArrayList<Item> item) {
        this.item = item;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}

