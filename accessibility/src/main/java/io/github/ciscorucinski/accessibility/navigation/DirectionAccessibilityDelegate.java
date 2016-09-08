package io.github.ciscorucinski.accessibility.navigation;

import android.support.annotation.IdRes;
import android.view.View;

import io.github.ciscorucinski.accessibility.interfaces.DirectionAccessibility;
import io.github.ciscorucinski.accessibility.view.ViewHandler;

@SuppressWarnings("unused")
public class DirectionAccessibilityDelegate<V> implements DirectionAccessibility<V> {

    private final V accessibility;
    private final ViewHandler handler;
    private View parentView;

    public DirectionAccessibilityDelegate(V accessibility, View viewGroup, @IdRes int parentViewId) {
        this(accessibility, viewGroup.findViewById(parentViewId));
    }

    public DirectionAccessibilityDelegate(V accessibility, View view) {
        this.accessibility = accessibility;
        this.parentView = view;
        this.handler = new ViewHandler();
    }

    public DirectionAccessibility<V> up(@IdRes int viewId) {
        handler.up(parentView, viewId);
        return this;
    }
    public DirectionAccessibility<V> down(@IdRes int viewId) {
        handler.down(parentView, viewId);
        return this;
    }
    public DirectionAccessibility<V> left(@IdRes int viewId) {
        handler.left(parentView, viewId);
        return this;
    }
    public DirectionAccessibility<V> right(@IdRes int viewId) {
        handler.right(parentView, viewId);
        return this;
    }
    public DirectionAccessibility<V> focusForward(@IdRes int viewId) {
        handler.focusForward(parentView, viewId);
        return this;
    }

    @Override
    public V complete() {
        return accessibility;
    }

}