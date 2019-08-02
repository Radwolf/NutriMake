package org.rul.nutrimake.injection;

import android.content.Context;

import org.rul.nutrimake.configuration.db.AppDatabase;
import org.rul.nutrimake.configuration.db.LocalAppDataSource;
import org.rul.nutrimake.datasource.AppDataSource;
import org.rul.nutrimake.ui.ViewModelFactory;

/**
 * Created by Rul on 27/11/2017.
 */

public class Injection {

    public static AppDataSource provideAppDataSource(Context context){
        AppDatabase database = AppDatabase.getInMemoryDatabase(context);
        return new LocalAppDataSource(database);
    }

    public static ViewModelFactory provideViewModelFactory(Context context) {
        AppDataSource dataSource = provideAppDataSource(context);
        return new ViewModelFactory(dataSource);
    }
}
