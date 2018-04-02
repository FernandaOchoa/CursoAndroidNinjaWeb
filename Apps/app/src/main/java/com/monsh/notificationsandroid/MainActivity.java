package com.monsh.notificationsandroid;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createNotification(View view) {
        // Prepare intent which is triggered if the
        // notification is selected
        Intent intent = new Intent(getApplicationContext(), RecieverActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(getApplicationContext(), (int) System.currentTimeMillis(), intent, 0);

        String longText = getString(R.string.strLongText);
        // Build notification
        // Actions are just fake
        Notification n = new Notification.Builder(this)
                .setContentTitle("New mail from " + "test@gmail.com")
                .setContentText("Subject")
                .setSmallIcon(R.drawable.ic_stat_name)
                .addAction(R.drawable.ic_stat_name, "Call", pIntent)
                .addAction(R.drawable.ic_stat_name, "Dismiss", pIntent)
                .addAction(R.drawable.ic_stat_name, "No idea", pIntent)
                .setStyle(new Notification.BigTextStyle().bigText(longText))
                .setContentIntent(pIntent).build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);


        // Hide the notification after its selected
        n.flags |= Notification.FLAG_AUTO_CANCEL;

        notificationManager.notify(0, n);
    }
}
