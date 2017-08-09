package sousoum.com.repeatingalarmbug;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import sousoum.com.repeatingalarmbug.reschedule.inexact.elapsed.R;

public class AlarmService extends IntentService {

    public AlarmService() {
        super("AlarmService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d("AlarmBug", "Service started, posting the notification.");
        // Display a notification when receiving the intent
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this, "Debug")
                .setContentTitle(getString(R.string.app_name))
                .setContentText("Still no bug...")
                .setColor(ContextCompat.getColor(this, R.color.colorPrimary))
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setAutoCancel(true);

        NotificationManager notificationManager = (NotificationManager) getSystemService(
                Context.NOTIFICATION_SERVICE);
        notificationManager.notify(333, notificationBuilder.build());

        Log.d("AlarmBug", "Rescheduling the alarm");
        // Schedule another alarm
        AlarmScheduler.schedule(this);
    }
}
