package sg.edu.rp.c346.s19024292.demomycolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText name, index;
    Button add, remove, update;
    ListView alColour;
    ArrayList<String>  ColourList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.editText);
        index = findViewById(R.id.editText2);
        add  = findViewById(R.id.button);
        remove = findViewById(R.id.button2);
        update = findViewById(R.id.button3);
        alColour = findViewById(R.id.listView);
        ColourList = new ArrayList<String>();
        ColourList.add("Red");
        ColourList.add("Orange");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ColourList);

        alColour.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newcolour = name.getText().toString();
                int pos = Integer.parseInt(index.getText().toString());
                if (index.getText().toString().isEmpty()){
                    ColourList.add(newcolour);
                }
                else {
                    ColourList.add(pos, newcolour);
                }
                adapter.notifyDataSetChanged();
            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = Integer.parseInt(index.getText().toString());
                ColourList.remove(pos);
                adapter.notifyDataSetChanged();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newcolour = name.getText().toString();
                int pos = Integer.parseInt(index.getText().toString());
                ColourList.set(pos, newcolour);
            }
        });

        alColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = ColourList.get(position);
                Toast.makeText(MainActivity.this, colour, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
