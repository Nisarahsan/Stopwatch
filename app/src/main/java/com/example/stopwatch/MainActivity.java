package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Boolean running=false;
    private int seconds=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState !=null)

        {

            seconds=savedInstanceState.getInt("seconds");

            running=savedInstanceState.getBoolean("running");

        }

        runTimer();

    }

    public void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("seconds", seconds);

        savedInstanceState.putBoolean("running", running);

    }
    public void ocstop(View view) {
        running=false;
    }
    public void ocstart(View view) {
        running=true;
    }
    public void ocreset(View view) {
        running=false;
        seconds=0;
    }
    private  void runTimer(){
        final TextView timev=(TextView)findViewById(R.id.textView);
        final Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hr=seconds/3600;
                int min=(seconds%3600)/60;
                int secs=seconds%60;
                String time=String.format("%d:%02d:%02d",hr,min,secs);
                timev.setText(time);
                if (running){
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }
        });

    }

}