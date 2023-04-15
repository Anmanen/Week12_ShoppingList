package com.example.shoppinglist_week12;

import android.os.Build;

import java.time.LocalDateTime;

public class ShoppingItem {

    private String name;
    private String note;

    private boolean isImportant;

    private LocalDateTime addingTime;

    private int id;

    private static int idCounter;

    public ShoppingItem(String name, String note, boolean isImportant) {
        this.name = name;
        this.note = note;
        this.isImportant = isImportant;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            this.addingTime = LocalDateTime.now();
        }
        this.id = idCounter;
        idCounter++;
    }

    public String getName() {
        return name;
    }

    public String getNote() {
        return note;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getAddingTime() {
        return addingTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isImportant() {
        return isImportant;
    }

    public void setImportant(boolean important) {
        isImportant = important;
    }
}
