package org.rul.nutrimake.injection.cliente;

import org.rul.nutrimake.injection.FragmentScope;
import org.rul.nutrimake.injection.people.PeopleModule;
import org.rul.nutrimake.ui.cliente.ClienteFragment;
import org.rul.nutrimake.ui.people.PeopleFragment;

import dagger.Subcomponent;

/**
 * Created by Rul on 04/01/2017.
 */
@FragmentScope
@Subcomponent(
        modules = {ClienteModule.class}
)
public interface ClienteComponent {

    void inject(ClienteFragment fragment);
}
