package com.example.android.delhitour.fragments;


import android.content.Intent;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.example.android.delhitour.R;
import com.example.android.delhitour.actitvity.AttractionDetailsActivity;
import com.example.android.delhitour.adapter.AttractionAdapter;
import com.example.android.delhitour.databinding.FragmentAttractionBinding;
import com.example.android.delhitour.model.Attraction;

import java.util.ArrayList;

/**
 * Fragment to handle ListView of Attraction
 */
public class AttractionFragment extends Fragment {


    public AttractionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentAttractionBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_attraction, container, false);

        //Get list of Attraction
        final ArrayList<Attraction> attractionList = generateAttractions();

        //Initialize adapter and set on ListView
        AttractionAdapter attractionAdapter = new AttractionAdapter(attractionList);
        binding.listAttraction.setAdapter(attractionAdapter);

        //Set OnItemClickListener on ListView to open details activity(ActDetailsActivity) for respective activity.
        binding.listAttraction.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), AttractionDetailsActivity.class);
                intent.putExtra("ATTRACTION_OBJECT", attractionList.get(i));

                //Fancy animation for Android 5.0+
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Pair p1 = Pair.create(view.findViewById(R.id.image_list_attraction), "attraction_image");
                    Pair p2 = Pair.create(view.findViewById(R.id.text_list_attraction), "attraction_text");
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation(getActivity(), p1, p2);
                    startActivity(intent, options.toBundle());
                } else startActivity(intent);
            }
        });

        return binding.getRoot();
    }

    /**
     * Since Data Binding library was not able to load drawables so I Google'd and found solution
     * https://stackoverflow.com/a/35809319/6494628
     * This code is required only once in whole App.
     */
    @BindingAdapter("android:src")
    public static void setImageResource(ImageView imageView, int resource) {
        imageView.setImageResource(resource);
    }

    /**
     * Method to get all string from strings.xml
     *
     * @return ArrayList of object Attraction
     */
    private ArrayList<Attraction> generateAttractions() {
        ArrayList<Attraction> list = new ArrayList<>();
        String[] name = getResources().getStringArray(R.array.attraction_name);
        String[] shortDesc = getResources().getStringArray(R.array.attraction_description_short);
        String[] longDesc = getResources().getStringArray(R.array.attraction_description_long);
        int[] imageId = {R.drawable.red_fort, R.drawable.qutub_minar, R.drawable.humayun_tomb, R.drawable.india_gate, R.drawable.jama_masjid, R.drawable.lotus_temple, R.drawable.akshardham, R.drawable.old_fort, R.drawable.lodhi_garden, R.drawable.jantar_mantar};

        for (int i = 0; i < name.length; i++) {
            Attraction attraction = new Attraction(i, name[i], shortDesc[i], longDesc[i], imageId[i]);
            list.add(attraction);
        }
        return list;
    }

}
