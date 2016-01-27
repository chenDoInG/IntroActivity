package com.chendoing.introactivity.ui.presenter;

import com.chendoing.introactivity.model.User;
import com.chendoing.introactivity.ui.MainActivity;

public class MainActivityPresenter {

    private MainActivity introActivity;
    private User user;

    public MainActivityPresenter(MainActivity introActivity, User user) {
        this.introActivity = introActivity;
        this.user = user;
    }

    public void showUserName(){
//        introActivity.show(user.getDatas().get(0).getUidatas().get(0).getName());
        introActivity.show(user.getUrl());
    }
}
