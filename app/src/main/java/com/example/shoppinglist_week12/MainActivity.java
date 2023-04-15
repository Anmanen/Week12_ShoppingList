package com.example.shoppinglist_week12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.shoppinglist_week12.fragments.FragmentImportant;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabArea = findViewById(R.id.tabArea);
        ViewPager2 viewArea = findViewById(R.id.viewArea);
        ViewPagerAdapter viewAdapter = new ViewPagerAdapter(this);
        viewArea.setAdapter(viewAdapter);
        FrameLayout important = findViewById(R.id.flMain);

        tabArea.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewArea.setAdapter(viewAdapter);
                viewArea.setCurrentItem(tab.getPosition());
                getSupportFragmentManager().beginTransaction().replace(R.id.flMain, new FragmentImportant()).commit();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewArea.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabArea.getTabAt(position).select();
            }
        });




    }


}