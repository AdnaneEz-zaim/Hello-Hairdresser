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
import com.example.hellohairdresser.Adapters.ImagesSliderAdapter;
import com.example.hellohairdresser.Adapters.MyGridView;
import com.example.hellohairdresser.Adapters.RecyclerViewAdapterCategories;
import com.example.hellohairdresser.Adapters.RecyclerViewAdapterSalon;
import com.example.hellohairdresser.Models.Salon;

import java.util.ArrayList;

public class HomeClient extends AppCompatActivity {
    MyGridView simpleGrid;
    int logos[] = {R.drawable.image2, R.drawable.image3, R.drawable.adnane,
            R.drawable.image2, R.drawable.image3, R.drawable.adnane,
            R.drawable.image2, R.drawable.image3, R.drawable.adnane,
            R.drawable.image3, R.drawable.image3, R.drawable.adnane};

//  Recycle view Categories
    // Recycler View object
    RecyclerView recycleViewCategories;
    // Array list for recycler view data categoriesList
    ArrayList<String> categoriesList;
    // Layout Manager
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    // adapter class object
    RecyclerViewAdapterCategories adapterCategories;
    // Linear Layout Manager
    LinearLayoutManager HorizontalLayout;

// Recycle view Salon proche
    //Recycler View object
    RecyclerView recyclerViewSalon;
    //ArrayList for recycle view ListSalon
    ArrayList<Salon> salonList;
    // salon adapter
    RecyclerViewAdapterSalon recyclerViewAdapterSalon;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_client);

        //image pub slider
        ViewPager viewPager = findViewById(R.id.pubsImages);
        ImagesSliderAdapter adapter = new ImagesSliderAdapter(this);
        viewPager.setAdapter(adapter);


       /* //image grid slider
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
        });*/

        //categories List
        // initialisation with id's
        recycleViewCategories = (RecyclerView)findViewById(R.id.recyclerviewCategories);
        RecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());

        // Set LayoutManager on Recycler View
        recycleViewCategories.setLayoutManager(RecyclerViewLayoutManager);

        // Adding items to RecyclerView.
        AddItemsToRecyclerViewArrayList();

        // calling constructor of adapter
        // with categoriesList list as a parameter
        adapterCategories = new RecyclerViewAdapterCategories(categoriesList);

        // Set Horizontal Layout Manager
        // for Recycler view
        HorizontalLayout = new LinearLayoutManager(HomeClient.this, LinearLayoutManager.HORIZONTAL, false);
        recycleViewCategories.setLayoutManager(HorizontalLayout);

        // Set adapter on recycler view
        recycleViewCategories.setAdapter(adapterCategories);


        // Salon List
        // initialisation with id's
        recyclerViewSalon = (RecyclerView)findViewById(R.id.recyclerviewSalon);
        //RecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewSalon.setLayoutManager(RecyclerViewLayoutManager);
        // Adding items to RecyclerView.
        AddItemsToRecyclerViewSalonList();

        // calling constructor of adapter
        // with categoriesList list as a parameter
        recyclerViewAdapterSalon = new RecyclerViewAdapterSalon(salonList);

        // Set Horizontal Layout Manager
        // for Recycler view
       // HorizontalLayout = new LinearLayoutManager(HomeClient.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewSalon.setLayoutManager(HorizontalLayout);

        // Set adapter on recycler view
        recyclerViewSalon.setAdapter(recyclerViewAdapterSalon);
    }

    private void AddItemsToRecyclerViewSalonList() {
        salonList = new ArrayList<>();
        salonList.add(new Salon("Salon Name 1","32 emile lettre st 42100,FR"));
        salonList.add(new Salon("Salon Name 2","320 rue bergsson st 42100,FR"));
        salonList.add(new Salon("Salon Name 3","13 rue 11 nouvembre st 42100,FR"));
        salonList.add(new Salon("Salon Name 4","28 jeon gourise st 42100,FR"));
        salonList.add(new Salon("Salon Name 5","82 anatolr france st 42100,FR"));
        salonList.add(new Salon("Salon Name 6","79 jeon boule sartre st 42100,FR"));
    }

    // Function to add items in RecyclerView.
    public void AddItemsToRecyclerViewArrayList()
    {
        // Adding items to ArrayList
         categoriesList= new ArrayList<>();
         categoriesList.add("categorie 1");
         categoriesList.add("categorie 2");
         categoriesList.add("categorie 3");
         categoriesList.add("categorie 4");
         categoriesList.add("categorie 5");
         categoriesList.add("categorie 6");
         categoriesList.add("categorie 7");
    }
}