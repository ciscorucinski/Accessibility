package io.github.ciscorucinski.accessibility.interfaces;

import io.github.ciscorucinski.accessibility.navigation.Direction;

public interface DirectionAccessibility<V> extends Direction<V> {
    V complete();
}