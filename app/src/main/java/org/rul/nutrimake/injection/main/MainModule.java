package org.rul.nutrimake.injection.main;

import android.content.Context;

import org.rul.nutrimake.injection.ActivityScope;
import org.rul.nutrimake.ui.main.MainActivity;
import org.rul.nutrimake.ui.main.MainContract;
import org.rul.nutrimake.ui.main.MainNavigator;
import org.rul.nutrimake.ui.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Lucas on 12/06/16.
 */
@Module
public class MainModule {

    private final MainActivity mainActivity;

    public MainModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    @ActivityScope
    MainContract.Navigator provideMainNavigation(MainNavigator navigation) {
        return navigation;
    }

    @Provides
    @ActivityScope
    MainContract.Presenter provideMainPresenter(MainPresenter presenter) {
        return presenter;
    }

    @Provides
    @ActivityScope
    Context provideContext(){
        return mainActivity;
    }

    @Provides
    @ActivityScope
    MainActivity provideMainActivity(){
        return mainActivity;
    }
}
