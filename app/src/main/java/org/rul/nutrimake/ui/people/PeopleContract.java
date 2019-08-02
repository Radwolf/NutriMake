package org.rul.nutrimake.ui.people;

import org.rul.nutrimake.data.Person;
import org.rul.nutrimake.ui.util.BaseNavigator;
import org.rul.nutrimake.ui.util.BasePresenter;
import org.rul.nutrimake.ui.util.BaseView;

import java.util.List;

/**
 * Created by Lucas on 04/01/2017.
 */

public interface PeopleContract {

    interface Navigator extends BaseNavigator {

        void goToPersonDetails(Person person);
    }

    interface View extends BaseView {

        void showLoading();

        void hideLoading();

        void showPeopleList(List<Person> peopleList);

        void showToast(String message);
    }

    interface Presenter extends BasePresenter<View> {

        void getPeople();

        void clickPerson(Person person);

        void clickPersonAction(Person person);

        void loadMorePeople();
    }
}
