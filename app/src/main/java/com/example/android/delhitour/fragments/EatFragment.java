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
import com.example.android.delhitour.adapter.EatAdapter;
import com.example.android.delhitour.databinding.FragmentEatBinding;
import com.example.android.delhitour.model.Eat;

import java.util.ArrayList;

/**
 * Fragment to handle ListView of Eatables
 */
public class EatFragment extends Fragment {

    public EatFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentEatBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_eat, container, false);

        //Get list of Eatables
        final ArrayList<Eat> eatables = getEatables();

        //Initialize adapter and set on listview
        EatAdapter eatAdapter = new EatAdapter(eatables);
        binding.listEat.setAdapter(eatAdapter);

        //OnItemClickListener on ListView
        //When clicked a popup appears with some information
        binding.listEat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                ImageView view1 = new ImageView(getActivity());
                view1.setImageResource(eatables.get(i).getImage());
                view1.setScaleType(ImageView.ScaleType.CENTER_CROP);
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                        .setView(view1)
                        .setTitle(eatables.get(i).getName())
                        .setMessage(eatables.get(i).getWhere());
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        return binding.getRoot();
    }

    /**
     * Method to get all string from strings.xml
     *
     * @return ArrayList of object Eat
     */
    private ArrayList<Eat> getEatables() {
        ArrayList<Eat> list = new ArrayList<>();
        String[] name = getResources().getStringArray(R.array.eat_name);
        String[] where = getResources().getStringArray(R.array.eat_where);
        int[] image = new int[]{R.drawable.chole, R.drawable.aloo, R.drawable.papri, R.drawable.tikka,
                R.drawable.kachori, R.drawable.jalebi, R.drawable.karachi, R.drawable.chocolate, R.drawable.amritsari, R.drawable.bitto,};

        for (int i = 0; i < name.length; i++) {
            Eat eat = new Eat(image[i], name[i], where[i]);
            list.add(eat);
        }
        return list;
    }

}
