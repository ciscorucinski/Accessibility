package io.github.ciscorucinski.accessibility.interfaces;

import android.support.annotation.IdRes;
import android.view.View;

@SuppressWarnings("unused")
public interface ViewGroupAccessibility {

    // User of code can do whatever they want - however they want. However, the methods that have
    //     generic return types are rabbit holes that must be followed and "completed" before
    //     coming back to this interface.

    DirectionAccessibility<ViewGroupAccessibility> setFocusableNavigationOn(View parentView);
    DirectionAccessibility<ViewGroupAccessibility> setFocusableNavigationOn(@IdRes int parentViewId);
    ViewGroupAccessibility requestFocusOn(View parentView);
    ViewGroupAccessibility requestFocusOn(int viewId);
    ViewGroupAccessibility disableFocusableNavigationOn(View... views);
    ViewGroupAccessibility disableFocusableNavigationOn(@IdRes int... ids);
    ContentDescriptionAccessibility<ViewGroupAccessibility> setAccessibilityTextOn(View parentView);
    ContentDescriptionAccessibility<ViewGroupAccessibility> setAccessibilityTextOn(@IdRes int viewId);
}