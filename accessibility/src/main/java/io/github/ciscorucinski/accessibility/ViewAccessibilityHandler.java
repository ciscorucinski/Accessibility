package io.github.ciscorucinski.accessibility;

import android.view.View;

import io.github.ciscorucinski.accessibility.content.TextAccessibilityDelegate;
import io.github.ciscorucinski.accessibility.interfaces.ContentDescriptionAccessibility;
import io.github.ciscorucinski.accessibility.interfaces.DirectionAccessibility;
import io.github.ciscorucinski.accessibility.interfaces.ViewAccessibility;
import io.github.ciscorucinski.accessibility.navigation.DirectionAccessibilityDelegate;
import io.github.ciscorucinski.accessibility.view.ViewHandler;

@SuppressWarnings("unused")
class ViewAccessibilityHandler implements ViewAccessibility {

    private View view;
    private ViewHandler viewHandler;

    ViewAccessibilityHandler(View view) {
        this.view = view;
        this.viewHandler = new ViewHandler();
    }

    @Override
    public DirectionAccessibility<ViewAccessibility> setFocusableNavigation() {
        return new DirectionAccessibilityDelegate<ViewAccessibility>(this, view);
    }

    @Override
    public ViewAccessibility requestFocus() {
        viewHandler.requestFocus(view);
        return this;
    }

    @Override
    public ViewAccessibility disableFocusableNavigation() {
        viewHandler.disableFocusableNavigation(view);
        return this;
    }

    @Override
    public ContentDescriptionAccessibility<ViewAccessibility> setAccessibilityText() {
        return new TextAccessibilityDelegate<ViewAccessibility>(this, view);
    }

}