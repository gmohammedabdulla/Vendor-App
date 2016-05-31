package com.example.abdulla.vendorapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.example.abdulla.vendorapp.R;
import com.example.abdulla.vendorapp.model.Item;

import java.util.List;

/**
 * Created by 8422 on 30/05/16.
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

    String TAG = ItemAdapter.class.getSimpleName();

    private List<Item> itemsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name,price,quatity;
        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            price = (TextView) view.findViewById(R.id.price);
            quatity = (TextView) view.findViewById(R.id.quantity);
        }
    }


    public ItemAdapter(List<Item> itemsList) {
        this.itemsList = itemsList;
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Item item = itemsList.get(position);
        holder.name.setText(item.getName());
        holder.price.setText("Price: \u20B9" + item.getPrice());
        holder.quatity.setText("Qty: "+item.getQuantity());
    }
}
