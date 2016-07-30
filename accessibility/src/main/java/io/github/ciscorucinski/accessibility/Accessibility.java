package io.github.ciscorucinski.accessibility;

import android.view.View;
import android.view.ViewGroup;

import io.github.ciscorucinski.accessibility.interfaces.ViewAccessibility;
import io.github.ciscorucinski.accessibility.interfaces.ViewGroupAccessibility;

@SuppressWarnings("unused")
public class Accessibility {

    public static ViewGroupAccessibility with(ViewGroup viewGroup) {
        return new ViewGroupAccessibilityHandler(viewGroup);
    }

    public static ViewAccessibility with(View view) {
        return new ViewAccessibilityHandler(view);
    }

}