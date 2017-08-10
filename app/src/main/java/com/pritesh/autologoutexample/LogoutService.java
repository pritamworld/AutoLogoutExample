package com.pritesh.autologoutexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class LogoutService extends Service
{
    private static final String TAG = LogoutService.class.getName();
    //Set Time in Minutes
    public static int LOGIN_TIMEOUT = 2;

    public LogoutService()
    {
    }

    @Override
    public int onStartCommand(Intent intent,  int flags, int startId)
    {
        initiateLogout();
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
    }

    private void initiateLogout()
    {
        Intent mIntent = new Intent(getApplication(), LoginActivity.class);
        mIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(mIntent);
    }
}
