package io.github.ciscorucinski.accessibility.samples.fab;

import io.github.ciscorucinski.accessibility.samples.FragmentType;

interface FabUpdater {

    /**
     * Updates the FABs icon and accessibility text based on the type of fragment being displayed
     **/
    void update(FragmentType currentType);
}