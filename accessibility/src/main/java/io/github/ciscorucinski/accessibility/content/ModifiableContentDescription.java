package io.github.ciscorucinski.accessibility.content;

import io.github.ciscorucinski.accessibility.interfaces.ModifiableContentDescriptionAccessibility;

@SuppressWarnings("unused")
public interface ModifiableContentDescription<V> {
    ModifiableContentDescriptionAccessibility<V> prepend(CharSequence prependedText);
    ModifiableContentDescriptionAccessibility<V> appendablePrepend(CharSequence prependedText);
    ModifiableContentDescriptionAccessibility<V> append(CharSequence appendedText);
}