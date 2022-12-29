package com.sersoft.simplehttpclient;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private EditText itemEdt;
    private ArrayList<String> rssLinks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // on below line we are initializing our variables.
        // on below line we are creating variables.
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        ListView lv = findViewById(R.id.idLV);
        lv.setClickable(true);
        Button addBtn = findViewById(R.id.idBtnAdd);
        itemEdt = findViewById(R.id.idEdtItemName);
        rssLinks = new ArrayList<>();

//        // on below line we are adding items to our list
//        rssLinks.add("C++");
//        rssLinks.add("Python");

        // on the below line we are initializing the adapter for our list view.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, rssLinks);

        // on below line we are setting adapter for our list view.
        lv.setAdapter(adapter);

        // on below line we are adding click listener for our button.
        addBtn.setOnClickListener(v -> {

            // on below line we are getting text from edit text
            String item = itemEdt.getText().toString();

            // on below line we are checking if item is not empty
            if (!item.isEmpty()) {

                // on below line we are adding item to our list.
                rssLinks.add(item);

                // on below line we are notifying adapter
                // that data in list is updated to
                // update our list view.
                adapter.notifyDataSetChanged();
            }else{
                Toast.makeText(getApplicationContext(),"Field is empty! ",Toast.LENGTH_SHORT).show();
            }


        });

        lv.setOnItemClickListener((parent, view, position, id) -> {

            Intent intent = new Intent(getApplicationContext(), RSSFeedActivity.class);
            final int wich_item=position;

            new AlertDialog.Builder(MainActivity.this)
                    .setIcon(android.R.drawable.ic_delete).setTitle("Are you sure ?")
                    .setMessage("Do you want to delete this link")
                    .setPositiveButton("Yes to delete", (dialog, which) -> {
                        rssLinks.remove(wich_item);
                        adapter.notifyDataSetChanged();
                    }).setNegativeButton("No to view", (dialog, which) -> {
                        intent.putExtra("rssLink", rssLinks.get(wich_item));
                        startActivity(intent);
                    }).show();


        });

    }

}