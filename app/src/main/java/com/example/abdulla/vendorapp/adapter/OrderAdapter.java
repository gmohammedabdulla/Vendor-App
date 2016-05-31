package com.example.abdulla.vendorapp.adapter;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.abdulla.vendorapp.R;
import com.example.abdulla.vendorapp.helper.CustomLinearLayoutManager;
import com.example.abdulla.vendorapp.helper.DividerItemDecoration;
import com.example.abdulla.vendorapp.model.Item;
import com.example.abdulla.vendorapp.model.Order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 8422 on 30/05/16.
 */
public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder> {

    private List<Order> orderList;
    private ItemAdapter mAdapter;

    String TAG = OrderAdapter.class.getSimpleName();


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView orderId,user_name,total;
        public Context context;
        private RecyclerView recyclerView;
        private Button confirm,ready,out_for_delivery,completed;
        public MyViewHolder(View view) {
            super(view);
            orderId = (TextView) view.findViewById(R.id.order_id);
            user_name = (TextView) view.findViewById(R.id.user_name);
            total = (TextView) view.findViewById(R.id.total);
            recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_items);
            confirm = (Button) view.findViewById(R.id.confirm);
            ready = (Button) view.findViewById(R.id.ready);
            out_for_delivery = (Button) view.findViewById(R.id.out);
            completed = (Button) view.findViewById(R.id.completed);
        }
    }


    public OrderAdapter(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.orders_card_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Order order = orderList.get(position);
        holder.orderId.setText("Order ID: "+order.getOrderId());
        holder.user_name.setText("Name: "+order.getUserName());
        holder.total.setText("Total: "+ order.getTotal());

        //Creating the recycler View
        holder.recyclerView.addItemDecoration(new DividerItemDecoration(order.getContext(), LinearLayoutManager.VERTICAL));

        mAdapter = new ItemAdapter(order.getItem());
        RecyclerView.LayoutManager mLayoutManager = new CustomLinearLayoutManager(order.getContext());
        holder.recyclerView.setLayoutManager(mLayoutManager);
        holder.recyclerView.setItemAnimator(new DefaultItemAnimator());
        holder.recyclerView.setAdapter(mAdapter);

        holder.ready.setEnabled(false);
        holder.out_for_delivery.setEnabled(false);
        holder.completed.setEnabled(false);

        holder.confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(0xff00ff00);
                v.setEnabled(false);
                holder.ready.setEnabled(true);
            }
        });

        holder.ready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(0xff00ff00);
                v.setEnabled(false);
                holder.out_for_delivery.setEnabled(true);
            }
        });

        holder.out_for_delivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(0xff00ff00);
                v.setEnabled(false);
                holder.completed.setEnabled(true);
            }
        });

        holder.completed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(0xff00ff00);
                v.setEnabled(false);
            }
        });
    }
}
