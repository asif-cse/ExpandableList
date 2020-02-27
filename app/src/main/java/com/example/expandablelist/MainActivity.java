package com.example.expandablelist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    List<String> headerList;
    HashMap<String,List<String>> childList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandListData();

        expandableListView = findViewById(R.id.expandableId);
        CustomAdapter customAdapter = new CustomAdapter(this,headerList, childList);
        expandableListView.setAdapter(customAdapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                String selected = headerList.get(groupPosition);
                Toast.makeText(getApplicationContext(),selected,Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }

    public void expandListData(){
        String[] headerArray = getResources().getStringArray(R.array.header_list);
        String[] childArray = getResources().getStringArray(R.array.child_list);

        headerList = new ArrayList<>();
        childList = new HashMap<>();

        for (int i =0; i<headerArray.length; i++){
            //adding data

            headerList.add(headerArray[i]);

            //hash map
            List<String> child = new ArrayList<>();
            child.add(childArray[i]);

            childList.put(headerList.get(i),child);

        }

    }
}