package io.github.ciscorucinski.accessibility.interfaces;

@SuppressWarnings("unused")
public interface ContentDescriptionAccessibility<V> {
    V setContentDescription(CharSequence text);
    ModifiableContentDescriptionAccessibility<V> setModifiableContentDescription(CharSequence text);
}