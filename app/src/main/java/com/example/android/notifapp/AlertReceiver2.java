package com.example.android.notifapp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.NotificationCompat;

/**
 * Created by Keerthi Suresh on 24-05-2016.
 */
public class AlertReceiver2 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        createNotification(context, "9:00 a.m ", "Reverse Coding",
                "EVENT DUE");
    }

    public void createNotification(Context context, String msg, String msgTxt, String msgAlert) {
        PendingIntent notificIntent = PendingIntent.getActivity(context, 0,
                new Intent(context, MainActivity.class), 0);

        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.smllicon)
                .setContentTitle(msg)
                .setTicker(msgAlert)
                .setContentText(msgTxt)
                .setSound(soundUri)
                .setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 });


        mBuilder.setContentIntent(notificIntent);

        mBuilder.setAutoCancel(true);

        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(1,mBuilder.build());

    }
}
