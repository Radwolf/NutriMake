package org.rul.nutrimake.ui.cliente;

import org.rul.nutrimake.data.Person;
import org.rul.nutrimake.model.Cliente;
import org.rul.nutrimake.ui.main.MainContract;
import org.rul.nutrimake.ui.people.PeopleContract;

import javax.inject.Inject;

/**
 * Created by Lucas on 17/01/2017.
 */

public class ClienteNavigator implements ClienteContract.Navigator {

    private MainContract.Navigator mainNavigator;

    @Inject
    public ClienteNavigator(MainContract.Navigator mainNavigator) {
        this.mainNavigator = mainNavigator;
    }

    @Override
    public void goToClienteDetails(Cliente cliente) {
        mainNavigator.goToClienteDetails(cliente);
    }
}
