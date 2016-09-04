package io.github.ciscorucinski.accessibility.interfaces;

@SuppressWarnings("unused")
public interface ViewAccessibility {

    // User of code can do whatever they want - however they want. However, the methods that have
    //     generic return types are rabbit holes that must be followed and "completed" before
    //     coming back to this interface.

    DirectionAccessibility<ViewAccessibility> setFocusableNavigation();
    ViewAccessibility requestFocus();
    ViewAccessibility disableFocusableNavigation();
    ContentDescriptionAccessibility<ViewAccessibility> setAccessibilityText();
}