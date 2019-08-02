package org.rul.nutrimake.ui.cliente;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import org.rul.nutrimake.R;
import org.rul.nutrimake.data.Person;
import org.rul.nutrimake.model.Cliente;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lucas on 04/01/2017.
 */

public class ClienteView extends FrameLayout {

    @BindView(R.id.item_view_user__row) View row;
    @BindView(R.id.item_view_user__name) TextView name;
    @BindView(R.id.item_view_user__description) TextView description;
    @BindView(R.id.item_view_user__action) View action;

    private Cliente cliente;
    private ClienteView.OnClienteClickListener onClienteClickListener;

    public interface OnClienteClickListener {

        void onClienteClick(Cliente cliente);

        void onClienteActionClick(Cliente cliente);
    }

    public ClienteView(Context context) {
        super(context);
        init();
    }

    public ClienteView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_view_user_internal, this, true);
        ButterKnife.bind(this);
    }

    public void setUser(Cliente cliente) {
        this.cliente = cliente;
        name.setText(cliente.nombre);
        description.setText(cliente.documentoIdentidad);
    }

    public void setonClienteClickListener(final OnClienteClickListener onClienteClickListener) {
        this.onClienteClickListener = onClienteClickListener;
        if (onClienteClickListener != null) {
            row.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClienteClickListener.onClienteClick(cliente);
                }
            });
            action.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClienteClickListener.onClienteActionClick(cliente);
                }
            });
        } else {
            row.setOnClickListener(null);
            action.setOnClickListener(null);
        }
    }
}
