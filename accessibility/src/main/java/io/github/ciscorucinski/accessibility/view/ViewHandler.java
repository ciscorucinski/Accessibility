package io.github.ciscorucinski.accessibility.view;

import android.support.annotation.IdRes;
import android.view.View;

public class ViewHandler implements ViewOperation {

    public ViewHandler() { }

    @Override
    public void requestFocus(View parentView) {
        parentView.requestFocus();
    }

    @Override
    public void disableFocusableNavigation(View parentView) {
        parentView.setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_NO);
    }

    @Override
    public void up(View viewGroup, @IdRes int viewID) {
        viewGroup.setNextFocusUpId(viewID);
    }

    @Override
    public void down(View viewGroup, @IdRes int viewID) {
        viewGroup.setNextFocusDownId(viewID);
    }

    @Override
    public void left(View viewGroup, @IdRes int viewID) {
        viewGroup.setNextFocusLeftId(viewID);
    }

    @Override
    public void right(View viewGroup, @IdRes int viewID) {
        viewGroup.setNextFocusRightId(viewID);
    }

    @Override
    public void focusForward(View viewGroup, @IdRes int viewID) {
        viewGroup.setNextFocusForwardId(viewID);
    }


    @Override
    public void setContentView(View parentView, CharSequence text) {
        parentView.setContentDescription(text);
    }
}