package com.example.hellohairdresser.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.hellohairdresser.R;
import java.util.List;

public class RecyclerViewAdapterCategories extends RecyclerView.Adapter<RecyclerViewAdapterCategories.MyCardView>{
    // List with String type
    private List<String> list;

    @NonNull
    @Override
    public MyCardView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate card_categorie_item.xml using LayoutInflator
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_categorie_item, parent,false);
        // return itemView (je doit changer le nom de mon view mettre par exemple Categorie iyrm
        return new MyCardView(itemView);
    }

    //pour chaque element clique de ma list
    @Override
    public void onBindViewHolder(@NonNull MyCardView holder, int position) {
        // Set the text of each item of
        // Recycler view with the list items
        holder.textView.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyCardView extends RecyclerView.ViewHolder {

        // Text View
        TextView textView;

        // parameterised constructor for View Holder class
        // which takes the view as a parameter
        public MyCardView(View view)
        {
            super(view);
            // initialise TextView with id
            textView = (TextView)view.findViewById(R.id.categorieName);
        }
    }

    // Constructor for adapter class
    // which takes a list of String type
    public RecyclerViewAdapterCategories(List<String> horizontalList)
    {
        this.list = horizontalList;
    }


}
