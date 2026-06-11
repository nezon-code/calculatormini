package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;
import org.mariuszgromada.math.mxparser.Argument;
import org.mariuszgromada.math.mxparser.Expression;

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
        ListView functionlist = findViewById(R.id.list);
        EditText input = findViewById(R.id.input);
        Button button1 = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        ImageButton button4 = findViewById(R.id.button4);
        ArrayList<String> data = new ArrayList<>();

        GraphFunction f = new GraphFunction("x^2+2");
        f.evaluate(new String[]{"x"}, new double[]{10});

        GraphView viewer = new GraphView(this);
        thev.addView(viewer);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        functionlist.setAdapter(arrayAdapter);

        button1.setOnClickListener(v ->
        {
            String inpu = input.getText().toString().trim();
            if (!inpu.isEmpty()) {
                data.add(inpu);
                viewer.addFunction(new GraphFunction(inpu));
                arrayAdapter.notifyDataSetChanged();
                input.setText("");
            }
            else
            {
                arrayAdapter.notifyDataSetChanged();
                input.setText("Enter Function Here.");
            }
        });

        button2.setOnClickListener(v ->
        {
            viewer.updateGraph();
            button1.setVisibility(View.GONE);
            button2.setVisibility(View.GONE);
            button3.setVisibility(View.GONE);
            button4.setVisibility(View.GONE);
            input.setVisibility(View.GONE);
            functionlist.setVisibility(View.GONE);
        });

        input.setOnClickListener(v ->
        {
            if (input.getText().toString().equals("Enter Function Here"))
            {
                input.setText("");
            }
        });


        button3.setOnClickListener(v ->
        {
            data.clear();
            arrayAdapter.notifyDataSetChanged();
        });

        button4.setOnClickListener(v ->
        {
            Intent intent = new Intent(MainActivity.this, Settings.class);
            startActivity(intent);
        });

        System.out.println("hcute");
    }
}