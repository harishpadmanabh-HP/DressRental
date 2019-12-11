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

public class MainActivity extends AppCompatActivity {

    private TextInputLayout email;
    private TextInputLayout password;
    private MaterialButton nextButton;
    private MaterialButton signupButton;
    private TextInputEditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        email = (TextInputLayout) findViewById(R.id.email);
        password = (TextInputLayout) findViewById(R.id.password);
        nextButton = (MaterialButton) findViewById(R.id.next_button);
        signupButton = (MaterialButton) findViewById(R.id.signup_button);
        passwordEditText = (TextInputEditText) findViewById(R.id.password_edit_text);
    }

    public void signinClick(View view) {
        if (!isPasswordValid(Objects.requireNonNull(password.getEditText()).getText())) {
            passwordEditText.setError(getString(R.string.shr_error_password));
        } else {
            passwordEditText.setError(null);
            startActivity(new Intent(MainActivity.this,Signup.class));// Clear the error
        }
    }

    private boolean isPasswordValid(@Nullable Editable text) {
        return text != null && text.length() >= 5;
    }
}
