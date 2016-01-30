package com.chendoing.introactivity.injectors.module;

import com.chendoing.introactivity.injectors.ActivityScope;
import com.chendoing.introactivity.model.entities.Transform;
import com.chendoing.introactivity.ui.activities.MainActivity;
import com.chendoing.introactivity.presenters.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    private MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    @ActivityScope
    MainActivity provideIntroActivity() {
        return mainActivity;
    }

    @Provides
    @ActivityScope
    MainActivityPresenter provideMainActivityPresenter(MainActivity mainActivity,Transform transform) {
        return new MainActivityPresenter(mainActivity,transform);
    }
}
