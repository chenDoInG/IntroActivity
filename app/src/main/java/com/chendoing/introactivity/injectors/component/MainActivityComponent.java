package com.chendoing.introactivity.injectors.component;

import com.chendoing.introactivity.injectors.ActivityScope;
import com.chendoing.introactivity.injectors.module.TranformModule;
import com.chendoing.introactivity.model.entities.Transform;
import com.chendoing.introactivity.ui.activities.MainActivity;
import com.chendoing.introactivity.injectors.module.MainActivityModule;
import com.chendoing.introactivity.presenters.MainActivityPresenter;

import dagger.Component;

@ActivityScope
@Component(modules = {MainActivityModule.class, TranformModule.class}, dependencies = AppComponent.class)
public interface MainActivityComponent {

    MainActivity inject(MainActivity activity);

    MainActivityPresenter presenter();

    Transform transform();
}
