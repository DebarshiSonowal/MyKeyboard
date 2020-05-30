package com.deb.mykeyboard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class StartMyServiceAtBootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            Intent serviceIntent = new Intent(context, MyInputMethodService.class);
            context.startService(serviceIntent);
        }
    }
}
