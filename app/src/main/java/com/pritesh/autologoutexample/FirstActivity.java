package com.pritesh.autologoutexample;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.pixplicity.easyprefs.library.Prefs;

import java.util.Calendar;

public class FirstActivity extends AppCompatActivity
{
    private static final String TAG = FirstActivity.class.getName();
    private PendingIntent pendingIntent;
    private AlarmManager alarmManager;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    @Override
    public void onUserInteraction()
    {
        super.onUserInteraction();
        Log.d(TAG, "onUserInteraction");
        if(pendingIntent != null)
        {
            alarmManager.cancel(pendingIntent);
        }
        setOnetimeTimer();
    }

    public void setOnetimeTimer()
    {
        Intent myIntent = new Intent(FirstActivity.this, LogoutService.class);
        pendingIntent = PendingIntent.getService(FirstActivity.this, 0, myIntent, 0);
        alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.MINUTE, LogoutService.LOGIN_TIMEOUT);
        Prefs.putString(LoginActivity.LOGOUT_STRING, "no");
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
    }
}
