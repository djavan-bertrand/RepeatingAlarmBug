package sousoum.com.repeatingalarmbug;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("AlarmBug", "Broadcast received, starting the service");
        // Starts the AlarmService to display a notification
        Intent service = new Intent(context, AlarmService.class);
        context.startService(service);
    }
}
