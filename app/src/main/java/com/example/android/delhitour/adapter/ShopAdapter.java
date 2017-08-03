package com.example.android.delhitour.adapter;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.android.delhitour.R;
import com.example.android.delhitour.databinding.ListItemShopBinding;
import com.example.android.delhitour.model.Shop;

import java.util.ArrayList;

/**
 * Created by ankurg22 on 3/8/17.
 */

public class ShopAdapter extends BaseAdapter {
    private ArrayList<Shop> shopList;

    public ShopAdapter(ArrayList<Shop> shops) {
        shopList = shops;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        if (convertView == null) {
            ListItemShopBinding binding;
            binding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item_shop, parent, false);
            convertView = binding.getRoot();
            viewHolder = new ViewHolder(binding);
            convertView.setTag(viewHolder);


        } else viewHolder = (ViewHolder) convertView.getTag();

        viewHolder.bind(shopList.get(position));
        return convertView;
    }

    private class ViewHolder {
        private final ListItemShopBinding itemBinding;

        public ViewHolder(ListItemShopBinding binding) {
            this.itemBinding = binding;
        }

        public void bind(Shop shop) {
            itemBinding.setShop(shop);
            itemBinding.executePendingBindings();
        }
    }

    @Override
    public int getCount() {
        return shopList.size();
    }

    @Override
    public Object getItem(int i) {
        return shopList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
}
