package io.github.ciscorucinski.accessibility.interfaces;

import android.support.annotation.IdRes;
import android.view.View;

import io.github.ciscorucinski.accessibility.Accessibility;

public abstract class Direction {

    protected View parentView;

    public abstract Direction up(@IdRes int viewId);

    public abstract Direction down(@IdRes int viewId);

    public abstract Direction left(@IdRes int viewId);

    public abstract Direction right(@IdRes int viewId);

    public abstract Direction focusForward(@IdRes int viewId);

    public abstract Accessibility.ViewGroupAccessibility complete();

}