package io.github.ciscorucinski.accessibility.samples;

import android.app.Activity;
import android.os.Build;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;

import io.github.ciscorucinski.accessibility.samples.fab.FabHandler;
import io.github.ciscorucinski.accessibility.samples.fab.FabResponder;

public class FabFactory {

    public static FabHandler createHandler(FloatingActionButton fab, CoordinatorLayout coordinator,
                                           ViewPager pager, SectionsPagerAdapter adapter,
                                           Activity activity) {

        FabHandler handler;
        FabResponder responder;

        handler = new FabHandler(fab, coordinator);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {        // 21+
            responder = new StatusBarResponder(handler, activity);

        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {   // 19+ Use SnackbarResponder but migrate to a StatusBarResponder equivalent
            responder = new SnackbarResponder(handler);

        } else {                                                            // else
            responder = new SnackbarResponder(handler);

        }

        responder.setupWithPager(pager, adapter);
        fab.setOnClickListener(responder);

        return handler;
    }
}