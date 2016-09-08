package io.github.ciscorucinski.accessibility.view;

import android.support.annotation.IdRes;
import android.view.View;

@SuppressWarnings("unused")
interface ViewOperation {

    // User of code can do whatever they want - however they want. However, the methods that have
    //     generic return types are rabbit holes that must be followed and "completed" before
    //     coming back to this interface.

    void requestFocus(View parentView);
    void disableNavigation(View parentView);

    void up(View viewGroup, @IdRes int viewID);
    void down(View viewGroup, @IdRes int viewID);
    void left(View viewGroup, @IdRes int viewID);
    void right(View viewGroup, @IdRes int viewID);
    void focusForward(View viewGroup, @IdRes int viewID);

    void contentView(View parentView, CharSequence text);

}