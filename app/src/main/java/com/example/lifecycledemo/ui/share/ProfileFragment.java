package com.example.lifecycledemo.ui.share;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lifecycledemo.R;
import com.example.lifecycledemo.bean.User;
import com.example.lifecycledemo.ui.main.MainViewModel;

/**
 * Created by lixiaoming on 2018/4/28.
 */

public class ProfileFragment extends Fragment {
    private TextView tvName;
    private TextView tvAge;
    private ShareViewModel userViewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, null);

        tvName = view.findViewById(R.id.tvName);
        tvAge = view.findViewById(R.id.tvAge);

        userViewModel = ViewModelProviders.of(getActivity()).get(ShareViewModel.class);

        userViewModel.getName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String user) {
                tvName.setText(user);
//                updateView(user);
                Log.i("lxm", "Profile onChange");
            }
        });


        view.findViewById(R.id.btClick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userViewModel.setName("于谦");
            }
        });
        return view;
    }

    private void updateView(User user) {
        tvName.setText(user.getName());
        tvAge.setText(user.getAge() + "");
    }

}
