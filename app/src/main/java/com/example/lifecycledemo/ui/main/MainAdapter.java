package com.example.lifecycledemo.ui.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by lixiaoming on 2018/4/28.
 */

public class MainAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> list = new ArrayList<>();

    public MainAdapter(FragmentManager fm) {
        super(fm);
        list.add(new HomeFragment());
        list.add(new ProfileFragment());
    }

    @Override
    public Fragment getItem(int position) {
       return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
