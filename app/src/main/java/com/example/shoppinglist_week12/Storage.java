package com.example.shoppinglist_week12;

import android.os.Build;

import java.util.ArrayList;

public class Storage {

    private ArrayList<ShoppingItem> shoppingItemList= new ArrayList<>();

    private static Storage storage;

    private Storage(){

    }

    public static Storage getInstance(){
        if (storage == null){
            storage = new Storage();
        }
        return storage;
    }

    public ArrayList<ShoppingItem> getShoppingItemList() {
        return shoppingItemList;
    }

    public void addShoppingItem(ShoppingItem sItem){
        shoppingItemList.add(sItem);
    }

    public void removeShoppingItem(int index){
        shoppingItemList.remove(index);
    }

    public void sortAlphabetOrder(){
        shoppingItemList.sort((item1, item2) -> item1.getName().compareTo(item2.getName()));
    }

    public void sortTimeOrder(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            shoppingItemList.sort((item1, item2) -> item1.getAddingTime().compareTo(item2.getAddingTime()));
        }
    }

}
