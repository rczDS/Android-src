package com.example.tablayout;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentStatePagerAdapter;
//import androidx.fragment.app.FragmentTransaction;
////import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
//import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.google.android.material.bottomnavigation.BottomNavigationView;
//import com.google.android.material.navigation.NavigationBarView;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = AppCompatActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setSelectedItemId(R.id.item1);

        final ViewPager viewPager = findViewById(R.id.viewPager);
        final PagerAdapter pagerAdapter = new PagerAdapter
                (getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, 4);
        viewPager.setAdapter(pagerAdapter);


        viewPager.addOnPageChangeListener(
                new ViewPager.OnPageChangeListener(){
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {
                        switch (position){
                            case 0:
                                bottomNavigationView.setSelectedItemId(R.id.item1);
                                break;
                            case 1:
                                bottomNavigationView.setSelectedItemId(R.id.item2);
                                break;
                            case 2:
                                bottomNavigationView.setSelectedItemId(R.id.item3);
                                break;
                            case 3:
                                bottomNavigationView.setSelectedItemId(R.id.item4);
                                break;
                        }
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                }
        );

        bottomNavigationView.setOnItemSelectedListener(
                (BottomNavigationView.OnNavigationItemSelectedListener) item -> {
                    switch (item.getItemId()) {
                        case R.id.item1:
                            viewPager.setCurrentItem(0);
                            return true;
                        case R.id.item2:
                            viewPager.setCurrentItem(1);
                            return true;
                        case R.id.item3:
                            viewPager.setCurrentItem(2);
                            return true;
                        case R.id.item4:
                            viewPager.setCurrentItem(3);
                            return true;
                    }
                    return false;
                }
        );

//        Intent addtrendIntent = getIntent();
//        try {
//            String title = addtrendIntent.getStringExtra("title");
//            String content = addtrendIntent.getStringExtra("content");
//            if (title != null && content != null){
//                Log.d(LOG_TAG, "get message. " + title + content);
//                Bundle bundle = new Bundle();
//                bundle.putString("title", title);
//                bundle.putString("content", content);
//
//                tabFragment1 my_tabFragment1 = new tabFragment1();
//                my_tabFragment1.setArguments(bundle);
//            }
//        }
//        catch (Exception e) {
//            Log.d(LOG_TAG, "Something went wrong.");
//        }

    }

//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem){
//        int itemId = menuItem.getItemId();
//        if(itemId == R.id.item1) {
//            replaceFragment(new Fragment1());
//            menuItem.setChecked(true);
//        } else if(itemId == R.id.item2){
//                replaceFragment(new Fragment2());
//                menuItem.setChecked(true);
//        } else if(itemId == R.id.item3){
//                replaceFragment(new Fragment3());
//                menuItem.setChecked(true);
//        } else if(itemId == R.id.item4) {
//            replaceFragment(new Fragment4());
//            menuItem.setChecked(true);
//        }
//        return false;
//    }
//
//
//    public void replaceFragment(Fragment fragment) {
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.host_fragment, fragment);
//        fragmentTransaction.commit();
//    }

}
