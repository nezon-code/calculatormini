package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        LinearLayout thev = findViewById(R.id.thev);
        ListView re = findViewById(R.id.list);
        EditText input = findViewById(R.id.input);
        Button addButton = findViewById(R.id.button);
        ArrayList<String> data = new ArrayList<String>();

        GraphFunction f = new GraphFunction("x^2+2");
        f.evaluate(new String[]{"x"}, new double[]{10});

        GraphView viewer = new GraphView(this);
        thev.addView(viewer);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        re.setAdapter(arrayAdapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inpu = input.getText().toString().trim();
                if (!inpu.isEmpty()) {
                    data.add(inpu);
                    viewer.addFunction(new GraphFunction(inpu));
                    arrayAdapter.notifyDataSetChanged();
                    input.setText("");
                    viewer.updateGraph();
                }
            }
        });

        System.out.println("aawwawawwawawaS");
    }
}