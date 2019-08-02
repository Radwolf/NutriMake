package org.rul.nutrimake.ui.cliente;

import android.support.v7.util.DiffUtil;

import org.rul.nutrimake.data.Person;
import org.rul.nutrimake.model.Cliente;

import java.util.List;

/**
 * Created by Lucas on 04/01/2017.
 */

public class ClienteListDiffCallback extends DiffUtil.Callback {

    private List<Cliente> oldList;
    private List<Cliente> newList;

    public ClienteListDiffCallback(List<Cliente> oldList, List<Cliente> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList != null ? oldList.size() : 0;
    }

    @Override
    public int getNewListSize() {
        return newList != null ? newList.size() : 0;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return newList.get(newItemPosition) == oldList.get(oldItemPosition);
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return newList.get(newItemPosition).equals(oldList.get(oldItemPosition));
    }
}
