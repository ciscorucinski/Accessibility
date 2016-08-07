package io.github.ciscorucinski.accessibility.samples.ui;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.github.ciscorucinski.accessibility.Accessibility;
import io.github.ciscorucinski.accessibility.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class LayoutResourceFragment extends Fragment {

    /**
     * The fragment argument representing the layout resource for this
     * fragment.
     */
    private static final String ARG_LAYOUT = "layout_resource";
    private static final String ARG_ACCESSIBLE = "enforce_accessibility";

    public LayoutResourceFragment() { }

    /**
     * Returns a new instance of this fragment for the layout resource.
     */
    public static LayoutResourceFragment newInstance(@LayoutRes int layoutRes) {
        return newInstance(layoutRes, false);
    }

    public static Fragment newEnforcedAccessibleInstance(int layoutRes) {
        return newInstance(layoutRes, true);
    }

    @NonNull
    private static LayoutResourceFragment newInstance(@LayoutRes int layoutRes,
                                                      boolean enforceAccessibility) {

        LayoutResourceFragment fragment = new LayoutResourceFragment();
        Bundle args = new Bundle();

        args.putInt(ARG_LAYOUT, layoutRes);
        args.putBoolean(ARG_ACCESSIBLE, enforceAccessibility);
        fragment.setArguments(args);

        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        @LayoutRes int layoutRes = getArguments().getInt(ARG_LAYOUT);
        boolean enforceAccessibility = getArguments().getBoolean(ARG_ACCESSIBLE);

        ViewGroup viewGroup = (ViewGroup) inflater.inflate(layoutRes, container, false);

        if (enforceAccessibility) viewGroup = makeAccessible(viewGroup);

        return viewGroup;

    }

    private ViewGroup makeAccessible(ViewGroup view) {

        TextView txtName = (TextView) view.findViewById(R.id.textview_name);
        TextView txtObjective = (TextView) view.findViewById(R.id.textview_objective);
        TextView txtMotto = (TextView) view.findViewById(R.id.textview_motto);
        TextView txtPhone = (TextView) view.findViewById(R.id.textview_phone);
        TextView txtEmail = (TextView) view.findViewById(R.id.textview_email);

        Accessibility.with(view)
                .disableFocusableNavigationOn(
                        R.id.label_objective,
                        R.id.label_motto,
                        R.id.label_phone,
                        R.id.label_email)

                .setFocusableNavigationOn(txtName)
                    .down(R.id.textview_objective).complete()
                .setFocusableNavigationOn(txtObjective)
                    .up(R.id.textview_name)
                    .down(R.id.textview_motto).complete()
                .setFocusableNavigationOn(txtMotto)
                    .up(R.id.textview_objective)
                    .down(R.id.label_contact_info).complete()
                .setFocusableNavigationOn(R.id.label_contact_info)
                    .up(R.id.textview_motto)
                    .down(R.id.textview_phone).complete()
                .setFocusableNavigationOn(txtPhone)
                    .up(R.id.textview_motto)
                    .down(R.id.textview_email).complete()
                .setFocusableNavigationOn(txtEmail)
                    .up(R.id.textview_phone).complete()

                .requestFocusOn(R.id.textview_name)

                .setAccessibilityTextOn(txtName).setContentDescription(
                        String.format("Applicant name is %s",
                                txtName.getText()))
                .setAccessibilityTextOn(txtObjective).setContentDescription(
                        String.format("%s is %s",
                                getResources().getString(R.string.label_objective),
                                txtObjective.getText()))
                .setAccessibilityTextOn(txtMotto).setContentDescription(
                        String.format("%s is %s",
                                getResources().getString(R.string.label_motto),
                                txtMotto.getText()))
                .setAccessibilityTextOn(txtPhone).setContentDescription(
                        String.format("%s is %s",
                                getResources().getString(R.string.label_phone),
                                txtPhone.getText()))
                .setAccessibilityTextOn(txtEmail).setContentDescription(
                        String.format("%s is %s",
                                getResources().getString(R.string.label_email),
                                txtEmail.getText()));

        return view;

    }

}