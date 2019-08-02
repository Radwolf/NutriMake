package org.rul.nutrimake.app;

import android.app.Application;
import android.content.Context;

import org.rul.nutrimake.injection.app.ApplicationComponent;
import org.rul.nutrimake.injection.app.ApplicationModule;
import org.rul.nutrimake.injection.app.DaggerApplicationComponent;


/**
 * Created by Lucas on 02/01/2017.
 */

public class NutriMakeApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static ApplicationComponent getAppComponent(Context context) {
        return ((NutriMakeApplication) context.getApplicationContext()).applicationComponent;
    }
}
