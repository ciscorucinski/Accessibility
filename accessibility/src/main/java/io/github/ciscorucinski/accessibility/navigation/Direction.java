package io.github.ciscorucinski.accessibility.navigation;

import android.support.annotation.IdRes;

import io.github.ciscorucinski.accessibility.interfaces.DirectionAccessibility;

@SuppressWarnings("unused")
public interface Direction<V> {
    DirectionAccessibility<V> up(@IdRes int viewId);
    DirectionAccessibility<V> down(@IdRes int viewId);
    DirectionAccessibility<V> left(@IdRes int viewId);
    DirectionAccessibility<V> right(@IdRes int viewId);
    DirectionAccessibility<V> focusForward(@IdRes int viewId);
}