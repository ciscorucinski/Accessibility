package io.github.ciscorucinski.accessibility.samples.fab;

import android.view.View;

import io.github.ciscorucinski.accessibility.samples.FragmentType;

interface DisplayUpdater {

    /**
     * Updates the display based on the type of fragment being displayed
     **/
    void updateDisplay(FragmentType currentType, View view);
}