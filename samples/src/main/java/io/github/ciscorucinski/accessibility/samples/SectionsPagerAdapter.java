package io.github.ciscorucinski.accessibility.samples;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return Tab.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return Tab.count();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Tab.get(position).getName();
    }


}