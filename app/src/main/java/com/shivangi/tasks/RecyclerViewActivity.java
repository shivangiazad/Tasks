package com.shivangi.tasks;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.shivangi.tasks.DetailActivity;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView rvlist;
    List<MyListData> listData= new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    @Override
    @NonNull
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler_view);
        rvlist= findViewById(R.id.rvlist1);
        listData.add(new MyListData("Mark Zuckerberg", "Meta (Facebook)", R.drawable.mark_zuckerberg,"Mark Zuckerberg co-founded Facebook in 2004 while at Harvard University. He played a pivotal role in transforming social media by connecting billions of users worldwide. Under his leadership, Facebook expanded to acquire Instagram and WhatsApp. Zuckerberg also shifted focus towards virtual reality and the metaverse with Meta Platforms. Despite controversies over privacy and misinformation, he remains a key figure in technology innovation. His vision continues to shape how people communicate online."));
        listData.add(new MyListData("Bill Gates", "Microsoft", R.drawable.bill_gates,"Bill Gates co-founded Microsoft in 1975, revolutionizing the personal computing industry. His vision made software accessible to millions, powering offices and homes globally. Beyond Microsoft, Gates is renowned for his philanthropy through the Bill & Melinda Gates Foundation. He focuses on global health, education, and climate change initiatives. Gates is also a prolific author and advocate for innovation in technology. His impact extends far beyond computing into humanitarian work."));
        listData.add(new MyListData("Elon Musk", "Tesla, SpaceX, X (Twitter)", R.drawable.elon_musk,"Elon Musk is a serial entrepreneur known for founding SpaceX, Tesla, Neuralink, and The Boring Company. He has dramatically accelerated electric vehicle adoption and reusable rocket technology. Musk’s vision of colonizing Mars drives SpaceX’s mission. At Tesla, he pushed the boundaries of battery technology and self-driving cars. He also acquired Twitter (now X), aiming to transform social media. Musk’s bold, sometimes controversial, approach fuels rapid technological progress."));
        listData.add(new MyListData("Sundar Pichai", "Google (Alphabet)", R.drawable.sundar_pichai,"Sundar Pichai became CEO of Google in 2015 and Alphabet in 2019, overseeing massive product portfolios. He led the development of Google Chrome, one of the world’s most popular browsers. Pichai’s leadership emphasizes AI, cloud computing, and sustainability. Under his direction, Google expanded into hardware and software innovations. He is known for his collaborative style and global perspective. Pichai’s influence shapes the future of internet technology."));
        listData.add(new MyListData("Satya Nadella", "Microsoft (CEO after Bill Gates)", R.drawable.satya_nadella,"Satya Nadella took over as Microsoft CEO in 2014, steering the company through major transformations. He championed cloud computing with Azure, making Microsoft a leader in the space. Nadella also embraced open-source software and cross-platform compatibility. His empathetic leadership style revitalized company culture and innovation. He focused on AI, mixed reality, and quantum computing advancements. Nadella’s vision modernized Microsoft for the digital age."));
        listData.add(new MyListData("Tim Cook", "Apple", R.drawable.tim_cook,"Tim Cook succeeded Steve Jobs as Apple CEO in 2011, bringing operational expertise to the role. He expanded Apple’s product lineup with the Apple Watch and AirPods. Cook emphasized privacy, sustainability, and ethical supply chains. Under his tenure, Apple became the first U.S. company to reach a \\$2 trillion market cap. He has guided Apple into services like Apple Music and Apple TV+. Cook’s steady leadership maintains Apple’s status as a global tech leader."));
        RecyclerViewAdapter adapter= new RecyclerViewAdapter(listData, this);
        rvlist.setHasFixedSize(true);
        rvlist.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));
        rvlist.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}