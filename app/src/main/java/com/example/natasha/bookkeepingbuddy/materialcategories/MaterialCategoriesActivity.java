package com.example.natasha.bookkeepingbuddy.materialcategories;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;

import com.example.natasha.bookkeepingbuddy.BaseActivity;
import com.example.natasha.bookkeepingbuddy.R;

public class MaterialCategoriesActivity extends BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_material_categories);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    if (null == savedInstanceState) {
      initFragment(new MaterialCategoriesFragment());
    }

    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }

  private void initFragment(Fragment fragment) {
    FragmentManager manager = getSupportFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.add(R.id.mat_cats_frame, fragment);
    transaction.commit();
  }

}
