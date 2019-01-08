package com.example.demo11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView1 = (ListView) findViewById(R.id.listView1);

        //String Array of values

        String [] data = new String[]{
                "C", "C++", "Java", "VB.NET", "C#", "Node.js", "JavaScript", "HTML",
                "CSS", "PHP"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, data);

        listView1.setAdapter(adapter);


        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String currentdata = listView1.getItemAtPosition(i).toString();

                Toast.makeText(MainActivity.this, currentdata, Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, String.valueOf(l), Toast.LENGTH_SHORT).show();

            }
        });

    }
}
