package com.example.shoppinglist_week12;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShoppingItemInfoAdapter extends RecyclerView.Adapter<ShoppingItemInfoHolder> {

    private ArrayList<ShoppingItem> shoppingItemList= new ArrayList<>();
    private Context context;

    public ShoppingItemInfoAdapter(ArrayList<ShoppingItem> shoppingItemList, Context context) {
        this.shoppingItemList = shoppingItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ShoppingItemInfoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shopping_item_info, parent, false);
        ShoppingItemInfoHolder holder = new ShoppingItemInfoHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingItemInfoHolder holder, int position) {

        holder.name.setText(shoppingItemList.get(holder.getAdapterPosition()).getName());
        holder.note.setText(shoppingItemList.get(holder.getAdapterPosition()).getNote());

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.editName.getVisibility() == View.VISIBLE ) {
                    Storage.getInstance().getShoppingItemList().get(holder.getAdapterPosition()).setName(holder.editName.getText().toString());
                    Storage.getInstance().getShoppingItemList().get(holder.getAdapterPosition()).setNote(holder.editNote.getText().toString());
                    holder.editName.setVisibility(View.GONE);
                    holder.editNote.setVisibility(View.GONE);
                    notifyDataSetChanged();
                } else {
                    holder.editName.setText(holder.name.getText().toString());
                    holder.editNote.setText(holder.note.getText().toString());
                    holder.editName.setTextColor(Color.RED);
                    holder.editNote.setTextColor(Color.RED);
                    holder.editName.setVisibility(View.VISIBLE);
                    holder.editNote.setVisibility(View.VISIBLE);
                }
            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Storage.getInstance().removeShoppingItem(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return shoppingItemList.size();
    }
}
