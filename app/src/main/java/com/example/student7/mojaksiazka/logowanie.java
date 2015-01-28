package com.example.student7.mojaksiazka;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.student7.mojaksiazka.data.EmailAndPassword;
import com.example.student7.mojaksiazka.data.User;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.NonConfigurationInstance;
import org.androidannotations.annotations.ViewById;


@EActivity(R.layout.activity_logowanie)
public class logowanie extends ActionBarActivity {

    public void loginSuccess(User user) {
        ringProgressDialog.dismiss();
        Toast.makeText(this,user.sessionId, Toast.LENGTH_LONG).show();
        AddRecipe_.intent(this).user(user).start();
    }

    public void showError(Exception e) {
        ringProgressDialog.dismiss();
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        e.printStackTrace();
    }

    @ViewById
    EditText email;

    @ViewById
    EditText password;

    @Bean
    @NonConfigurationInstance
    RestLoginBackgroundTask restLoginBackgroundTask;
    ProgressDialog ringProgressDialog;

    @AfterViews
    void init() {
        ringProgressDialog = new ProgressDialog(this);
        ringProgressDialog.setMessage("Czekaj czekaj bo ładuję...");
        ringProgressDialog.setIndeterminate(true);
        if (user != null) {
            AddRecipe_.intent(this).user(user).start();
            finish();
        }
    }
    @Click(R.id.LoginButton)
    void LogowanieClicked() {
        EmailAndPassword emailAndPassword = new EmailAndPassword();
        emailAndPassword.email = email.getText().toString();
        emailAndPassword.password = password.getText().toString();
        ringProgressDialog.show();
        restLoginBackgroundTask.login(emailAndPassword);
    }
    @Extra
    User user;

    @Click
    void RejestracjaBtnClicked(){
        Rejestracja_.intent(this).start();
        finish();
    }

}