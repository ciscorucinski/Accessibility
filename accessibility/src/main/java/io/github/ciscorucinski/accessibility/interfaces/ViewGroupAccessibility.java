package io.github.ciscorucinski.accessibility.interfaces;

import android.support.annotation.IdRes;
import android.view.View;

@SuppressWarnings("unused")
public interface ViewGroupAccessibility {
    DirectionAccessibility<ViewGroupAccessibility> setFocusableNavigationOn(View parentView);
    DirectionAccessibility<ViewGroupAccessibility> setFocusableNavigationOn(@IdRes int parentViewId);
    ViewGroupAccessibility requestFocusOn(View parentView);
    ViewGroupAccessibility requestFocusOn(int viewId);
    ViewGroupAccessibility disableFocusableNavigationOn(View... views);
    ViewGroupAccessibility disableFocusableNavigationOn(@IdRes int... ids);
    ContentDescriptionAccessibility<ViewGroupAccessibility> setAccessibilityTextOn(View parentView);
    ContentDescriptionAccessibility<ViewGroupAccessibility> setAccessibilityTextOn(@IdRes int viewId);
}