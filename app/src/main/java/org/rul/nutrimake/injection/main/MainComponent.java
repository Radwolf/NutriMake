package org.rul.nutrimake.injection.main;

import org.rul.nutrimake.injection.ActivityScope;
import org.rul.nutrimake.injection.app.ApplicationComponent;
import org.rul.nutrimake.injection.cliente.ClienteComponent;
import org.rul.nutrimake.injection.cliente.ClienteModule;
import org.rul.nutrimake.injection.people.PeopleComponent;
import org.rul.nutrimake.injection.people.PeopleModule;
import org.rul.nutrimake.ui.main.MainActivity;

import dagger.Component;

/**
 * Created by Lucas on 12/06/16.
 */
@ActivityScope
@Component(
        dependencies = {ApplicationComponent.class},
        modules = {MainModule.class}
)
public interface MainComponent {

    void inject(MainActivity activity);

    PeopleComponent plus(PeopleModule peopleModule);

    ClienteComponent plus(ClienteModule clienteModule);

}
