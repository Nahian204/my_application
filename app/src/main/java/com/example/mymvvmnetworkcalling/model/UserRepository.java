package com.example.mymvvmnetworkcalling.model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UserRepository {

    String url ="https://api.github.com/users";
    Application application;
    User[] users; // User class initialize //
    MutableLiveData<User[]> mutableLiveData;

    public UserRepository(Application application) {
        this.application = application;
    }

    // bring API data from GITHUB using volley//
    public MutableLiveData<User[]> getuserData(){
        if(mutableLiveData==null){
            mutableLiveData=new MutableLiveData<>();
        }
        RequestQueue queue = Volley.newRequestQueue(application);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    // data comes on this function than we convert into gson data
                    //than put all the data inside of the user class//
                    public void onResponse(String response) {
                        // now initialize the gsonBuilder class here //
                        GsonBuilder gsonBuilder= new GsonBuilder();
                        Gson gson= gsonBuilder.create();
                        users=gson.fromJson(response,User[].class);
                        mutableLiveData.setValue(users);


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


// Add the request to the RequestQueue.
        queue.add(stringRequest);
        return mutableLiveData;
    }
}
