package com.chendoing.introactivity.presenters;

import com.chendoing.introactivity.model.entities.Transform;
import com.chendoing.introactivity.ui.activities.MainActivity;

public class MainActivityPresenter implements Presenter{

//    private MainActivityPresenterConstraint mainActivity;
    private MainActivity activity;
    private Transform transform;

    public MainActivityPresenter(MainActivity activity,Transform transform) {
        this.transform = transform;
        this.activity = activity;
    }

    public void showUserName(){
//        mainActivity.show(user.getDatas().get(0).getUidatas().get(0).getName());
        activity.show(transform.getUrl());
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onPause() {

    }

//    @Override
//    public void attachView(PresenterConstraint v) {
//        mainActivity = (MainActivityPresenterConstraint)v;
//    }

    @Override
    public void onCreate() {

    }
}
