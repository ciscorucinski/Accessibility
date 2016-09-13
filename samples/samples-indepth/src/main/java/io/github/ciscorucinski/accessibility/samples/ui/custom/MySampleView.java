package io.github.ciscorucinski.accessibility.samples.ui.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import io.github.ciscorucinski.accessibility.R;

@SuppressWarnings("unused")
public class MySampleView extends RelativeLayout {

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

    public MySampleView(Context context) {

        super(context);
        init(null, 0);
    }

    public MySampleView(Context context, AttributeSet attrs) {

        super(context, attrs);
        init(attrs, 0);
    }

    public MySampleView(Context context, AttributeSet attrs, int defStyle) {

        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {

        ViewGroup root = (ViewGroup) LayoutInflater.from(getContext()).inflate(
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

        invalidateView();

    }

    private void invalidateView() {

        txtName.setText(name);
        txtObjective.setText(objective);
        txtMotto.setText(motto);
        txtPhone.setText(phone);
        txtEmail.setText(email);

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
