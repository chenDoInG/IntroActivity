package com.chendoing.introactivity.ui.component;

import com.chendoing.introactivity.AppComponent;
import com.chendoing.introactivity.ui.ActivityScope;
import com.chendoing.introactivity.ui.MainActivity;
import com.chendoing.introactivity.ui.module.MainActivityModule;
import com.chendoing.introactivity.ui.presenter.MainActivityPresenter;

import dagger.Component;

@ActivityScope
@Component(modules = {MainActivityModule.class}, dependencies = AppComponent.class)
public interface MainActivityComponent {

    MainActivity inject(MainActivity activity);

    MainActivityPresenter presenter();
}
