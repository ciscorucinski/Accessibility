package io.github.ciscorucinski.accessibility.interfaces;

@SuppressWarnings("unused")
public interface ViewAccessibility {
    DirectionAccessibility<ViewAccessibility> setFocusableNavigation();
    ViewAccessibility requestFocus();
    ViewAccessibility disableFocusableNavigation();
    ContentDescriptionAccessibility<ViewAccessibility> setAccessibilityText();
}