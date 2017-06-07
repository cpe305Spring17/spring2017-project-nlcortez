package com.example.natasha.bookkeepingbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.natasha.bookkeepingbuddy.R;
import com.example.natasha.bookkeepingbuddy.materialcategories.MaterialCategoriesActivity;
import com.example.natasha.bookkeepingbuddy.materials.MaterialsActivity;
import com.example.natasha.bookkeepingbuddy.materialtemplates.MaterialTemplatesActivity;
import com.example.natasha.bookkeepingbuddy.model.ProductTemplate;
import com.example.natasha.bookkeepingbuddy.model.data.DBHelper;
import com.example.natasha.bookkeepingbuddy.producttemplates.ProductTemplatesActivity;
import com.google.android.gms.analytics.ecommerce.Product;

public class BaseActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_base);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);


    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.setDrawerListener(toggle);
    toggle.syncState();

    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);

    DBHelper.getInstance(this);
  }

  @Override
  public void onBackPressed() {
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.base, menu);
    return true;
  }

  @SuppressWarnings("StatementWithEmptyBody")
  @Override
  public boolean onNavigationItemSelected(MenuItem item) {
    // Handle navigation view item clicks here.
    int id = item.getItemId();

    if (id == R.id.nav_material_categories) {
      Intent i = new Intent(BaseActivity.this, MaterialCategoriesActivity.class);
      startActivity(i);
    } else if (id == R.id.nav_material_templates) {
      Intent i = new Intent(BaseActivity.this, MaterialTemplatesActivity.class);
      startActivity(i);
    } else if (id == R.id.nav_material_inventory) {
      Intent i = new Intent(BaseActivity.this, MaterialsActivity.class);
      startActivity(i);
    } else if (id == R.id.nav_product_templates) {
      Intent i = new Intent(BaseActivity.this, ProductTemplatesActivity.class);
      startActivity(i);
    } else if (id == R.id.nav_product_inventory) {

    }

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }
}
