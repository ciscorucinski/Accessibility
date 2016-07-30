package io.github.ciscorucinski.accessibility.content;

import android.view.View;

public class TextAccessibilityHandler implements ContentDescription {

    private final View parentView;

    public TextAccessibilityHandler(View view) {
        this.parentView = view;
    }

    @Override
    public void setContentDescription(CharSequence text) {
        parentView.setContentDescription(text);
    }

    public static ContentDescription modifiable(View parentView, CharSequence prependText, CharSequence mainText, CharSequence appendText) {

        CharSequence contentDescription =
                new StringBuilder(prependText)
                        .append(mainText).append(appendText);

        return fixed(parentView, contentDescription);

    }

    public static ContentDescription fixed(View parentView, CharSequence contentDescription) {
        ContentDescription textAccessibility = new TextAccessibilityHandler(parentView);
        textAccessibility.setContentDescription(contentDescription);

        return textAccessibility;
    }
}