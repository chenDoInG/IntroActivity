package com.chendoing.introactivity.ui.module;

import com.chendoing.introactivity.model.User;
import com.chendoing.introactivity.ui.ActivityScope;
import com.chendoing.introactivity.ui.MainActivity;
import com.chendoing.introactivity.ui.presenter.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    private MainActivity introActivity;

    public MainActivityModule(MainActivity introActivity) {
        this.introActivity = introActivity;
    }

    @Provides
    @ActivityScope
    MainActivity provideIntroActivity() {
        return introActivity;
    }

    @Provides
    @ActivityScope
    MainActivityPresenter provideMainActivityPresenter(MainActivity introActivity, User user) {
        return new MainActivityPresenter(introActivity, user);
    }
}
