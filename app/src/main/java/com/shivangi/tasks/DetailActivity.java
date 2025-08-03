package com.shivangi.tasks;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    ImageView detail_image;
    //List<MyListData> listData= new ArrayList<>();
    TextView detail_name, detail_desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        detail_name = findViewById(R.id.detail_name);
        detail_desc = findViewById(R.id.detail_desc);
        detail_image = findViewById(R.id.detail_image);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String desc = intent.getStringExtra("desc");
        int imageId = intent.getIntExtra("imgId", -1);
        String fullDesc = intent.getStringExtra("fullDesc");

        detail_name.setText(name);
        detail_desc.setText(desc);
        if (imageId != -1) {
            detail_image.setImageResource(imageId);
        }
        detail_desc.setText(fullDesc);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}