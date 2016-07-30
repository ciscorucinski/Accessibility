package io.github.ciscorucinski.accessibility.content;

import android.view.View;

import io.github.ciscorucinski.accessibility.interfaces.ContentDescriptionAccessibility;
import io.github.ciscorucinski.accessibility.interfaces.ModifiableContentDescriptionAccessibility;

@SuppressWarnings("unused")
public class TextAccessibilityDelegate<V> implements ContentDescriptionAccessibility<V>, ModifiableContentDescriptionAccessibility<V> {

    private final V accessibility;
    private final View parentView;

    private StringBuilder mainText;
    private StringBuilder prependText;
    private StringBuilder appendText;
    private boolean isModified;

    public TextAccessibilityDelegate(V accessibility, View parentView) {
        this.accessibility = accessibility;
        this.parentView = parentView;

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
    public V setContentDescription(CharSequence text) {
        this.mainText = new StringBuilder().append(text);
        return complete();
    }

    @Override
    public ModifiableContentDescriptionAccessibility<V> setModifiableContentDescription(CharSequence text) {
        if (text != null) {
            this.isModified = true;
        }

        this.mainText = new StringBuilder().append(text);
        return this;
    }

    @Override
    public V complete() {

        if (isModified) {
            TextAccessibilityHandler.modifiable(parentView, prependText, mainText, appendText);
        } else {
            TextAccessibilityHandler.fixed(parentView, mainText);
        }

        return this.accessibility;

    }
}