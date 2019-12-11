package com.rent.dressrental;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class Signup extends AppCompatActivity {

    private TextInputLayout name;
    private TextInputLayout email;
    private TextInputLayout pswd;
    private TextInputLayout phone;
    private MaterialButton signupButton;
    private TextInputEditText pswdEdttxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initView();
    }

    private void initView() {
        name = (TextInputLayout) findViewById(R.id.name);
        email = (TextInputLayout) findViewById(R.id.email);
        pswd = (TextInputLayout) findViewById(R.id.pswd);
        phone = (TextInputLayout) findViewById(R.id.phone);
        signupButton = (MaterialButton) findViewById(R.id.signup_button);
        pswdEdttxt = (TextInputEditText) findViewById(R.id.pswdEdttxt);
    }

    public void signinClick(View view) {

        if (!isPasswordValid(Objects.requireNonNull(pswd.getEditText()).getText())) {
            pswdEdttxt.setError(getString(R.string.shr_error_password));
        } else {
            pswdEdttxt.setError(null);
            startActivity(new Intent(Signup.this,Home.class));// Clear the error
        }

    }

    private boolean isPasswordValid(@Nullable Editable text) {
        return text != null && text.length() >= 5;
    }
}
