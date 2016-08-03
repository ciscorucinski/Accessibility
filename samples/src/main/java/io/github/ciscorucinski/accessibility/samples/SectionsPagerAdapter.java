package io.github.ciscorucinski.accessibility.samples;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

    private boolean isUnchanged;
    private FragmentType currentType;
    
    public SectionsPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);

        this.currentType = FragmentType.DEFAULT;
        this.isUnchanged = true;
    }

    @Override
    public Fragment getItem(int position) {
        return Tab.get(position).getDisplayFragment();
    }

    @Override
    public int getCount() {
        return Tab.count();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Tab.get(position).getName();
    }

    public void setFragmentDisplayType(int position, FragmentType type) {

        if (currentType == type) return;

        currentType = type;
        isUnchanged = false;

        Tab currentTab = Tab.get(position);
        currentTab.setLayoutDisplayType(type);
        notifyDataSetChanged();
    }

    @Override
    public int getItemPosition(Object object) {
        if (isUnchanged) return POSITION_UNCHANGED;
        else return POSITION_NONE;
    }
}