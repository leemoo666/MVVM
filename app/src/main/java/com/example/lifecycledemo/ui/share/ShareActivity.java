package com.example.lifecycledemo.ui.share;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.example.lifecycledemo.R;
import com.example.lifecycledemo.ui.main.MainViewModel;

public class ShareActivity extends FragmentActivity {

    private ViewPager vpMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        vpMain = findViewById(R.id.vpMain);
        ShareAdapter adapter = new ShareAdapter(getSupportFragmentManager());
        vpMain.setAdapter(adapter);
    }

}
