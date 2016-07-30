package io.github.ciscorucinski.accessibility;

import android.view.View;

import io.github.ciscorucinski.accessibility.content.TextAccessibilityDelegate;
import io.github.ciscorucinski.accessibility.interfaces.ContentDescriptionAccessibility;
import io.github.ciscorucinski.accessibility.interfaces.DirectionAccessibility;
import io.github.ciscorucinski.accessibility.interfaces.ViewAccessibility;
import io.github.ciscorucinski.accessibility.navigation.DirectionAccessibilityDelegate;

@SuppressWarnings("unused")
class ViewAccessibilityHandler implements ViewAccessibility {

    private View view;

    ViewAccessibilityHandler(View view) {
        this.view = view;
    }

    @Override
    public DirectionAccessibility<ViewAccessibility> setFocusableNavigation() {
        return new DirectionAccessibilityDelegate<ViewAccessibility>(this, view);
    }

    @Override
    public ViewAccessibility requestFocus() {
        view.requestFocus();
        return this;
    }

    @Override
    public ViewAccessibility disableFocusableNavigation() {
        view.setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_NO);
        return this;
    }

    @Override
    public ContentDescriptionAccessibility<ViewAccessibility> setAccessibilityText() {
        return new TextAccessibilityDelegate<ViewAccessibility>(this, view);
    }

}