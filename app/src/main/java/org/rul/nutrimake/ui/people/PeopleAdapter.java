package org.rul.nutrimake.ui.people;

import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.rul.nutrimake.R;
import org.rul.nutrimake.data.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucas on 04/01/2017.
 */

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PersonViewHolder> {

    private List<Person> peopleList;
    private PersonView.OnPersonClickListener onPersonClickListener;


    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        public PersonView personView;

        public PersonViewHolder(PersonView personView) {
            super(personView);
            this.personView = personView;
        }
    }

    public PeopleAdapter() {
        this.peopleList = new ArrayList<Person>();
    }

    public void setOnPersonClickListener(PersonView.OnPersonClickListener onPersonClickListener) {
        this.onPersonClickListener = onPersonClickListener;
    }

    @Override
    public PeopleAdapter.PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        PersonView view = (PersonView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_user, parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        holder.personView.setUser(peopleList.get(position));
        holder.personView.setonPersonClickListener(onPersonClickListener);
    }

    public void setPeopleList(List<Person> peopleList) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new PeopleListDiffCallback(this.peopleList, peopleList));
        this.peopleList.clear();
        this.peopleList.addAll(peopleList);
        diffResult.dispatchUpdatesTo(this);
    }

    @Override
    public int getItemCount() {
        return peopleList.size();
    }
}
