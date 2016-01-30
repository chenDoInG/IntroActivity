package com.chendoing.introactivity.injectors.module;

import com.chendoing.introactivity.injectors.ActivityScope;
import com.chendoing.introactivity.model.entities.Transform;
import com.chendoing.introactivity.presenters.DisplayMessageActivityPresenter;
import com.chendoing.introactivity.ui.activities.DisplayMessageActivity;

import dagger.Module;
import dagger.Provides;

@Module
@ActivityScope
public class DisplayMessageActivityModule {

    private DisplayMessageActivity activity;

    public DisplayMessageActivityModule(DisplayMessageActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    DisplayMessageActivity provideIntroActivity() {
        return activity;
    }

    @Provides
    @ActivityScope
    DisplayMessageActivityPresenter provideMainActivityPresenter(DisplayMessageActivity activity, Transform transform) {
        return new DisplayMessageActivityPresenter(activity, transform);
    }
}
