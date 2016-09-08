package io.github.ciscorucinski.accessibility.content;

import android.view.View;

import io.github.ciscorucinski.accessibility.view.ViewHandler;

public class TextAccessibilityHandler {

    private static final ViewHandler viewHandler = new ViewHandler();

    static void modifiable(View parentView, CharSequence prependText,
                           CharSequence mainText, CharSequence appendText) {

        CharSequence contentDescription = new StringBuilder(prependText)
                .append(mainText).append(appendText);

        viewHandler.setContentView(parentView, contentDescription);

    }

    static void fixed(View parentView, CharSequence contentDescription) {
        viewHandler.setContentView(parentView, contentDescription);
    }
}