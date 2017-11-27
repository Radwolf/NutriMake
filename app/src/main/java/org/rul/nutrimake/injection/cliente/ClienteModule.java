package org.rul.nutrimake.injection.cliente;

import org.rul.nutrimake.injection.FragmentScope;
import org.rul.nutrimake.ui.cliente.ClienteContract;
import org.rul.nutrimake.ui.cliente.ClienteNavigator;
import org.rul.nutrimake.ui.cliente.ClientePresenter;
import org.rul.nutrimake.ui.people.PeopleContract;
import org.rul.nutrimake.ui.people.PeopleNavigator;
import org.rul.nutrimake.ui.people.PeoplePresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rul on 04/01/2017.
 */
@Module
public class ClienteModule {

    @Provides
    ClienteContract.Navigator provideClienteNavigator(ClienteNavigator navigator) {
        return navigator;
    }

    @Provides
    @FragmentScope
    ClienteContract.Presenter provideClientePresenter(ClientePresenter presenter) {
        return presenter;
    }
}
