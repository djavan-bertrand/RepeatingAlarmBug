package sousoum.com.repeatingalarmbug;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.util.Log;

class AlarmScheduler {

    static void schedule(@NonNull Context context) {
        final long repeatTime = 60000; // every minute

        final Intent intent = new Intent(context.getApplicationContext(),
                AlarmReceiver.class);
        PendingIntent pending = PendingIntent.getBroadcast(context.getApplicationContext(),
                222, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        final AlarmManager alarmManager =
                (AlarmManager) context.getApplicationContext()
                        .getSystemService(Context.ALARM_SERVICE);

        // first stop the current repetition
        Log.d("AlarmBug", "Cancel the pending intent");
        alarmManager.cancel(pending);

        Log.d("AlarmBug", "Set inexact repeating in elapsed + 1 minute");
        alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                SystemClock.elapsedRealtime() + repeatTime, repeatTime, pending);
    }

}
