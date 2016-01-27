package com.chendoing.introactivity.ui;

import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.chendoing.introactivity.AppComponent;
import com.chendoing.introactivity.R;
import com.chendoing.introactivity.ui.component.DaggerMainActivityComponent;
import com.chendoing.introactivity.ui.module.MainActivityModule;
import com.chendoing.introactivity.ui.presenter.MainActivityPresenter;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    public final static String EXTRA_MESSAGE = "com.chendoing.intoractivity.MESSAGE";

    @Bind(R.id.edit_message)
    EditText editText;

    @Inject
    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        ButterKnife.bind(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerMainActivityComponent.builder()
                .appComponent(appComponent)
                .mainActivityModule(new MainActivityModule(this))
                .build().inject(this);
    }

    public void showText(View view){
        presenter.showUserName();
    }
    public void show(String name){
        editText.setText(name);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        String message = editText.getText().toString();

        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
