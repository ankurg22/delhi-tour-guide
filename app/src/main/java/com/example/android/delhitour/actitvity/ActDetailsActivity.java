package com.example.android.delhitour.actitvity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.android.delhitour.R;
import com.example.android.delhitour.databinding.ActivityActDetailsBinding;
import com.example.android.delhitour.model.Activities;

/**
 * Activity to display details of an Activities or tourist place.
 */
public class ActDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityActDetailsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_act_details);

        //Get the passed object from ActivitiesFragment
        Intent intent = getIntent();
        final Activities activity = (Activities) intent.getSerializableExtra("ACTIVITY_OBJECT");

        //Set the object on layout using Data binding library
        binding.setActivity(activity);

        //Setting clickListener to open map of the given location
        binding.buttonMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(activity.getWhere()));
                startActivity(mapIntent);
            }
        });
    }
}
