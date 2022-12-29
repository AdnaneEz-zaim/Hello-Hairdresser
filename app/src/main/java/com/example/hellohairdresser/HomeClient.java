package com.example.hellohairdresser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.hellohairdresser.Adapters.GridHairdresserNear;
import com.example.hellohairdresser.Adapters.GridViewAdapter;
import com.example.hellohairdresser.Adapters.ImagesSliderAdapter;
import com.example.hellohairdresser.Adapters.MyGridView;
import com.example.hellohairdresser.Adapters.RecyclerViewAdapter;

import java.util.ArrayList;

public class HomeClient extends AppCompatActivity {
    MyGridView simpleGrid;
    int logos[] = {R.drawable.image2, R.drawable.image3, R.drawable.adnane,
            R.drawable.image2, R.drawable.image3, R.drawable.adnane,
            R.drawable.image2, R.drawable.image3, R.drawable.adnane,
            R.drawable.image3, R.drawable.image3, R.drawable.adnane};

//  Recycle view Categories
    // Recycler View object
    RecyclerView recyclerView;
    // Array list for recycler view data source
    ArrayList<String> source;
    // Layout Manager
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    // adapter class object
    RecyclerViewAdapter adapterCategorie;
    // Linear Layout Manager
    LinearLayoutManager HorizontalLayout;
    View ChildView;
    int RecyclerViewItemPosition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_client);

        //image pub slider
        ViewPager viewPager = findViewById(R.id.pubsImages);
        ImagesSliderAdapter adapter = new ImagesSliderAdapter(this);
        viewPager.setAdapter(adapter);

        //image grid slider
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

        //categories *

        // initialisation with id's
        recyclerView = (RecyclerView)findViewById(R.id.recyclerviewCategories);
        RecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());

        // Set LayoutManager on Recycler View
        recyclerView.setLayoutManager(RecyclerViewLayoutManager);

        // Adding items to RecyclerView.
        AddItemsToRecyclerViewArrayList();

        // calling constructor of adapter
        // with source list as a parameter
        adapterCategorie = new RecyclerViewAdapter(source);

        // Set Horizontal Layout Manager
        // for Recycler view
        HorizontalLayout = new LinearLayoutManager(HomeClient.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(HorizontalLayout);

        // Set adapter on recycler view
        recyclerView.setAdapter(adapterCategorie);
    }

    // Function to add items in RecyclerView.
    public void AddItemsToRecyclerViewArrayList()
    {
        // Adding items to ArrayList
        source = new ArrayList<>();
        source.add("gfg");
        source.add("is");
        source.add("best");
        source.add("site");
        source.add("for");
        source.add("interview");
        source.add("preparation");
    }
}