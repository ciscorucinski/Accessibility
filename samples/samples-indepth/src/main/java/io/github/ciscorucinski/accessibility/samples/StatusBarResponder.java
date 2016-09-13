package io.github.ciscorucinski.accessibility.samples;

import android.animation.Animator;
import android.app.Activity;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import io.github.ciscorucinski.accessibility.R;
import io.github.ciscorucinski.accessibility.samples.fab.FabHandler;
import io.github.ciscorucinski.accessibility.samples.fab.FabResponder;

class StatusBarResponder extends FabResponder {

    private final Activity activity;

    StatusBarResponder(FabHandler fabHandler, Activity activity) {
        super(fabHandler);
        this.activity = activity;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void updateDisplay(FragmentType currentType, final View view) {

        final TextView extended_statusbar = (TextView) activity.findViewById(R.id.extended_statusbar);
        final AppBarLayout appbar = (AppBarLayout) activity.findViewById(R.id.appbar);

        int shift = convertDipToPixel(32);

        extended_statusbar.setText(currentType.getUserMessage());

        final Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        switch (currentType){
            default:
            case DEFAULT:
                appbar.animate().translationYBy(-1 * shift).setDuration(150).setStartDelay(400)
                        .setListener(new AnimateToDefault(extended_statusbar, window, view));
                break;
            case ACCESSIBLE:
                appbar.animate().translationYBy(shift).setDuration(150).setStartDelay(0)
                        .setListener(new AnimateToAccessible(extended_statusbar, window, view));
                break;
        }
    }

    private int convertDipToPixel(int dpValue) {
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dpValue,
                activity.getResources().getDisplayMetrics()
        );
    }

    private static class AnimateToAccessible implements Animator.AnimatorListener {
        private final TextView extended_statusbar;
        private final Window window;
        private final View view;

        AnimateToAccessible(TextView extended_statusbar, Window window, View view) {
            this.extended_statusbar = extended_statusbar;
            this.window = window;
            this.view = view;
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onAnimationStart(Animator animation) {
            extended_statusbar.setVisibility(View.VISIBLE);
            window.setStatusBarColor(ContextCompat.getColor(view.getContext(), R.color.colorAccent));
        }

        @Override
        public void onAnimationEnd(Animator animation) { }

        @Override
        public void onAnimationCancel(Animator animation) { }

        @Override
        public void onAnimationRepeat(Animator animation) { }

    }

    private static class AnimateToDefault implements Animator.AnimatorListener {
        private final TextView extended_statusbar;
        private final Window window;
        private final View view;

        AnimateToDefault(TextView extended_statusbar, Window window, View view) {
            this.extended_statusbar = extended_statusbar;
            this.window = window;
            this.view = view;
        }

        @Override
        public void onAnimationStart(Animator animation) { }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onAnimationEnd(Animator animation) {
            extended_statusbar.setVisibility(View.GONE);
            window.setStatusBarColor(ContextCompat.getColor(view.getContext(), R.color.colorPrimaryDark));
        }

        @Override
        public void onAnimationCancel(Animator animation) { }

        @Override
        public void onAnimationRepeat(Animator animation) { }
    }
}