package com.example.jacob.myapplication;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.O)
            @RequiresApi(api = Build.VERSION_CODES.O)
            public void onClick(View v) {
                Log.d("CLICKED", "MSG");
                AsyncTaskRunner runner = new AsyncTaskRunner();
                runner.execute();
            }
        });
    }

    private class AsyncTaskRunner extends AsyncTask<String, String, String> {


        @Override
        protected String doInBackground(String... params) {
            String t = "";
            try {
                Test test = new Test();
                t = test.tester();
                Log.d("whale", t);
            } catch (Exception e) {
                Log.d("whale", "Fail");
                e.printStackTrace();
            }
            return t;
        }
    }
    }
