package com.example.shoppinglist_week12.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.shoppinglist_week12.MainActivity;
import com.example.shoppinglist_week12.R;
import com.example.shoppinglist_week12.ShoppingItem;
import com.example.shoppinglist_week12.Storage;


public class FragmentAdd extends Fragment {

    EditText name;
    EditText note;
    CheckBox important;
    Button addButton;
    public FragmentAdd() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        name = view.findViewById(R.id.etxtShoppingItemName);
        note =view.findViewById(R.id.etxtNote);
        important = view.findViewById(R.id.cbImportant);
        addButton = view.findViewById(R.id.btnAddItem);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean temp = important.isChecked();
                ShoppingItem sItem = new ShoppingItem(name.getText().toString(), note.getText().toString(), important.isChecked());
                Storage.getInstance().addShoppingItem(sItem);

                name.setText("");
                note.setText("");
                important.setChecked(false);


            }
        });

    }
}