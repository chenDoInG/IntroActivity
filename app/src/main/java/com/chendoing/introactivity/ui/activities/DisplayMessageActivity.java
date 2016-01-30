package com.chendoing.introactivity.ui.activities;

import android.app.ActivityOptions;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chendoing.introactivity.AppApplication;
import com.chendoing.introactivity.R;
import com.chendoing.introactivity.injectors.component.DaggerDisplayActivityComponent;
import com.chendoing.introactivity.injectors.module.DisplayMessageActivityModule;
import com.chendoing.introactivity.injectors.module.TranformModule;
import com.chendoing.introactivity.model.entities.Transform;
import com.chendoing.introactivity.presenters.DisplayMessageActivityPresenter;
import com.chendoing.introactivity.ui.RecyclerClickListener;
import com.chendoing.introactivity.ui.adapter.TransformAdapter;
import com.chendoing.introactivity.ui.views.RecyclerInsetsDecoration;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DisplayMessageActivity extends BaseActivity {

    @Bind(R.id.activity_display_message_recycler)
    RecyclerView recyclerView;
    @Bind(R.id.activity_display_message_empty_indicator)
    View emptyIndicator;
    @Bind(R.id.activity_display_message_error_view)
    View errorView;

    @Inject
    DisplayMessageActivityPresenter presenter;

    private TransformAdapter transformAdapter;
    private Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
        initializeRecyclerView();
        initializeDI();
        initializePresenter();
    }

    private void initUI() {
        setContentView(R.layout.activity_display_message);
        ButterKnife.bind(this);
    }

    private void initializePresenter() {
        presenter.onCreate();
    }

    private void initializeDI() {
        DaggerDisplayActivityComponent.builder()
                .tranformModule(new TranformModule())
                .displayMessageActivityModule(new DisplayMessageActivityModule(this))
                .appComponent(((AppApplication) getApplication()).getAppComponent())
                .build().inject(this);
    }

    private void initializeRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new RecyclerInsetsDecoration(this));
        recyclerView.addOnScrollListener(onScrollListener);
    }

    private RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            int visibleItemCount = linearLayoutManager.getChildCount();
            int totalItemCount = linearLayoutManager.getItemCount();
            int firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            if (visibleItemCount + firstVisibleItemPosition >= totalItemCount)
                presenter.onListEndReached();

        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onStop();
    }

    public void bindData(List<Transform.Data> datas) {
        transformAdapter = new TransformAdapter(datas, this, new RecyclerClickListener() {
            @Override
            public void onElementClick(int position, View sharedView, ImageView imageView) {
                presenter.onElementClick(position);
            }
        });
        recyclerView.setAdapter(transformAdapter);
    }

    public void showItemMessage(String message){
       showUnknownErrorMessage();
    }

    public void showData() {
        if (recyclerView.getVisibility() == View.GONE || recyclerView.getVisibility() == View.INVISIBLE)
            recyclerView.setVisibility(View.VISIBLE);
    }

    public void hideCharactersList() {
        recyclerView.setVisibility(View.GONE);
    }

    public void showLoadingMoreIndicator() {
        snackbar = Snackbar.make(recyclerView, getString(R.string.message_loading_more), Snackbar.LENGTH_INDEFINITE);
        snackbar.show();
    }

    public void hideLoadingMoreIndicator() {
        if (snackbar != null) snackbar.dismiss();
    }

    public void hideLoadingIndicator() {
        snackbar.dismiss();
    }

    public void showLoadingView() {
        emptyIndicator.setVisibility(View.VISIBLE);
    }

    public void hideLoadingView() {
        emptyIndicator.setVisibility(View.GONE);
    }

    public void showLightError() {
        Snackbar.make(recyclerView, getString(R.string.error_loading_data), Snackbar.LENGTH_LONG)
                .setAction(getString(R.string.try_again), new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        presenter.onErrorRetryRequest();
                    }
                }).show();
    }

    public void hideErrorView() {
        errorView.setVisibility(View.GONE);
    }

    public void showEmptyIndicator() {
        emptyIndicator.setVisibility(View.VISIBLE);
    }

    public void hideEmptyIndicator() {
        emptyIndicator.setVisibility(View.GONE);
    }

    public void updateCharacterList(int dataAdded) {
        transformAdapter.notifyItemRangeInserted(transformAdapter.getItemCount() + dataAdded, dataAdded);
    }

    public ActivityOptions getActivityOptions(int position, View clickedView) {
        String sharedViewName = "thumb" + position;
        return ActivityOptions.makeSceneTransitionAnimation(this, clickedView, sharedViewName);
    }

    public void showConnectionErrorMessage() {
        TextView errorTextView = ButterKnife.findById(errorView, R.id.view_error_message);
        errorTextView.setText(R.string.error_network_unknowhost);
        errorView.setVisibility(View.VISIBLE);
    }


    public void showServerErrorMessage() {
        TextView errorTextView = ButterKnife.findById(errorView, R.id.view_error_message);
        errorTextView.setText(R.string.error_network_unknowhost);
        errorView.setVisibility(View.VISIBLE);
    }

    public void showUnknownErrorMessage() {
        TextView errorTextView = ButterKnife.findById(errorView, R.id.view_error_message);
        errorTextView.setText(R.string.error_network_unknowhost);
        errorView.setVisibility(View.VISIBLE);
    }
}
