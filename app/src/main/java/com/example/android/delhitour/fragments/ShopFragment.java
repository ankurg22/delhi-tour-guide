package com.example.android.delhitour.fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.example.android.delhitour.R;
import com.example.android.delhitour.adapter.ShopAdapter;
import com.example.android.delhitour.databinding.FragmentShopBinding;
import com.example.android.delhitour.model.Shop;

import java.util.ArrayList;

/**
 * Fragment to handle ListView of Shops
 */
public class ShopFragment extends Fragment {

    public ShopFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentShopBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shop, container, false);

        //Get list of Eatables
        final ArrayList<Shop> shops = getShops();

        //Initialize adapter and set on listview
        ShopAdapter shopAdapter = new ShopAdapter(shops);
        binding.listShop.setAdapter(shopAdapter);

        //OnItemClickListener on ListView
        //When clicked a popup appears with some information
        binding.listShop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ImageView view1 = new ImageView(getActivity());
                view1.setImageResource(shops.get(i).getImageId());
                view1.setMaxHeight(50);
                view1.setScaleType(ImageView.ScaleType.CENTER_CROP);
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                        .setView(view1)
                        .setTitle(shops.get(i).getName())
                        .setMessage(shops.get(i).getDetail());
                AlertDialog dialog = builder.create();
                dialog.show();
                dialog.getWindow().setLayout(500, 700);
            }
        });
        return binding.getRoot();
    }

    /**
     * Method to get all string from strings.xml
     *
     * @return ArrayList of object Shop
     */
    private ArrayList<Shop> getShops() {
        ArrayList<Shop> list = new ArrayList<>();
        String[] name = getResources().getStringArray(R.array.shop_name);
        String[] detail = getResources().getStringArray(R.array.shop_details);
        int[] imageId = {R.drawable.dilli_haat, R.drawable.janpath, R.drawable.khan_market,
                R.drawable.paharganj, R.drawable.chandini, R.drawable.sarojini, R.drawable.lajpat};

        for (int i = 0; i < name.length; i++) {
            Shop shop = new Shop(imageId[i], name[i], detail[i]);
            list.add(shop);
        }
        return list;
    }

}
