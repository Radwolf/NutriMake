package org.rul.nutrimake.injection.people;

import org.rul.nutrimake.injection.FragmentScope;
import org.rul.nutrimake.ui.people.PeopleFragment;

import dagger.Subcomponent;

/**
 * Created by Lucas on 04/01/2017.
 */
@FragmentScope
@Subcomponent(
        modules = {PeopleModule.class}
)
public interface PeopleComponent {

    void inject(PeopleFragment fragment);
}
