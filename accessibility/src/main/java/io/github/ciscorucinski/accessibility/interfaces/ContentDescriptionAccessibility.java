package io.github.ciscorucinski.accessibility.interfaces;

@SuppressWarnings("unused")
public interface ContentDescriptionAccessibility<V> {

    // User of code can do whatever they want - however they want. However, the methods that have
    //     generic return types are rabbit holes that must be followed and "completed".
    //
    // There is no going back to this interface directly

    V setContentDescription(CharSequence text);
    ModifiableContentDescriptionAccessibility<V> setModifiableContentDescription(CharSequence text);
}