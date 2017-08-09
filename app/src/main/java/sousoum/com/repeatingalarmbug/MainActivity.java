package sousoum.com.repeatingalarmbug;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import sousoum.com.repeatingalarmbug.repeating.elapsed.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // On click, schedule an alarm
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context ctx = MainActivity.this;
                AlarmScheduler.schedule(ctx);

                Toast.makeText(ctx, "Alarm started", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
