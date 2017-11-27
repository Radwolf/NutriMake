package org.rul.nutrimake.ui.clientedetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.rul.nutrimake.R;
import org.rul.nutrimake.data.Person;
import org.rul.nutrimake.model.Cliente;
import org.rul.nutrimake.ui.main.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lucas on 02/01/2017.
 */

public class ClienteDetailsFragment extends Fragment {

    private static final String KEY_CLIENTE = "key_cliente";

    @BindView(R.id.fragment_person_details__toolbar) Toolbar toolbar;
    @BindView(R.id.fragment_person_details__description) TextView description;

    private Cliente cliente;

    public static ClienteDetailsFragment newInstance(Cliente cliente) {
        ClienteDetailsFragment fragment = new ClienteDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_CLIENTE, cliente);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_person_details, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        this.cliente = getArguments().getParcelable(KEY_CLIENTE);

        setupToolbar();
        setCliente(cliente);
    }

    private void setupToolbar() {
        toolbar.inflateMenu(R.menu.person_details);

        if (!((MainActivity) getActivity()).getContainersLayout().hasTwoColumns()) {
            toolbar.setNavigationIcon(R.drawable.ic_back_24dp);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getActivity().onBackPressed();
                }
            });
        }
    }

    private void setCliente(Cliente cliente) {
        toolbar.setTitle(cliente.nombre);
        description.setText(cliente.documentoIdentidad);
    }
}
