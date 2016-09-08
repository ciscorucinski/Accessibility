package io.github.ciscorucinski.accessibility.content;

import android.view.View;

import io.github.ciscorucinski.accessibility.interfaces.ModifiableContentDescriptionAccessibility;
import io.github.ciscorucinski.accessibility.view.ViewHandler;

@SuppressWarnings("unused")
class ModifiableTextAccessibilityHandler<V> implements ModifiableContentDescriptionAccessibility<V> {

    private final V accessibility;
    private final View parentView;
    private final ViewHandler viewHandler;

    private CharSequence mainText;
    private StringBuilder prependText;
    private StringBuilder appendText;
    private boolean isModified;

    ModifiableTextAccessibilityHandler(V accessibility, View parentView, CharSequence text) {
        this.accessibility = accessibility;
        this.parentView = parentView;
        this.viewHandler = new ViewHandler();

        this.mainText = text;
        this.appendText = new StringBuilder();
        this.prependText = new StringBuilder();
    }

    @Override
    public ModifiableContentDescriptionAccessibility<V> prepend(CharSequence prependedText) {
        this.prependText.insert(0, prependedText);
        return this;
    }

    @Override
    public ModifiableContentDescriptionAccessibility<V> appendablePrepend(CharSequence prependedText) {
        this.prependText.append(prependedText);
        return this;
    }

    @Override
    public ModifiableContentDescriptionAccessibility<V> append(CharSequence appendedText) {
        this.appendText.append(appendedText);
        return this;
    }

    @Override
    public V complete() {

        int size = mainText.length() + prependText.length() + appendText.length();
        StringBuilder contentDescription = new StringBuilder(size);

        contentDescription = contentDescription.append(prependText).append(mainText).append(appendText);
        viewHandler.contentView(parentView, contentDescription);

        return this.accessibility;

    }
}