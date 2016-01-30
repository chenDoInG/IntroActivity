package com.chendoing.introactivity;

import android.app.Application;
import android.content.Context;

import com.chendoing.introactivity.injectors.module.TranformModule;
import com.chendoing.introactivity.injectors.component.AppComponent;
import com.chendoing.introactivity.injectors.component.DaggerAppComponent;
import com.chendoing.introactivity.injectors.module.AppModule;

public class AppApplication extends Application {

    private AppComponent appComponent;

//    public static AppApplication get(Context context) {
//        return (AppApplication) context.getApplicationContext();
//    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
