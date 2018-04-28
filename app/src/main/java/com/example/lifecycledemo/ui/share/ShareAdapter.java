package com.example.lifecycledemo.ui.share;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by lixiaoming on 2018/4/28.
 */

public class ShareAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> list = new ArrayList<>();

    public ShareAdapter(FragmentManager fm) {
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
