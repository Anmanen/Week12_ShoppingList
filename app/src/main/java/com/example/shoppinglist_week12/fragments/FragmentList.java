package com.example.shoppinglist_week12.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shoppinglist_week12.R;
import com.example.shoppinglist_week12.ShoppingItemInfoAdapter;
import com.example.shoppinglist_week12.Storage;


public class FragmentList extends Fragment {


    public FragmentList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.rwShoppingItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        recyclerView.setAdapter(new ShoppingItemInfoAdapter(Storage.getInstance().getShoppingItemList(),getActivity().getApplicationContext()));
        return view;
    }

}