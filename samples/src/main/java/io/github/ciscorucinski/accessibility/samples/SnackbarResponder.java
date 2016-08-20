package io.github.ciscorucinski.accessibility.samples;

import android.support.design.widget.Snackbar;
import android.view.View;

import io.github.ciscorucinski.accessibility.samples.fab.FabHandler;
import io.github.ciscorucinski.accessibility.samples.fab.FabResponder;

class SnackbarResponder extends FabResponder {

    SnackbarResponder(FabHandler fabHandler) {
        super(fabHandler);
    }

    @Override
    public void updateDisplay(FragmentType currentType, View view) {
        Snackbar.make(view, currentType.getUserMessage(), Snackbar.LENGTH_LONG).show();
    }

}