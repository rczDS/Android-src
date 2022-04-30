package com.example.tablayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends Fragment {
    private TabLayout my_tablayout;
    private ViewPager my_viewpager;
    public static Fragment myTabFragment;

    public Fragment1(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View viewContent = inflater.inflate(R.layout.fragment1, container, false);
        initViewContent(viewContent);

        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(getFragmentManager());
        List<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(new tabFragment1());
        fragments.add(new tabFragment2());
        String[] titles = {"已关注动态", "全部动态"};
        tabPagerAdapter.setFragments(fragments);
        tabPagerAdapter.setTitles(titles);

        my_viewpager.setAdapter(tabPagerAdapter);
        my_tablayout.setupWithViewPager(my_viewpager);

        my_viewpager.addOnPageChangeListener(new
                TabLayout.TabLayoutOnPageChangeListener(my_tablayout));
        my_tablayout.addOnTabSelectedListener(
                new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        my_viewpager.setCurrentItem(tab.getPosition());
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {
                    }
                });

        return viewContent;
    }

    public void initViewContent(View viewContent) {
        this.my_tablayout = (TabLayout) viewContent.findViewById(R.id.tab_layout);
        this.my_viewpager = (ViewPager) viewContent.findViewById(R.id.tab_viewPager);
    }



}
