package com.pritesh.autologoutexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.pixplicity.easyprefs.library.Prefs;

public class LoginActivity extends AppCompatActivity
{

    public static final String LOGOUT_STRING = "logoutString";
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button)findViewById(R.id.btnLogin);
        Prefs.putString(LOGOUT_STRING, "yes");

        btnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent mIntent = new Intent(getApplication(), FirstActivity.class);
                startActivity(mIntent);
            }
        });


    }
}
