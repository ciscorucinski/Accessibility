package io.github.ciscorucinski.accessibility.samples;

import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;

import io.github.ciscorucinski.accessibility.R;
import io.github.ciscorucinski.accessibility.samples.interfaces.FabInteractor;
import io.github.ciscorucinski.accessibility.samples.interfaces.Swappable;
import io.github.ciscorucinski.accessibility.samples.ui.LayoutResourceFragment;

public enum FragmentType implements Swappable<FragmentType>, FabInteractor {

    DEFAULT     (R.drawable.ic_nonaccessible_black_alpha54, "Accessibility Disabled"),
    ACCESSIBLE  (R.drawable.ic_accessible_black_alpha54, "Accessibility Enabled");

    private final @DrawableRes int icon;
    private final String message;

    FragmentType(@DrawableRes int icon, String message) {
        this.icon = icon;
        this.message = message;
    }

    public Fragment getFragment(@LayoutRes int layoutRes, boolean enforceAccessibility) {
        if (enforceAccessibility) return LayoutResourceFragment.newEnforcedAccessibleInstance(layoutRes);
        return LayoutResourceFragment.newInstance(layoutRes);
    }

    @Override
    public int getIconResource() {
        return icon;
    }

    @Override
    public String getUserMessage() {
        return message;
    }

    @Override
    public FragmentType swap() {
        switch (this) {
            default:
            case DEFAULT:       return ACCESSIBLE;
            case ACCESSIBLE:    return DEFAULT;
        }
    }
}