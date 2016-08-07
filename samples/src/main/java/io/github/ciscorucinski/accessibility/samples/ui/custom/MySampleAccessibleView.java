package io.github.ciscorucinski.accessibility.samples.ui.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import io.github.ciscorucinski.accessibility.Accessibility;
import io.github.ciscorucinski.accessibility.R;

@SuppressWarnings("unused")
public class MySampleAccessibleView extends RelativeLayout {

    private ViewGroup root;

    private TextView txtName;
    private TextView txtObjective;
    private TextView txtMotto;
    private TextView txtPhone;
    private TextView txtEmail;

    private String name;
    private String objective;
    private String motto;
    private String phone;
    private String email;

    public MySampleAccessibleView(Context context) {

        super(context);
        init(null, 0);
    }

    public MySampleAccessibleView(Context context, AttributeSet attrs) {

        super(context, attrs);
        init(attrs, 0);
    }

    public MySampleAccessibleView(Context context, AttributeSet attrs, int defStyle) {

        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {

        root = (ViewGroup) LayoutInflater.from(getContext()).inflate(
                R.layout.content_regular_sample, this, true);

        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.MySampleView, defStyle, 0);

        name = a.getString(R.styleable.MySampleView_name);
        objective = a.getString(R.styleable.MySampleView_objective);
        motto = a.getString(R.styleable.MySampleView_motto);
        phone = a.getString(R.styleable.MySampleView_phone);
        email = a.getString(R.styleable.MySampleView_email);

        a.recycle();

        txtName = (TextView) root.findViewById(R.id.textview_name);
        txtObjective = (TextView) root.findViewById(R.id.textview_objective);
        txtMotto = (TextView) root.findViewById(R.id.textview_motto);
        txtPhone = (TextView) root.findViewById(R.id.textview_phone);
        txtEmail = (TextView) root.findViewById(R.id.textview_email);

        // Use the default text if none of the custom xml attributes are used in the layout declaration
        if (name == null) name = txtName.getText().toString();
        if (objective == null) objective = txtObjective.getText().toString();
        if (motto == null) motto = txtMotto.getText().toString();
        if (phone == null) phone = txtPhone.getText().toString();
        if (email == null) email = txtEmail.getText().toString();

        // Declare Navigation Accessibility
        Accessibility.with(root)
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

                .requestFocusOn(R.id.textview_name);

        // Update TextPaint and text measurements from attributes
        invalidateView();

    }

    private void invalidateView() {

        txtName.setText(name);
        txtObjective.setText(objective);
        txtMotto.setText(motto);
        txtPhone.setText(phone);
        txtEmail.setText(email);

        // Declare Content Description Accessibility
        Accessibility.with(root)
                .setAccessibilityTextOn(txtName)
                    .setModifiableContentDescription(getName())
                        .prepend("Applicant Name is ").complete()
                .setAccessibilityTextOn(txtObjective)
                    .setModifiableContentDescription(getObjective())
                        .prepend(getResources().getString(R.string.label_objective) + " is ").complete() // i.e "Label is"
                .setAccessibilityTextOn(txtMotto)
                    .setModifiableContentDescription(getMotto())
                        .prepend(getResources().getString(R.string.label_motto) + " is ").complete()    // i.e "Motto is"
                .setAccessibilityTextOn(txtPhone)
                    .setModifiableContentDescription(getPhone())
                        .prepend(getResources().getString(R.string.label_phone) + " is ").complete()    // i.e "Phone is"
                .setAccessibilityTextOn(txtEmail)
                    .setModifiableContentDescription(getEmail())
                        .prepend(getResources().getString(R.string.label_email) + " is ").complete();   // i.e "Email is"

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        invalidateView();
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
        invalidateView();
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
        invalidateView();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        invalidateView();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        invalidateView();
    }
}
