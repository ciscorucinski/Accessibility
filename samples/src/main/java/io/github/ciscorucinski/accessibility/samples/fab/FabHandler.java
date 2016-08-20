package io.github.ciscorucinski.accessibility.samples.fab;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;

import io.github.ciscorucinski.accessibility.Accessibility;
import io.github.ciscorucinski.accessibility.samples.FragmentType;

public class FabHandler implements FabUpdater {

    private final FloatingActionButton fab;
    private final CoordinatorLayout coordinator;

    public FabHandler(FloatingActionButton fab, CoordinatorLayout coordinator) {

        this.fab = fab;
        this.coordinator = coordinator;

        initialize();

    }

    /**
     * Lets the user know what the initial state of the FAB is
     **/
    private void initialize() {
        Snackbar.make(coordinator, FragmentType.DEFAULT.getUserMessage(), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void update(FragmentType nextFragmentType) {
        fab.setImageResource(nextFragmentType.getIconResource());

        Accessibility.with(fab).setAccessibilityText().setContentDescription(
                String.format("Switch to %s layout", nextFragmentType.name()));
    }

}