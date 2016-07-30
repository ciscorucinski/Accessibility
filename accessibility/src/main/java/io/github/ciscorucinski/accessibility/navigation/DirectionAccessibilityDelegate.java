package io.github.ciscorucinski.accessibility.navigation;

import android.support.annotation.IdRes;
import android.view.View;

import io.github.ciscorucinski.accessibility.interfaces.DirectionAccessibility;

@SuppressWarnings("unused")
public class DirectionAccessibilityDelegate<V> implements DirectionAccessibility<V> {

    private final V accessibility;
    private final DirectionHandler<V> handler;

    public DirectionAccessibilityDelegate(V accessibility, View viewGroup, @IdRes int parentViewId) {
        this(accessibility, viewGroup.findViewById(parentViewId));
    }

    public DirectionAccessibilityDelegate(V accessibility, View view) {
        this.accessibility = accessibility;
        this.handler = new DirectionHandler<>(this, view);
    }

    public DirectionAccessibility<V> up(@IdRes int viewId) { return handler.up(viewId); }
    public DirectionAccessibility<V> down(@IdRes int viewId) { return handler.down(viewId); }
    public DirectionAccessibility<V> left(@IdRes int viewId) { return handler.left(viewId); }
    public DirectionAccessibility<V> right(@IdRes int viewId) { return handler.right(viewId); }
    public DirectionAccessibility<V> focusForward(@IdRes int viewId) { return handler.focusForward(viewId); }

    @Override
    public V complete() {
        return accessibility;
    }

}