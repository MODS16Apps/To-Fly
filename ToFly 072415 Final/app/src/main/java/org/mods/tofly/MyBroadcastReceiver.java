package org.mods.tofly;

/**
 * Created by Sarah on 7/23/2015.
 */

import android.content.Intent;
import android.content.BroadcastReceiver;
import android.content.Context;

public class MyBroadcastReceiver extends BroadcastReceiver {
    public MyBroadcastReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {


        if (intent.getAction().equals("org.mods.tofly")) {
            Intent i = new Intent(context, main.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }

}