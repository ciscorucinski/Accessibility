package io.github.ciscorucinski.accessibility.samples;

import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;

import io.github.ciscorucinski.accessibility.R;
import io.github.ciscorucinski.accessibility.samples.ui.LayoutResourceFragment;

public enum FragmentType {

    DEFAULT     (R.drawable.ic_nonaccessible_black_alpha54, "Accessibility Disabled"),
    ACCESSIBLE  (R.drawable.ic_accessible_black_alpha54, "Accessibility Enabled");

    private final @DrawableRes int icon;
    private final String message;

    private @LayoutRes int currentLayoutResource;

    FragmentType(@DrawableRes int icon, String message) {
        this.icon = icon;
        this.message = message;
    }

    public Fragment getFragment() {
        return LayoutResourceFragment.newInstance(currentLayoutResource);
    }

    public int getIconResource() {
        return icon;
    }

    public String getUserMessage() {
        return message;
    }

    public void setCurrentLayout(@LayoutRes int layoutRes) {
        currentLayoutResource = layoutRes;
    }

}