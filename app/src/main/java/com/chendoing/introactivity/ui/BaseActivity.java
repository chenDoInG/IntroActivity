package com.chendoing.introactivity.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.chendoing.introactivity.AppApplication;
import com.chendoing.introactivity.AppComponent;
import com.chendoing.introactivity.R;

public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent(AppApplication.get(this).getAppComponent());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.intro, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.exit:
                Toast.makeText(this, "exit", Toast.LENGTH_LONG).show();
                return true;
            case R.id.help:
                Toast.makeText(this, "help", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    protected abstract void setupActivityComponent(AppComponent appComponent);
}
