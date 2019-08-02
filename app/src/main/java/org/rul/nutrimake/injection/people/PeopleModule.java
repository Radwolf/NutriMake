package org.rul.nutrimake.injection.people;

import org.rul.nutrimake.injection.FragmentScope;
import org.rul.nutrimake.ui.people.PeopleContract;
import org.rul.nutrimake.ui.people.PeopleNavigator;
import org.rul.nutrimake.ui.people.PeoplePresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Lucas on 04/01/2017.
 */
@Module
public class PeopleModule {

    @Provides
    PeopleContract.Navigator providePeopleNavigator(PeopleNavigator navigator) {
        return navigator;
    }

    @Provides
    @FragmentScope
    PeopleContract.Presenter providePeoplePresenter(PeoplePresenter presenter) {
        return presenter;
    }
}
