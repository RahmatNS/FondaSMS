
package com.yeleman.fondasms.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.yeleman.fondasms.App;
import com.yeleman.fondasms.IncomingMessage;

public class IncomingMessageRetry extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        App app = (App) context.getApplicationContext();
        if (!app.isEnabled())
        {
            return;
        }

        IncomingMessage message = app.inbox.getMessage(intent.getData());

        if (message == null)
        {
            return;
        }

        app.inbox.enqueueMessage(message);
    }
}
