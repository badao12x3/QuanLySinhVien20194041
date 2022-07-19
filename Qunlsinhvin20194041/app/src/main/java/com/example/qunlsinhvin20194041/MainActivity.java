package com.example.qunlsinhvin20194041;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private StudentDataHelper studentDataHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Student student = new Student(20194041,"Pham Van Han","hoanlazy123@gmail.com","10/10/2001");
        studentDataHelper = new StudentDataHelper(this);
        studentDataHelper.addStudent(student);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tool_bar, menu);
//        MenuItem menuItem = menu.findItem(R.id.app_bar_add);
//        SearchView searchView = MenuItemCompat.
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.app_bar_add:
                Toast.makeText(getBaseContext(), "item2", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}