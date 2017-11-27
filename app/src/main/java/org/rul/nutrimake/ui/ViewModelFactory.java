package org.rul.nutrimake.ui;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import org.rul.nutrimake.datasource.AppDataSource;

/**
 * Created by Rul on 27/11/2017.
 * Factory for ViewModels
 */
public class ViewModelFactory implements ViewModelProvider.Factory {

    private final AppDataSource mDataSource;

    public ViewModelFactory(AppDataSource dataSource) {
        mDataSource = dataSource;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(AppViewModel.class)) {
            return (T) new AppViewModel(mDataSource);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
