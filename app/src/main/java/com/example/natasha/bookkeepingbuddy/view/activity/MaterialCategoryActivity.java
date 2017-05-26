package com.example.natasha.bookkeepingbuddy.view.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.natasha.bookkeepingbuddy.R;
import com.example.natasha.bookkeepingbuddy.view.fragment.MaterialCategoryDialogFragment;

public class MaterialCategoryActivity extends BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_material_category);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        FragmentManager manager = getSupportFragmentManager();
        MaterialCategoryDialogFragment dialog = MaterialCategoryDialogFragment.newInstance("text", "text");
        dialog.show(manager,"Category Dialog");

      }
    });
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }

}
