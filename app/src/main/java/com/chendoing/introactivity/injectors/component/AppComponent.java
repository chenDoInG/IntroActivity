package com.chendoing.introactivity.injectors.component;

import android.app.Application;

import com.chendoing.introactivity.injectors.module.TranformModule;
import com.chendoing.introactivity.injectors.module.AppModule;
import com.chendoing.introactivity.model.entities.Transform;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    Application getApplication();
}
