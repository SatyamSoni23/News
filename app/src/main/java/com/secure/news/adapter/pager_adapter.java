package com.secure.news.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.secure.news.fragement.business_fragement;
import com.secure.news.fragement.entertainment_fragement;
import com.secure.news.fragement.health_fragement;
import com.secure.news.fragement.home_fragement;
import com.secure.news.fragement.science_fragement;
import com.secure.news.fragement.sport_fragement;
import com.secure.news.fragement.technology_fragement;

public class pager_adapter extends FragmentPagerAdapter {

    int tabcount;

    public pager_adapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new home_fragement();
            case 1:
                return new sport_fragement();
            case 2:
                return new business_fragement();
            case 3:
                return new health_fragement();
            case 4:
                return new science_fragement();
            case 5:
                return new entertainment_fragement();
            case 6:
                return new technology_fragement();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
