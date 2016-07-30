package io.github.ciscorucinski.accessibility.samples.ui;

import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import io.github.ciscorucinski.accessibility.R;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    SectionsPagerAdapter(FragmentManager fm) {
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

    private enum Tab {

        DEFAULT     (R.layout.content_sample),
        ACCESSIBLE  (R.layout.content_accessibility_sample);

        private final Fragment fragment;

        private static Tab[] tabs = values();
        private static int tabCount = tabs.length;

        Tab(@LayoutRes int layoutRes) {
            this.fragment = GenericFragment.newInstance(layoutRes);
        }

        public static Tab get(int position) {
            if (position > tabCount - 1) return DEFAULT;
            return tabs[position];
        }

        public static int count() {
            return tabCount;
        }

        public String getName() {
            return this.name();
        }

        public Fragment getFragment() {
            return this.fragment;
        }
    }
}