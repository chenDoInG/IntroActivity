package com.chendoing.introactivity.ui.activities;

import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.chendoing.introactivity.AppApplication;
import com.chendoing.introactivity.R;
import com.chendoing.introactivity.injectors.component.DaggerMainActivityComponent;
import com.chendoing.introactivity.injectors.module.MainActivityModule;
import com.chendoing.introactivity.injectors.module.TranformModule;
import com.chendoing.introactivity.presenters.MainActivityPresenter;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

//    public final static String EXTRA_MESSAGE = "com.chendoing.intoractivity.MESSAGE";

    @Bind(R.id.edit_message)
    EditText editText;

    @Inject
    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUi();
        initializeDependencyInjector();
        initializePresenter();
    }

    private void initializePresenter() {
        presenter.onCreate();
    }

    private void initUi() {
        setContentView(R.layout.activity_intro);
        ButterKnife.bind(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    protected void initializeDependencyInjector() {
        DaggerMainActivityComponent.builder()
                .appComponent(((AppApplication) getApplication()).getAppComponent())
                .mainActivityModule(new MainActivityModule(this))
                .tranformModule(new TranformModule())
                .build().inject(this);
    }

    public void show(View view){
        presenter.showUserName();
    }

    public void show(String using) {
        editText.setText(using);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
//        String message = editText.getText().toString();

//        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

}
