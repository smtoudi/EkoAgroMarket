package com.example.slawomirmakurat.ekoagromarket;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.slawomirmakurat.ekoagromarket.R;
import com.example.slawomirmakurat.ekoagromarket.fragments.FishAndMeetFragment;
import com.example.slawomirmakurat.ekoagromarket.fragments.FruitsFragment;
import com.example.slawomirmakurat.ekoagromarket.fragments.HomemadePreservesFragment;
import com.example.slawomirmakurat.ekoagromarket.fragments.ServicesFragment;
import com.example.slawomirmakurat.ekoagromarket.fragments.WegetablesFragment;


public class PagerAdapter extends FragmentPagerAdapter {

    private Context context;

    public PagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ServicesFragment();
            case 1:
                return new HomemadePreservesFragment();
            case 2:
                return new FruitsFragment();
            case 3:
                return new WegetablesFragment();
            case 4:
                return new FishAndMeetFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 5;
    }

    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.services);
            case 1:
                return context.getString(R.string.homemade_preserves);
            case 2:
                return context.getString(R.string.fruits);
            case 3:
                return context.getString(R.string.wegetables);
            case 4:
                return context.getString(R.string.fish_meet);

        }
        return null;
    }

}
