package com.example.natasha.bookkeepingbuddy.producttemplates;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.natasha.bookkeepingbuddy.BaseActivity;
import com.example.natasha.bookkeepingbuddy.R;

public class ProductTemplatesActivity extends BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_product_templates);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    if (null == savedInstanceState) {
      initFragment(new ProductTemplatesFragment());
    }

    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }

  private void initFragment(Fragment prodTempsFragment) {
    FragmentManager manager = getSupportFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.add(R.id.prod_temps_frame, prodTempsFragment);
    transaction.commit();
  }

}
