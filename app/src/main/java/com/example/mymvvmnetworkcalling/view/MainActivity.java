package com.example.mymvvmnetworkcalling.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mymvvmnetworkcalling.R;
import com.example.mymvvmnetworkcalling.adapter.UserAdapter;
import com.example.mymvvmnetworkcalling.model.User;
import com.example.mymvvmnetworkcalling.viewmodel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {
    MainActivityViewModel mainActivityViewModel;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityViewModel= ViewModelProviders.of(this).get(MainActivityViewModel.class);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainActivityViewModel.getallUserData().observe(this, new Observer<User[]>() {
            @Override
            // all mutable live data come here from UserRepository class via MainActivityView class//
            public void onChanged(User[] users) {
                recyclerView.setAdapter(new UserAdapter(users));


            }
        });
    }
}