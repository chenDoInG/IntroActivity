package com.chendoing.introactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

/** 
 * ��˵�� 
 * @author  chenDoInG 
 * @version V1.0  
 * @����ʱ�䣺2013-8-5
 */
public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.intro, menu);
        return true;
    }

    
}
