package io.github.ciscorucinski.accessibility.content;

import android.view.View;

import io.github.ciscorucinski.accessibility.interfaces.ContentDescriptionAccessibility;
import io.github.ciscorucinski.accessibility.interfaces.ModifiableContentDescriptionAccessibility;
import io.github.ciscorucinski.accessibility.view.ViewHandler;

@SuppressWarnings("unused")
public class TextAccessibilityDelegate<V> implements ContentDescriptionAccessibility<V> {

    private final V accessibility;
    private final View parentView;
    private final ViewHandler viewHandler;

    private StringBuilder mainText;

    public TextAccessibilityDelegate(V accessibility, View parentView) {
        this.accessibility = accessibility;
        this.parentView = parentView;
        this.viewHandler = new ViewHandler();
    }

    @Override
    public V setContentDescription(CharSequence text) {
        viewHandler.contentView(parentView, text);
        return accessibility;
    }

    @Override
    public ModifiableContentDescriptionAccessibility<V> setModifiableContentDescription(CharSequence text) {
        return new ModifiableTextAccessibilityHandler<>(accessibility, parentView, text);
    }

}