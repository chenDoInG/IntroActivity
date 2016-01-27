package com.chendoing.introactivity.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.chendoing.introactivity.AppComponent;
import com.chendoing.introactivity.R;
import com.chendoing.introactivity.ui.BaseActivity;
import com.chendoing.introactivity.ui.MainActivity;

import butterknife.Bind;

public class DisplayMessageActivity extends BaseActivity {

    @Bind(R.id.names)
    ListView names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

}
