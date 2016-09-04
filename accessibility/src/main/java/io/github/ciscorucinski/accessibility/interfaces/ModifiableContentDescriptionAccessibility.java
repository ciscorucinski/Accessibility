package io.github.ciscorucinski.accessibility.interfaces;

import io.github.ciscorucinski.accessibility.content.ModifiableContentDescription;

public interface ModifiableContentDescriptionAccessibility<V> extends ModifiableContentDescription<V> {

    // ModifiableContentDescription<V> is a rabbit hole

    V complete();
}