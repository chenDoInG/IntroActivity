package com.chendoing.introactivity;

import android.app.Application;

import com.chendoing.introactivity.data.AppServiceModule;
import com.chendoing.introactivity.data.api.ApiService;
import com.chendoing.introactivity.data.api.ApiserviceModule;
import com.chendoing.introactivity.model.User;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ApiserviceModule.class, AppServiceModule.class})
public interface AppComponent {

    Application getApplication();

    ApiService getApiService();

    User getUser();

}
