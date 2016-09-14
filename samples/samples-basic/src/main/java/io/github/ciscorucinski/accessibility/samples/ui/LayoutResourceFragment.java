package io.github.ciscorucinski.accessibility.samples.ui;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class LayoutResourceFragment extends Fragment {

    /**
     * The fragment argument representing the layout resource for this
     * fragment.
     */
    private static final String ARG_LAYOUT = "layout_resource";

    public LayoutResourceFragment() { }

    /**
     * Returns a new instance of this fragment for the layout resource.
     */
    public static LayoutResourceFragment newInstance(@LayoutRes int layoutRes) {

        LayoutResourceFragment fragment = new LayoutResourceFragment();
        Bundle args = new Bundle();

        args.putInt(ARG_LAYOUT, layoutRes);
        fragment.setArguments(args);

        return fragment;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        @LayoutRes int layoutRes = getArguments().getInt(ARG_LAYOUT);

        return inflater.inflate(layoutRes, container, false);

    }
}