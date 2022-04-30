package com.example.tablayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class TabPagerAdapter extends FragmentStatePagerAdapter {
    private String[] titles;
    private List<Fragment> fragments;

    public TabPagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public void addFragment(Fragment fragment){
        this.fragments.add(fragment);
    }

    public void setFragments(List<Fragment> fragments){
        this.fragments = fragments;
    }

    public void setTitles(String[] titles){
        this.titles = titles;
    }

    @Override
    public CharSequence getPageTitle(int position){
        return titles[position];
    }

}
