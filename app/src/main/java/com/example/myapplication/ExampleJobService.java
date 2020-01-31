package com.example.myapplication;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;


public class ExampleJobService extends JobService {
    private static final String TAG = "ExampleJobService";
    private boolean jobCancelled = false;
    //private static int VIDEO_REQUEST = 101;

    @Override
    public boolean onStartJob(JobParameters params) {
        Log.d(TAG, "Job started");
       //check(params);

        doBackgroundWork(params);
        return true;
    }


    public void ch()
    {
        Intent i = new Intent(getApplicationContext(),You.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);


        /*Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.example.myapplicationcamera");
        if (launchIntent != null)
            startActivity(launchIntent);
            */

    }
    public void nch()
    {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
    }
    private void doBackgroundWork(final JobParameters params) {
        new Thread(new Runnable() {
            boolean flag = true;
            boolean prev = false;
            @Override
            public void run() {



                while(true)
                {   flag = charging();
                    if (!flag ) {

                        prev = true;
                        //doBackgroundWork(params);
                        ch();
                    }
                    else if(flag){
                        prev = false;
                        //onStopJob(params);
                        nch();
                    }
                    SystemClock.sleep(30*1000);
                    Intent startMain = new Intent(Intent.ACTION_MAIN);
                    startMain.addCategory(Intent.CATEGORY_HOME);
                    startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(startMain);
                    Log.d(TAG, "run: ");
                }
                //Camera c = new Camera();
                //c.video();
               /* Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.example.myapplicationcamera");
                if (launchIntent != null) {
                    startActivity(launchIntent);//null pointer check in case package name was not found
                }
               /* Intent videoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                if(videoIntent.resolveActivity(getPackageManager()) != null)
                {
                    startActivity(videoIntent,VIDEO_REQUEST);
                }
*/

                //int i=0;
               /* while (charging()) {
                    Log.d(TAG, "run: " + i);

                      i++;
                       i=i%1000;
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }*/
                //Log.d(TAG, "run: " + i);
                //SystemClock.sleep(100000);
                //return;
                //onStopJob(params);

                //Log.d(TAG, "Job finished");
                //jobFinished(params, false);
            }
        }).start();
    }

    @Override
    public boolean onStopJob(JobParameters params) {





        Log.d(TAG, "Job cancelled before completion");
        /*Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");
        if (launchIntent != null)
            startActivity(launchIntent);*/

        /*for (int i = 0; !charging(); i++) {
            Log.d(TAG, "run not chg: " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        //jobCancelled = true;
        //doBackgroundWork(params);
        //sendMessage();
        return true;
    }


    public boolean charging()
    {
        IntentFilter iFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = getApplicationContext().registerReceiver(null, iFilter);
        int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                status == BatteryManager.BATTERY_STATUS_FULL;

        return isCharging;
    }
    public void sendMessage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}