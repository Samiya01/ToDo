package com.example.todo;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextTask;
    private Button buttonAdd;
    private ListView listViewTasks;

    private ArrayList<String> taskList;
    private ArrayAdapter<String> taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTask = findViewById(R.id.editText_task);
        buttonAdd = findViewById(R.id.button_add);
        listViewTasks = findViewById(R.id.listView_tasks);

        taskList = new ArrayList<>();
        taskAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);
        listViewTasks.setAdapter(taskAdapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Add task to list
                String task = editTextTask.getText().toString();
                taskList.add(task);
                taskAdapter.notifyDataSetChanged();

                // Clear input field
                editTextTask.setText("");
            }
        });
    }
}
