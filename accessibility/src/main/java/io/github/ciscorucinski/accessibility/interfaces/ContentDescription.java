package io.github.ciscorucinski.accessibility.interfaces;

import io.github.ciscorucinski.accessibility.Accessibility;

public abstract class ContentDescription extends ModifiableContentDescription {

    protected StringBuilder mainText;

    public abstract Accessibility.ViewGroupAccessibility setContentDescription(String text);
    public abstract Accessibility.ViewGroupAccessibility setContentDescription(CharSequence text);
    public abstract ModifiableContentDescription setModifiableContentDescription(String text);
    public abstract ModifiableContentDescription setModifiableContentDescription(CharSequence text);

}