package com.chendoing.introactivity.injectors.component;

import com.chendoing.introactivity.injectors.ActivityScope;
import com.chendoing.introactivity.injectors.module.DisplayMessageActivityModule;
import com.chendoing.introactivity.injectors.module.TranformModule;
import com.chendoing.introactivity.model.entities.Transform;
import com.chendoing.introactivity.presenters.DisplayMessageActivityPresenter;
import com.chendoing.introactivity.ui.activities.DisplayMessageActivity;

import dagger.Component;

@ActivityScope
@Component(modules = {DisplayMessageActivityModule.class, TranformModule.class}, dependencies = AppComponent.class)
public interface DisplayActivityComponent {

    DisplayMessageActivity inject(DisplayMessageActivity activity);

    DisplayMessageActivityPresenter presenter();

    Transform transform();
}
