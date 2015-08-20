package com.jrdev9.sample.retrofit.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jrdev9.sample.retrofit.R;
import com.jrdev9.sample.retrofit.model.User;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UsersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<User> users;

    public UsersAdapter(List<User> users) {
        this.users = users;
    }

    public UsersAdapter(User user) {
        List<User> users = new ArrayList<>(1);
        users.add(user);
        this.users = users;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        UserHolder userHolder = (UserHolder) holder;
        userHolder.bindUser(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_user, parent, false);
        return new UserHolder(view);
    }

    public void showUsers(List<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    public void showUser(User user) {
        List<User> users = new ArrayList<>(1);
        users.add(user);
        this.users = users;
    }

    public class UserHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.id_text)
        TextView idText;
        @Bind(R.id.nick_text)
        TextView nickText;
        @Bind(R.id.name_text)
        TextView nameText;
        @Bind(R.id.following_number_text)
        TextView followingNumberText;
        @Bind(R.id.followers_number_text)
        TextView followersNumberText;

        public UserHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindUser(User user) {
            idText.setText("Id: " + user.getId());
            nickText.setText("Nick: " + user.getNick());

            if (TextUtils.isEmpty(user.getName())) {
                nameText.setVisibility(View.GONE);
            } else {
                nameText.setText("Full name: " + user.getName());
            }

            if (user.getFollowers() > 0) {
                followersNumberText.setText("Followers: " + String.valueOf(user.getFollowers()));
            } else {
                followersNumberText.setVisibility(View.GONE);
            }

            if (user.getFollowing() > 0) {
                followingNumberText.setText("Following: " + String.valueOf(user.getFollowing()));
            } else {
                followingNumberText.setVisibility(View.GONE);
            }

        }
    }
}
