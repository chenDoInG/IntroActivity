package com.chendoing.introactivity;

import android.app.Application;
import android.content.Context;

import com.chendoing.introactivity.data.AppServiceModule;
import com.chendoing.introactivity.data.api.ApiserviceModule;

public class AppApplication extends Application {

    private AppComponent appComponent;

    public static AppApplication get(Context context) {
        return (AppApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .apiserviceModule(new ApiserviceModule())
                .appServiceModule(new AppServiceModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
