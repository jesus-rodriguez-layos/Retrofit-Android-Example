package com.jrdev9.sample.retrofit.main;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

import com.jrdev9.sample.retrofit.R;
import com.jrdev9.sample.retrofit.adapter.UsersAdapter;

import java.lang.ref.WeakReference;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainView {

    @Bind(R.id.user_edit_text)
    EditText userEditText;
    @Bind(R.id.info_button)
    Button showInfoButton;
    @Bind(R.id.followers_button)
    Button showFollowersButton;
    @Bind(R.id.followings_button)
    Button showFollowingsButton;
    @Bind(R.id.users_list)
    RecyclerView usersRecyclerList;

    private OnMainViewActions onMainViewActions;

    public MainView(WeakReference<MainActivity> mainActivityWeakReference, OnMainViewActions onMainViewActions) {
        ButterKnife.bind(this, mainActivityWeakReference.get());
        this.onMainViewActions = onMainViewActions;
    }

    @OnClick(R.id.info_button)
    public void showInfo() {
        onMainViewActions.onShowInfo(userEditText.getText().toString());
    }

    @OnClick(R.id.followers_button)
    public void showFollowers() {
        onMainViewActions.onShowFollowers(userEditText.getText().toString());
    }

    @OnClick(R.id.followings_button)
    public void showFollowings() {
        onMainViewActions.onShowFollowings(userEditText.getText().toString());
    }

    public void showErrorOnEditText() {
        userEditText.setError("Empty field");
    }

    public void showUsers(UsersAdapter usersAdapter) {
        usersRecyclerList.setLayoutManager(new LinearLayoutManager(usersRecyclerList.getContext()));
        usersRecyclerList.setAdapter(usersAdapter);
    }

    public interface OnMainViewActions {
        void onShowInfo(String nick);

        void onShowFollowers(String nick);

        void onShowFollowings(String nick);
    }
}
