package org.rul.nutrimake.ui.main;


import org.rul.nutrimake.data.Person;
import org.rul.nutrimake.model.Cliente;
import org.rul.nutrimake.ui.util.BaseNavigator;
import org.rul.nutrimake.ui.util.BasePresenter;
import org.rul.nutrimake.ui.util.BaseView;

/**
 * Created by Lucas on 12/06/16.
 */
public interface MainContract {

    interface Navigator extends BaseNavigator {

        void goToHomeFeed();

        void goToPeople();

        void goToCliente();

        void goToClienteDetails(Cliente cliente);

        void goToPersonDetails(Person person);

        void goToFavorites();

        void goToMap();

        void goToSettings();

        void goToFeedback();

        boolean onBackPressed();
    }

    interface View extends BaseView {

        void closeDrawer();

        void openDrawer();

        void highlightHomeFeed();

        void highlightCliente();

        void highlightPeople();

        void highlightFavorites();

        void highlightMap();

        void highlightSettings();

        void highlightFeedback();

    }

    interface Presenter extends BasePresenter<View> {

        void clickCliente();

        void clickHomeFeed();

        void clickPeople();

        void clickFavorites();

        void clickMap();

        void clickSettings();

        void clickFeedback();
    }
}
