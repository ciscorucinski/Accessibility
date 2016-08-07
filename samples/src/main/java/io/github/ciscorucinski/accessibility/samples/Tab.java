package io.github.ciscorucinski.accessibility.samples;

import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;

import io.github.ciscorucinski.accessibility.R;

class Tab {

    // Initialize tab enumeration
    private static final Tab[] tabs = {
            new Tab("REGULAR LAYOUT", R.layout.content_regular_sample, R.layout.content_regular_sample),
            new Tab("CUSTOM VIEW", R.layout.content_customview_sample, R.layout.content_accessibility_sample)
    };

    private static FragmentType tabType;
    private final String name;
    private @LayoutRes int defaultRes;
    private @LayoutRes int accessibleRes;

    private Tab(String name, @LayoutRes int defaultLayoutRes, @LayoutRes int accessibleLayoutRes) {
        this.name = name;
        this.defaultRes = defaultLayoutRes;
        this.accessibleRes = accessibleLayoutRes;

        tabType = FragmentType.DEFAULT;
    }

    static Tab get(int position) {
        if (position > tabs.length - 1) return tabs[0];
        return tabs[position];
    }

    static int count() {
        return tabs.length;
    }

    String getDisplayName() {
        return this.name;
    }

    Fragment getDisplayFragment() {

        switch (tabType) {
            default:            // Cascade default case
            case DEFAULT:       return tabType.getFragment(defaultRes);
            case ACCESSIBLE:    return tabType.getFragment(accessibleRes);
        }
    }

    void setLayoutDisplayType(FragmentType type) {
        tabType = type;
    }

}