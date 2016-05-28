package com.example.android.notifapp;

import android.app.AlarmManager;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    public int interval = 5;
    ListView listView;
    ArrayAdapter<String> listAdapter;
    String fragmentArray[] = {"Hackathon , 26th May 10:30 AM",
            "Reverse coding 27th May 9 AM",
            "Aerofest 28th May 1 PM",
            "Maker Summit 28th May 4 PM"};

    Boolean isClicked[] = {false, false, false, false};
    NotificationManager[] nm = new NotificationManager[4];

    int notifId = 33;
    EditText mEdit;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment1 = new Fragment();
        FragmentManager fragmentManager1 = getFragmentManager();
        fragmentManager1.beginTransaction().replace(R.id.relativeLayout, fragment1).addToBackStack(null).commit();




        listView = (ListView) findViewById(R.id.List);
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, fragmentArray);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onEventClicked(position);
                            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

    }

    @Override
    public void onBackPressed() {

        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }


    public void onEventClicked(int position) {


            Calendar cal = Calendar.getInstance();
            Calendar c = Calendar.getInstance();
            int seconds = c.get(Calendar.SECOND);
            int hour = 0;
            int minute = 0;
            int day = 0;
            switch (position) {
                case 0:
                    day = 26;
                    hour = 10;
                    minute = 30 - interval;
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.MONTH, Calendar.MAY);
                    calendar.set(Calendar.HOUR_OF_DAY, hour);
                    calendar.set(Calendar.MINUTE, minute);

                    if (isClicked[position]==false) {
                        Toast.makeText(this, "Alarm Set", Toast.LENGTH_SHORT).show();
                        AlarmManager alarmManager = (AlarmManager)
                                getSystemService(Context.ALARM_SERVICE);
                        Intent alertIntent = new Intent(this, AlertReceiver1.class);
                        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                                PendingIntent.getBroadcast(this, 1, alertIntent,
                                        PendingIntent.FLAG_UPDATE_CURRENT));
                        isClicked[position] = true;
                    }
                    else{
                        Toast.makeText(this, "Alarm Cancelled ", Toast.LENGTH_SHORT).show();
                        AlarmManager alarmManager = (AlarmManager)
                                getSystemService(Context.ALARM_SERVICE);
                        Intent alertIntent = new Intent(this, AlertReceiver1.class);
                        alarmManager.cancel(PendingIntent.getBroadcast(this, 1, alertIntent,
                                PendingIntent.FLAG_UPDATE_CURRENT));
                        isClicked[position]=false;
                    }
                    break;
                case 1:
                    day = 27;
                    hour = 9;
                    minute = -interval;
                    Calendar calendar1 = Calendar.getInstance();
                    calendar1.set(Calendar.MONTH, Calendar.MAY);
                    calendar1.set(Calendar.HOUR_OF_DAY, hour);
                    calendar1.set(Calendar.MINUTE, minute);
if (isClicked[position]==false) {
    Toast.makeText(this, "Alarm Set", Toast.LENGTH_SHORT).show();
    AlarmManager alarmManager1 = (AlarmManager)
            getSystemService(Context.ALARM_SERVICE);
    Intent alertIntent1 = new Intent(this, AlertReceiver1.class);
    alarmManager1.set(AlarmManager.RTC_WAKEUP, calendar1.getTimeInMillis(),
            PendingIntent.getBroadcast(this, 1, alertIntent1,
                    PendingIntent.FLAG_UPDATE_CURRENT));
    isClicked[position] = true;
}
                    else{
    Toast.makeText(this, "Alarm Cancelled ", Toast.LENGTH_SHORT).show();
    AlarmManager alarmManager1 = (AlarmManager)
        getSystemService(Context.ALARM_SERVICE);
    Intent alertIntent1 = new Intent(this, AlertReceiver1.class);
    alarmManager1.cancel(PendingIntent.getBroadcast(this, 1, alertIntent1,
            PendingIntent.FLAG_UPDATE_CURRENT));
    isClicked[position]=false;
}
                    break;
                case 2:
                    day = 28;
                    hour = 13;
                    minute = -interval;
                    Calendar calendar2 = Calendar.getInstance();
                    calendar2.set(Calendar.MONTH, Calendar.MAY);
                    calendar2.set(Calendar.HOUR_OF_DAY, hour);
                    calendar2.set(Calendar.MINUTE, minute);

                    if (isClicked[position]==false) {
                        Toast.makeText(this, "Alarm Set", Toast.LENGTH_SHORT).show();
                        AlarmManager alarmManager2 = (AlarmManager)
                                getSystemService(Context.ALARM_SERVICE);
                        Intent alertIntent2 = new Intent(this, AlertReceiver2.class);
                        alarmManager2.set(AlarmManager.RTC_WAKEUP, calendar2.getTimeInMillis(),
                                PendingIntent.getBroadcast(this, 1, alertIntent2,
                                        PendingIntent.FLAG_UPDATE_CURRENT));
                        isClicked[position] = true;
                    }
                    else{
                        Toast.makeText(this, "Alarm Cancelled ", Toast.LENGTH_SHORT).show();
                        AlarmManager alarmManager2 = (AlarmManager)
                                getSystemService(Context.ALARM_SERVICE);
                        Intent alertIntent2 = new Intent(this, AlertReceiver2.class);
                        alarmManager2.cancel(PendingIntent.getBroadcast(this, 1, alertIntent2,
                                PendingIntent.FLAG_UPDATE_CURRENT));
                        isClicked[position]=false;
                    } break;
                case 3:
                    day = 28;
                    hour = 16;
                    minute = -interval;
                    Calendar calendar3 = Calendar.getInstance();
                    calendar3.set(Calendar.MONTH, Calendar.MAY);
                    calendar3.set(Calendar.HOUR_OF_DAY, hour);
                    calendar3.set(Calendar.MINUTE, minute);

                    if (isClicked[position]==false) {
                        Toast.makeText(this, "Alarm Set", Toast.LENGTH_SHORT).show();
                        AlarmManager alarmManager3 = (AlarmManager)
                                getSystemService(Context.ALARM_SERVICE);
                        Intent alertIntent3 = new Intent(this, AlertReceiver3.class);
                        alarmManager3.set(AlarmManager.RTC_WAKEUP, calendar3.getTimeInMillis(),
                                PendingIntent.getBroadcast(this, 1, alertIntent3,
                                        PendingIntent.FLAG_UPDATE_CURRENT));
                        isClicked[position] = true;
                    }
                    else{
                        Toast.makeText(this, "Alarm Cancelled ", Toast.LENGTH_SHORT).show();
                        AlarmManager alarmManager3 = (AlarmManager)
                                getSystemService(Context.ALARM_SERVICE);
                        Intent alertIntent3 = new Intent(this, AlertReceiver3.class);
                        alarmManager3.cancel(PendingIntent.getBroadcast(this, 1, alertIntent3,
                                PendingIntent.FLAG_UPDATE_CURRENT));
                        isClicked[position]=false;
                    }
                    break;
            }
    }

    public void onClickInterval(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.relativeLayout);
        Fragment fragment = new Interval();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.relativeLayout, fragment).addToBackStack(null).commit();

        Fragment frag1 = getFragmentManager().findFragmentById(R.id.fragment_interval);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.android.notifapp/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.android.notifapp/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    public void IntervalChanged(int mins) {
        Toast.makeText(this, "Timing changed", Toast.LENGTH_SHORT).show();
        interval = mins;

    }
}

