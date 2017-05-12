package com.example.natasha.bookkeepingbuddy.view;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.natasha.bookkeepingbuddy.R;
import com.example.natasha.bookkeepingbuddy.model.data.BookkeepingContract;
import com.example.natasha.bookkeepingbuddy.model.data.BookkeepingDbHelper;
import com.example.natasha.bookkeepingbuddy.view.fragment.AddEntitiesFragment;

public class MainActivity extends FragmentActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    FragmentManager manager = getSupportFragmentManager();
    Fragment fragment = manager.findFragmentById(R.id.fragment_container);

    if (fragment == null) {
      fragment = new AddEntitiesFragment();
      manager.beginTransaction()
              .add(R.id.fragment_container, fragment)
              .commit();
    }
  }

}
