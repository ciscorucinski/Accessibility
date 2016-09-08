package io.github.ciscorucinski.accessibility.view;

import android.support.annotation.IdRes;
import android.view.View;

@SuppressWarnings("unused")
interface ViewOperation {

    // These are all the view operations that are allowed via the library

    void requestFocus(View parentView);
    void disableNavigation(View parentView);

    void up(View viewGroup, @IdRes int viewID);
    void down(View viewGroup, @IdRes int viewID);
    void left(View viewGroup, @IdRes int viewID);
    void right(View viewGroup, @IdRes int viewID);
    void focusForward(View viewGroup, @IdRes int viewID);

    void contentView(View parentView, CharSequence text);

}