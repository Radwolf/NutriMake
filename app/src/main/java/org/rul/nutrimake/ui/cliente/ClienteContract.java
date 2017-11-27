package org.rul.nutrimake.ui.cliente;

import org.rul.nutrimake.data.Person;
import org.rul.nutrimake.model.Cliente;
import org.rul.nutrimake.ui.util.BaseNavigator;
import org.rul.nutrimake.ui.util.BasePresenter;
import org.rul.nutrimake.ui.util.BaseView;

import java.util.List;

/**
 * Created by Lucas on 04/01/2017.
 */

public interface ClienteContract {

    interface Navigator extends BaseNavigator {

        void goToClienteDetails(Cliente cliente);
    }

    interface View extends BaseView {

        void showLoading();

        void hideLoading();

        void showClienteList(List<Cliente> clienteList);

        void showToast(String message);
    }

    interface Presenter extends BasePresenter<View> {

        void getCliente();

        void clickCliente(Cliente cliente);

        void clickClienteAction(Cliente cliente);

        void loadMoreCliente();
    }
}
