package com.example.mymvvmnetworkcalling.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mymvvmnetworkcalling.R;
import com.example.mymvvmnetworkcalling.model.User;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    User[] users;

    public UserAdapter(User[] users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater= LayoutInflater.from(viewGroup.getContext());
        View view= layoutInflater.inflate(R.layout.user_list,viewGroup,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, int i) {
        userViewHolder.name.setText(users[i].getLogin());
        userViewHolder.id.setText(String.valueOf(users[i].getId()));
        userViewHolder.reposUrl.setText(users[i].getReposUrl());
        Glide.with(userViewHolder.avatarImg.getContext()).load(users[i].getAvatarUrl()).into(userViewHolder.avatarImg);


    }

    @Override
    public int getItemCount() {
        return users.length;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        ImageView avatarImg;
        TextView name,id,reposUrl;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            avatarImg=itemView.findViewById(R.id.ivAvatarUrl);
            name=itemView.findViewById(R.id.tvName);
            id=itemView.findViewById(R.id.tvID);
            reposUrl=itemView.findViewById(R.id.tvReposUrl);

        }
    }
}
