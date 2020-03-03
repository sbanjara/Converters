package com.example.converters;

import android.support.v4.app.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabPagerAdapter extends FragmentPagerAdapter
{
    int tabCount;

    public TabPagerAdapter(FragmentManager fm, int numTabs) {
        super(fm);
        this.tabCount = numTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0: return new TipCalculator();
            case 1: return new DistanceConverter();
            case 2: return new TemperatureConverter();
            default: return null;
        }

    }

    @Override
    public int getCount() {
        return tabCount;
    }
}