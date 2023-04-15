package com.example.shoppinglist_week12.fragments;

import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.shoppinglist_week12.R;
import com.example.shoppinglist_week12.ShoppingItem;
import com.example.shoppinglist_week12.Storage;

import java.util.ArrayList;


public class FragmentImportant extends Fragment {


    public FragmentImportant() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_important, container, false);

        LinearLayout llImportant = view.findViewById(R.id.llImportant);

        ArrayList<ShoppingItem> list = Storage.getInstance().getShoppingItemList();
        for (ShoppingItem item : list){
            if (item.isImportant()){
                llImportant.addView(makeTextView(item));
            }

        }
        return view;
    }

    public TextView makeTextView(ShoppingItem item){
        TextView tw = new TextView(getActivity().getApplicationContext());
        tw.setText(item.getName());
        tw.setTypeface(null, Typeface.BOLD);
        return tw;

    }
}