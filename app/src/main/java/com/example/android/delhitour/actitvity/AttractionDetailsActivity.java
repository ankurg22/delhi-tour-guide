package com.example.android.delhitour.actitvity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.android.delhitour.R;
import com.example.android.delhitour.databinding.ActivityAttractionDetailsBinding;
import com.example.android.delhitour.model.Attraction;

/**
 * Activity to display details of an Activities or tourist place.
 */
public class AttractionDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAttractionDetailsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_attraction_details);

        //Special UI enhancement for Android 5.0+ user
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getWindow().setStatusBarColor(getResources().getColor(android.R.color.transparent));
        }

        //Get the passed object from AttractionFragment
        Intent intent = getIntent();
        final Attraction attraction = (Attraction) intent.getSerializableExtra("ATTRACTION_OBJECT");

        //Set the object on layout using Data binding library
        binding.setAttraction(attraction);
    }
}
