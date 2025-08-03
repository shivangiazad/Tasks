package com.shivangi.tasks;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    ListView listView;
    ArrayList arrayList= new ArrayList();
    ArrayAdapter adapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view);
        listView= findViewById(R.id.listview);
        arrayList.add("Mark Zuckerberg");
        arrayList.add("Bill Gates");
        arrayList.add("Elon Musk");
        arrayList.add("Sundar Pichai");
        arrayList.add("Satya Nadella");
        arrayList.add("Tim Cook");
        adapter= new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}