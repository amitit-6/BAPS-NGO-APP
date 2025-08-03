package com.amit.ngoapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

import java.util.Arrays;
import java.util.List;

public class AboutUsActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private Handler sliderHandler;
    private int currentPage = 0;
    private List<Integer> imageList;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_about_us);

        imageList = Arrays.asList(
                R.drawable.guru_parampara,
                R.drawable.gandhinagar,
                R.drawable.seven_hundred_sant
        );

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new ImageAdapter(imageList));
        viewPager.setUserInputEnabled(true);

        sliderHandler = new Handler(Looper.getMainLooper());
        startAutoSlide();

        WormDotsIndicator dotsIndicator = findViewById(R.id.dots_indicator);
        dotsIndicator.setViewPager2(viewPager);


        TextView aboutText = findViewById(R.id.aboutText);
        aboutText.setText(
                "BAPS Swaminarayan Sanstha is a spiritual, volunteer-driven fellowship " +
                        "dedicated to improving society through individual growth by fostering the Hindu values of faith, service, and global harmony.\n\n" +
                        "“In the joy of others lies our own.” – Pramukh Swami Maharaj\n" +
                        "“True spirituality speaks the language of love.” – Pramukh Swami Maharaj\n" +
                        "“Better the world around you by bettering yourself.” – Pramukh Swami Maharaj"
        );
    }

    private void startAutoSlide() {
        sliderHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (currentPage >= imageList.size()) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
                sliderHandler.postDelayed(this, 3000);
            }
        }, 3000);
    }
}