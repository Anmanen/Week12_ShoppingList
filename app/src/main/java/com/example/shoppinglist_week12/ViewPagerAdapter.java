package com.example.shoppinglist_week12;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.shoppinglist_week12.fragments.FragmentAdd;
import com.example.shoppinglist_week12.fragments.FragmentList;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 0:
                return new FragmentList();
            case 1:
                return new FragmentAdd();
            default:
                return new FragmentList();
        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
