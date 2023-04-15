package com.example.shoppinglist_week12;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ShoppingItemInfoHolder extends RecyclerView.ViewHolder {

    TextView name,note;

    ImageView delete, edit;

    EditText editName, editNote;

    CheckBox important;

    public ShoppingItemInfoHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.txtItemName);
        note = itemView.findViewById(R.id.txtNote);

        delete = itemView.findViewById((R.id.imgDelete));
        edit = itemView.findViewById(R.id.imgEdit);

        editName = itemView.findViewById(R.id.etxtEditName);
        editNote = itemView.findViewById(R.id.etxtEditNote);

    }
}
