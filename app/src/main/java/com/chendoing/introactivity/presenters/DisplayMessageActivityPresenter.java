package com.chendoing.introactivity.presenters;

import android.annotation.SuppressLint;

import com.chendoing.introactivity.model.entities.Transform;
import com.chendoing.introactivity.ui.activities.DisplayMessageActivity;

import javax.inject.Inject;

public class DisplayMessageActivityPresenter implements Presenter {

    private DisplayMessageActivity activity;
    private Transform transform;

    private boolean isRequestRunning;


    @Inject
    public DisplayMessageActivityPresenter(DisplayMessageActivity activity,Transform transform) {
        this.transform = transform;
        this.activity = activity;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onPause() {
        activity.hideLoadingMoreIndicator();
        isRequestRunning = false;
    }

    @Override
    public void onCreate() {
        askForDatas();
    }

    public void onListEndReached() {
        if (!isRequestRunning) askForNewDatas();
    }

    private void askForNewDatas() {
        activity.showLoadingMoreIndicator();
        isRequestRunning = true;

        //TODO 服务器获取数据，填充
    }

    private void askForDatas() {
        isRequestRunning = true;
        activity.hideErrorView();
        activity.showLoadingView();
        activity.bindData(transform.getDatas());
        activity.showData();
        activity.hideEmptyIndicator();
        isRequestRunning = false;
    }

    @SuppressLint("ShowToast")
    public void onElementClick(int position) {
       activity.showItemMessage(transform.getDatas().get(0).getUidatas().get(position).getName());
    }

    public void onErrorRetryRequest() {
        if (transform == null)
            askForDatas();
        else
            askForNewDatas();
    }
}
