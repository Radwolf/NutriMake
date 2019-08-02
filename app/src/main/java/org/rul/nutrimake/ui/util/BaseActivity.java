package org.rul.nutrimake.ui.util;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.rul.nutrimake.app.NutriMakeApplication;
import org.rul.nutrimake.injection.app.ApplicationComponent;

/**
 * Created by Lucas on 19/06/16.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent(NutriMakeApplication.getAppComponent(this));
    }

    protected abstract void setupActivityComponent(ApplicationComponent applicationComponent);
}
