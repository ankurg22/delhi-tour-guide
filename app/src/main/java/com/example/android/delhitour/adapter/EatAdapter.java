package com.example.android.delhitour.adapter;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.android.delhitour.R;
import com.example.android.delhitour.databinding.ListItemEatBinding;
import com.example.android.delhitour.model.Eat;

import java.util.ArrayList;

/**
 * Created by ankurg22 on 3/8/17.
 */

public class EatAdapter extends BaseAdapter {
    private ArrayList<Eat> eatList;

    public EatAdapter(ArrayList<Eat> eatables) {
        eatList = eatables;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        if (convertView == null) {
            ListItemEatBinding binding;
            binding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item_eat, parent, false);
            convertView = binding.getRoot();
            viewHolder = new ViewHolder(binding);
            convertView.setTag(viewHolder);


        } else viewHolder = (ViewHolder) convertView.getTag();

        viewHolder.bind(eatList.get(position));
        return convertView;
    }

    private class ViewHolder {
        private final ListItemEatBinding itemBinding;

        public ViewHolder(ListItemEatBinding binding) {
            this.itemBinding = binding;
        }

        public void bind(Eat eat) {
            itemBinding.setEat(eat);
            itemBinding.executePendingBindings();
        }
    }

    @Override
    public int getCount() {
        return eatList.size();
    }

    @Override
    public Object getItem(int i) {
        return eatList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
}
