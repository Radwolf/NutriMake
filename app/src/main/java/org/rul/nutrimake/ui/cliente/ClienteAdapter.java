package org.rul.nutrimake.ui.cliente;

import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.rul.nutrimake.R;
import org.rul.nutrimake.data.Person;
import org.rul.nutrimake.model.Cliente;
import org.rul.nutrimake.ui.people.PeopleListDiffCallback;
import org.rul.nutrimake.ui.people.PersonView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucas on 04/01/2017.
 */

public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.ClienteViewHolder> {

    private List<Cliente> clienteList;
    private ClienteView.OnClienteClickListener onClienteClickListener;


    public static class ClienteViewHolder extends RecyclerView.ViewHolder {

        public ClienteView clienteView;

        public ClienteViewHolder(ClienteView clienteView) {
            super(clienteView);
            this.clienteView = clienteView;
        }
    }

    public ClienteAdapter() {
        this.clienteList = new ArrayList<Cliente>();
    }

    public void setOnClienteClickListener(ClienteView.OnClienteClickListener onClienteClickListener) {
        this.onClienteClickListener = onClienteClickListener;
    }

    @Override
    public ClienteAdapter.ClienteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ClienteView view = (ClienteView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_user, parent, false);
        return new ClienteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ClienteViewHolder holder, int position) {
        holder.clienteView.setUser(clienteList.get(position));
        holder.clienteView.setonClienteClickListener(onClienteClickListener);
    }

    public void setClienteList(List<Cliente> clienteList) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new ClienteListDiffCallback(this.clienteList, clienteList));
        this.clienteList.clear();
        this.clienteList.addAll(clienteList);
        diffResult.dispatchUpdatesTo(this);
    }

    @Override
    public int getItemCount() {
        return clienteList.size();
    }
}
