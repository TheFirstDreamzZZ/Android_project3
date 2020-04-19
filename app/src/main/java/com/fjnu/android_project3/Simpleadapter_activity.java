package com.fjnu.android_project3;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Simpleadapter_activity extends AppCompatActivity {
    private String[] animalName={"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    private int[] animalImages={R.drawable.lion, R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};
    ListView listView;
    @Override
    protected void onCreate(Bundle SaveInstanceState) {
        super.onCreate(SaveInstanceState);
        setContentView(R.layout.simple_test);
        listView=findViewById(R.id.simpleView);
        List<Map<String,Object>> listItems = new ArrayList<>();
        for (int i=0;i<animalName.length;i++){
            Map<String,Object> listItem = new HashMap<>();
            listItem.put("name",animalName[i]);
            listItem.put("image",animalImages[i]+"");
            listItems.add(listItem);
        }
        String [] from = {"name","image"};
        int [] to = {R.id.textView,R.id.imageView};
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItems,R.layout.list_items,from,to);
        listView.setAdapter(simpleAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Toast.makeText(getApplicationContext(),animalName[i],Toast.LENGTH_LONG).show();
            }

        });
    }
}
