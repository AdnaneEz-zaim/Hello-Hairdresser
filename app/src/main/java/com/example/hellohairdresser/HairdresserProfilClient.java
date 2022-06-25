package com.example.hellohairdresser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.hellohairdresser.Adapters.GridViewAdapter;
import com.example.hellohairdresser.Adapters.ImagesSliderAdapter;
import com.example.hellohairdresser.Adapters.MyGridView;

public class HairdresserProfilClient extends AppCompatActivity {
    MyGridView simpleGrid;
    int logos[] = {R.drawable.image2, R.drawable.image3, R.drawable.adnane,
            R.drawable.image2, R.drawable.image3, R.drawable.adnane,
            R.drawable.image2, R.drawable.image3, R.drawable.adnane,
            R.drawable.image3, R.drawable.image3, R.drawable.adnane};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hairdresser_profil_client);

        ViewPager viewPager = findViewById(R.id.viewPagerIamge);
        ImagesSliderAdapter adapter = new ImagesSliderAdapter(this);
        viewPager.setAdapter(adapter);

        simpleGrid = (MyGridView) findViewById(R.id.simpleGridView); // init GridView
        // Create an object of CustomAdapter and set Adapter to GirdView
        GridViewAdapter customAdapter = new GridViewAdapter(getApplicationContext(), logos);
        simpleGrid.setAdapter(customAdapter);
// implement setOnItemClickListener event on GridView
        simpleGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // set an Intent to Another Activity
//                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//                intent.putExtra("image", logos[position]); // put image data in Intent
              //  startActivity(intent); // start Intent
            }
        });


    }
}