package com.example.tablayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfPages;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior, int pageNum) {
        super(fm, behavior);
        this.mNumOfPages = pageNum;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Fragment1();
            case 1:
                return new Fragment2();
            case 2:
                return new Fragment3();
            case 3:
                return new Fragment4();
        }
        return new Fragment1();
    }

    @Override
    public int getCount() {
        return mNumOfPages;
    }

}
