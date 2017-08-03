package com.example.android.delhitour.adapter;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.android.delhitour.R;
import com.example.android.delhitour.databinding.ListItemActivitiesBinding;
import com.example.android.delhitour.model.Activities;

import java.util.ArrayList;

/**
 * Created by ankurg22 on 1/8/17.
 */

public class ActivityAdapter extends BaseAdapter {
    private ArrayList<Activities> activities;

    //Constructor to initialize and get the list of activities
    public ActivityAdapter(ArrayList<Activities> locs) {
        this.activities = locs;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        if (convertView == null) {
            ListItemActivitiesBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item_activities, parent, false);
            convertView = binding.getRoot();
            viewHolder = new ViewHolder(binding);
            convertView.setTag(viewHolder);
        } else viewHolder = (ViewHolder) convertView.getTag();

        //Bind object on layout
        viewHolder.bind(activities.get(position));
        return convertView;
    }

    //ViewHolder concept to improve ListView's performance
    private class ViewHolder {
        private final ListItemActivitiesBinding itemBinding;

        public ViewHolder(ListItemActivitiesBinding binding) {
            this.itemBinding = binding;
        }

        public void bind(Activities activity) {
            itemBinding.setActivity(activity);
            itemBinding.executePendingBindings();
        }
    }

    @Override
    public int getCount() {
        return activities.size();
    }

    @Override
    public Object getItem(int i) {
        return activities.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
}
