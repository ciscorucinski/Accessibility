package io.github.ciscorucinski.accessibility.navigation;

import android.support.annotation.IdRes;
import android.view.View;

import io.github.ciscorucinski.accessibility.interfaces.DirectionAccessibility;

public class DirectionHandler<V> implements Direction<V> {

    private final View parentView;
    private final DirectionAccessibility<V> accessibility;

    public DirectionHandler(DirectionAccessibility<V> accessibility, View view) {

        this.parentView = view;
        this.accessibility  = accessibility;

    }

    @Override
    public DirectionAccessibility<V> up(@IdRes int viewId) {
        parentView.setNextFocusUpId(viewId);
        return this.accessibility;
    }

    @Override
    public DirectionAccessibility<V> down(@IdRes int viewId) {
        parentView.setNextFocusDownId(viewId);
        return this.accessibility;
    }

    @Override
    public DirectionAccessibility<V> left(@IdRes int viewId) {
        parentView.setNextFocusLeftId(viewId);
        return this.accessibility;
    }

    @Override
    public DirectionAccessibility<V> right(@IdRes int viewId) {
        parentView.setNextFocusRightId(viewId);
        return this.accessibility;
    }

    @Override
    public DirectionAccessibility<V> focusForward(@IdRes int viewId) {
        parentView.setNextFocusForwardId(viewId);
        return this.accessibility;
    }

}