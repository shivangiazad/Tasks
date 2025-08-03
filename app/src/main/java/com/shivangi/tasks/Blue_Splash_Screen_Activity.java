package com.shivangi.tasks;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Blue_Splash_Screen_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_blue_splash_screen);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences= getSharedPreferences("mysharedpref",MODE_PRIVATE);
                String loginstatus= sharedPreferences.getString("loginstatus","false");
                if (loginstatus.equals("true")) {
                    Intent intent = new Intent(getApplicationContext(), RecyclerViewActivity.class);
                    startActivities(new Intent[]{intent});
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), RecyclerViewActivity.class);
                    startActivities(new Intent[]{intent});
                }
            }
        },2000);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}