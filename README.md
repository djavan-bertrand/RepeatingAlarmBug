# Repeating Alarm Bug

This project is a test to put in light a bug I have with the Android **AlarmManager**.

I might be using it incorrectly so, please, if you something wrong please ping me.

## What I need
I need an alarm to be triggered repeatedly for the whole smartphone life. The alarm should show a notification.

(Note that device restarting is not handle in this test project, so I'm not rescheduling alarms after boot. This is not needed since the problem appears when the device is awake)

## What I don't get
The alarm triggers fine for 3 or 4 days. After that **nothing**. Even the notification is gone.

## How is the project organized

### General

The app is very simple.

`MainActivity` shows a button which is charge of triggering the repeating alarm. When the button is pushed, it asks to the `AlarmScheduler` to schedule an alarm (every minutes).

When the alarm is received, the BroadcastReceiver `AlarmReceiver` start the `AlarmService` Service.

The `AlarmService` post a notification with the name of the implementation. On the notification, the time can be seen to check when was the last notification.

### Branches

To test multiple Alarm implementations, I have one branch per implementation. Each implementation has a different package name to allow testing multiple implementations on the same device. Each implementation has also an implementation name which is printed in the notification.