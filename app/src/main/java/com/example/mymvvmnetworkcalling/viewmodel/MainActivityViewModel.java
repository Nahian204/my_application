package com.example.mymvvmnetworkcalling.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mymvvmnetworkcalling.model.User;
import com.example.mymvvmnetworkcalling.model.UserRepository;

public class MainActivityViewModel extends AndroidViewModel {
    UserRepository userRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        userRepository= new UserRepository(application);
    }
    public LiveData<User[]> getallUserData(){
        return userRepository.getuserData();
    }
}
