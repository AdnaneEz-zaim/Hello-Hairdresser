package com.example.hellohairdresser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.hellohairdresser.Adapters.GridHairdresserNear;
import com.example.hellohairdresser.Adapters.GridViewAdapter;
import com.example.hellohairdresser.Adapters.ImagesSliderAdapter;
import com.example.hellohairdresser.Adapters.MyGridView;

public class HomeClient extends AppCompatActivity {
    MyGridView simpleGrid;
    int logos[] = {R.drawable.image2, R.drawable.image3, R.drawable.adnane,
            R.drawable.image2, R.drawable.image3, R.drawable.adnane,
            R.drawable.image2, R.drawable.image3, R.drawable.adnane,
            R.drawable.image3, R.drawable.image3, R.drawable.adnane};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_client);


        ViewPager viewPager = findViewById(R.id.pubsImages);
        ImagesSliderAdapter adapter = new ImagesSliderAdapter(this);
        viewPager.setAdapter(adapter);

        simpleGrid = (MyGridView) findViewById(R.id.gridViewDresser); // init GridView
        // Create an object of CustomAdapter and set Adapter to GirdView
        GridHairdresserNear customAdapter = new GridHairdresserNear(getApplicationContext(), logos);
        simpleGrid.setAdapter(customAdapter);
// implement setOnItemClickListener event on GridView
        simpleGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
     //            set an Intent to Another Activity
                Intent intent = new Intent(HomeClient.this, HairdresserProfilClient.class);
                //intent.putExtra("image", logos[position]); // put image data in Intent
                  startActivity(intent); // start Intent
            }
        });


    }
}