package com.example.lifecycledemo.ui.main;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.lifecycledemo.R;
import com.example.lifecycledemo.base.BaseActivity;
import com.example.lifecycledemo.bean.User;

public class MainActivity extends BaseActivity<MainViewModel> {
    private MainViewModel userViewModel;

    private TextView tvName;
    private TextView tvAge;
    private ViewPager vpMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.tvName);
        tvAge = findViewById(R.id.tvAge);
        vpMain = findViewById(R.id.vpMain);
        MainAdapter adapter = new MainAdapter(getSupportFragmentManager());
        vpMain.setAdapter(adapter);

        findViewById(R.id.btClick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        Log.i("lxm","run after 3000");
//                        userViewModel.setUsername("大明");
//                    }
//                }, 3000);
                userViewModel.request();
            }
        });

//        getLifecycle().addObserver();

        initData();
    }

    @Override
    public MainViewModel createViewModel() {
        userViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        return userViewModel;
    }

    private void initData() {

        userViewModel.getUserLiveData().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                updateView(user);
                Log.i("lxm", "onChange");
            }
        });

        userViewModel.setUsername("初始化名字");
        userViewModel.setUserAge(16);
    }

    private void updateView(User user) {
        tvName.setText(user.getName());
        tvAge.setText(user.getAge() + "");
    }

}
