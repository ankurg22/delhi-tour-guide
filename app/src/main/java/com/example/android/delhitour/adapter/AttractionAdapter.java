package com.example.android.delhitour.adapter;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.android.delhitour.R;
import com.example.android.delhitour.databinding.ListItemAttractionBinding;
import com.example.android.delhitour.model.Attraction;

import java.util.ArrayList;

/**
 * Created by ankurg22 on 1/8/17.
 */

public class AttractionAdapter extends BaseAdapter {
    private ArrayList<Attraction> attractions;

    public AttractionAdapter(ArrayList<Attraction> locs) {
        this.attractions = locs;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        if (convertView == null) {
            ListItemAttractionBinding binding;
            binding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item_attraction, parent, false);
            convertView = binding.getRoot();
            viewHolder = new ViewHolder(binding);
            convertView.setTag(viewHolder);


        } else viewHolder = (ViewHolder) convertView.getTag();

        viewHolder.bind(attractions.get(position));
        return convertView;
    }

    private class ViewHolder {
        private final ListItemAttractionBinding itemBinding;

        public ViewHolder(ListItemAttractionBinding binding) {
            this.itemBinding = binding;
        }

        public void bind(Attraction attraction) {
            itemBinding.setAttraction(attraction);
            itemBinding.executePendingBindings();
        }
    }

    @Override
    public int getCount() {
        return attractions.size();
    }

    @Override
    public Object getItem(int i) {
        return attractions.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
}
