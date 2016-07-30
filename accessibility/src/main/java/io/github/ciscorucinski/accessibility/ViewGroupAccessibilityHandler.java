package io.github.ciscorucinski.accessibility;

import android.support.annotation.IdRes;
import android.view.View;
import android.view.ViewGroup;

import io.github.ciscorucinski.accessibility.content.TextAccessibilityDelegate;
import io.github.ciscorucinski.accessibility.interfaces.ContentDescriptionAccessibility;
import io.github.ciscorucinski.accessibility.interfaces.DirectionAccessibility;
import io.github.ciscorucinski.accessibility.interfaces.ViewGroupAccessibility;
import io.github.ciscorucinski.accessibility.navigation.DirectionAccessibilityDelegate;

@SuppressWarnings("unused")
class ViewGroupAccessibilityHandler implements ViewGroupAccessibility {

    private View viewGroup;

    ViewGroupAccessibilityHandler(ViewGroup viewGroup) {
        this.viewGroup = viewGroup;
    }

    @Override
    public DirectionAccessibility<ViewGroupAccessibility> setFocusableNavigationOn(@IdRes int parentViewId) {
        return new DirectionAccessibilityDelegate<ViewGroupAccessibility>(this, viewGroup, parentViewId);
    }

    @Override
    public DirectionAccessibility<ViewGroupAccessibility> setFocusableNavigationOn(View parentView) {
        return new DirectionAccessibilityDelegate<ViewGroupAccessibility>(this, parentView);
    }

    @Override
    public ViewGroupAccessibility requestFocusOn(int viewId) {
        return requestFocusOn(viewGroup.findViewById(viewId));
    }

    @Override
    public ViewGroupAccessibility requestFocusOn(View parentView) {
        parentView.requestFocus();
        return this;
    }

    @Override
    public ViewGroupAccessibility disableFocusableNavigationOn(@IdRes int... ids) {
        for (int id : ids) {
            setViewNotImportantForAccessibility(viewGroup.findViewById(id));
        }
        return this;
    }

    @Override
    public ViewGroupAccessibility disableFocusableNavigationOn(View... views) {
        for (View view : views) {
            setViewNotImportantForAccessibility(view);
        }
        return this;
    }

    private void setViewNotImportantForAccessibility(View parentView) {
        parentView.setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_NO);
    }

    @Override
    public ContentDescriptionAccessibility<ViewGroupAccessibility> setAccessibilityTextOn(@IdRes int viewId) {
        return setAccessibilityTextOn(viewGroup.findViewById(viewId));
    }

    @Override
    public ContentDescriptionAccessibility<ViewGroupAccessibility> setAccessibilityTextOn(View parentView) {
        return new TextAccessibilityDelegate<ViewGroupAccessibility>(this, parentView);
    }
}