package org.rul.nutrimake.ui.people;

import org.rul.nutrimake.data.Person;
import org.rul.nutrimake.ui.main.MainContract;

import javax.inject.Inject;

/**
 * Created by Lucas on 17/01/2017.
 */

public class PeopleNavigator implements PeopleContract.Navigator {

    private MainContract.Navigator mainNavigator;

    @Inject
    public PeopleNavigator(MainContract.Navigator mainNavigator) {
        this.mainNavigator = mainNavigator;
    }

    @Override
    public void goToPersonDetails(Person person) {
        mainNavigator.goToPersonDetails(person);
    }
}
