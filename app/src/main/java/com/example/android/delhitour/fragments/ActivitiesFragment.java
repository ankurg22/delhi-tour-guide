package com.example.android.delhitour.fragments;


import android.content.Intent;
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

import com.example.android.delhitour.R;
import com.example.android.delhitour.actitvity.ActDetailsActivity;
import com.example.android.delhitour.adapter.ActivityAdapter;
import com.example.android.delhitour.databinding.FragmentActivitiesBinding;
import com.example.android.delhitour.model.Activities;

import java.util.ArrayList;

/**
 * Fragment to handle ListView of Activities
 */
public class ActivitiesFragment extends Fragment {

    public ActivitiesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final FragmentActivitiesBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_activities, container, false);

        //Get list of Activities
        final ArrayList<Activities> activityList = generateActivities();

        //Initialize adapter and set on ListView
        ActivityAdapter activityAdapter = new ActivityAdapter(activityList);
        binding.listActivities.setAdapter(activityAdapter);

        //Set OnItemClickListener on ListView to open details activity(ActDetailsActivity) for respective activity.
        binding.listActivities.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), ActDetailsActivity.class);
                intent.putExtra("ACTIVITY_OBJECT", activityList.get(i));

                //Fancy animation for Android 5.0+
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Pair p1 = Pair.create(view.findViewById(R.id.image_list_activities), "image");
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation(getActivity(), p1);
                    startActivity(intent, options.toBundle());
                } else startActivity(intent);
            }
        });

        return binding.getRoot();
    }

    /**
     * Method to get all string from strings.xml
     *
     * @return ArrayList of object Activities
     */
    private ArrayList<Activities> generateActivities() {
        ArrayList<Activities> list = new ArrayList<>();

        String[] name = getResources().getStringArray(R.array.activities_name);
        String[] what = getResources().getStringArray(R.array.activities_what);
        String[] when = getResources().getStringArray(R.array.activities_when);
        String[] where = getResources().getStringArray(R.array.activities_where);
        String[] howMuch = getResources().getStringArray(R.array.activities_how_much);
        int[] imageId = {R.drawable.paramotoring, R.drawable.gokarting, R.drawable.segway_tour, R.drawable.camping, R.drawable.gamin_vegas, R.drawable.ice_skating, R.drawable.trekking};

        int[] color = new int[]{R.color.one, R.color.two, R.color.three, R.color.four, R.color.five, R.color.six, R.color.seven};

        for (int i = 0; i < name.length; i++) {
            Activities activity = new Activities(i, name[i], what[i], when[i], where[i], howMuch[i], imageId[i], color[i]);
            list.add(activity);
        }

        return list;
    }

}
