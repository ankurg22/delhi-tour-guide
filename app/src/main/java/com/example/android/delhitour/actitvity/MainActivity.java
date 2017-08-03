package com.example.android.delhitour.actitvity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.android.delhitour.R;
import com.example.android.delhitour.databinding.ActivityMainBinding;
import com.example.android.delhitour.fragments.ActivitiesFragment;
import com.example.android.delhitour.fragments.AttractionFragment;
import com.example.android.delhitour.fragments.EatFragment;
import com.example.android.delhitour.fragments.ShopFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Centralised activity to access all four ListViews using View Pager
 */
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    //Listener to change header image
    private ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            switch (position) {
                case 0:
                    binding.imageHeader.setImageResource(R.drawable.header_attractions);
                    break;
                case 1:
                    binding.imageHeader.setImageResource(R.drawable.header_activities);
                    break;
                case 2:
                    binding.imageHeader.setImageResource(R.drawable.header_shop);
                    break;
                case 3:
                    binding.imageHeader.setImageResource(R.drawable.header_eat);
                    break;

            }
        }

        @Override
        public void onPageSelected(int position) {
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //Connecting TabLayout to ViewPager
        binding.tabCategories.setupWithViewPager(binding.viewPagerCategories);

        //Setup ViewPager and add listener
        setupViewPager(binding.viewPagerCategories);
        binding.viewPagerCategories.addOnPageChangeListener(pageChangeListener);

    }

    /**
     * @param viewPager to setup adapter on
     */
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new AttractionFragment(), getString(R.string.attraction));
        adapter.addFragment(new ActivitiesFragment(), getString(R.string.activity));
        adapter.addFragment(new ShopFragment(), getString(R.string.shop));
        adapter.addFragment(new EatFragment(), getString(R.string.eat));
        viewPager.setAdapter(adapter);
    }

    /**
     * Adapter class for ViewPager
     */
    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> mFragmentList = new ArrayList<>();
        private List<String> mTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitleList.get(position);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mTitleList.add(title);
        }
    }
}
