package io.github.ciscorucinski.accessibility.samples;

import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;

import io.github.ciscorucinski.accessibility.R;
import io.github.ciscorucinski.accessibility.samples.ui.LayoutResourceFragment;

public enum Tab {

    DEFAULT     (R.layout.content_sample),
    ACCESSIBLE  (R.layout.content_accessibility_sample);

    private final Fragment fragment;

    private static Tab[] tabs = values();
    private static int tabCount = tabs.length;

    Tab(@LayoutRes int layoutRes) {
        this.fragment = LayoutResourceFragment.newInstance(layoutRes);
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