package com.voidrealms.app6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnAdd;
    private Button btnRemove;
    private ListView lstItems;
    private ArrayList<String> list;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnRemove = (Button)findViewById(R.id.btnRemove);
        lstItems = (ListView)findViewById(R.id.lstItems);

        list = new ArrayList<String>();
        for(int i = 0; i < 20; i++)
        {
            list.add("Item " + i);
        }

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, list);

        lstItems.setAdapter(adapter);

        lstItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String itemValue = (String)lstItems.getItemAtPosition(i);
                Toast.makeText(MainActivity.this, itemValue, Toast.LENGTH_SHORT).show();
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRemove();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAdd();
            }
        });


    }

    private void onAdd()
    {
        list.add("NEW ITEM");
        adapter.notifyDataSetChanged();
    }

    private void onRemove()
    {
        if(list.size() == 0) return;
        list.remove(list.size() - 1);
        adapter.notifyDataSetChanged();
    }
}
