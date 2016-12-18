package com.cs442.apipalia.memorygame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;


import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;

import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;



public class FBLogin extends Activity {

    private LoginButton loginButton;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_login);
        loginButton = (LoginButton) findViewById(R.id.btn_FBlogin);


        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {


                Toast.makeText(getApplicationContext(),"User ID:" + loginResult.getAccessToken().getUserId()+ "\n" +
                        "Auth Token: " + loginResult.getAccessToken().getToken(), Toast.LENGTH_LONG).show();
                goHome();

            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(), "Login Cancelled", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getApplicationContext(), "Login Error", Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void goHome() {
        Intent i = new Intent(this, Home.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }
}
