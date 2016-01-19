package com.chendoing.introactivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class IntroActivity extends BaseActivity {

    public final static String EXTRA_MESSAGE = "com.chendoing.intoractivity.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu1:
                Toast.makeText(this, "exit", Toast.LENGTH_LONG).show();
                return true;
            case R.id.help:
                Toast.makeText(this, "help", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }


    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplyMessageActivity.class);
        EditText editText = (EditText)findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
