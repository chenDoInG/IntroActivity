package com.chendoing.introactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/** 
 * 类说明 
 * @author  chenDoInG 
 * @version V1.0  
 * @创建时间：2013-8-4
 */
public class DisplyMessageActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Intent intent = getIntent();
        String message = intent.getStringExtra(IntroActivity.EXTRA_MESSAGE);
//        Toast makeText = Toast.makeText(this, message, 10);
//        makeText.show();
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        // Set the text view as the activity layout
        setContentView(textView);
    }

}
