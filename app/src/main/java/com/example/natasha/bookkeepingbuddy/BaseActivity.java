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
import com.example.natasha.bookkeepingbuddy.materialcategories.MaterialCategoriesActivity;
import com.example.natasha.bookkeepingbuddy.materials.MaterialsActivity;
import com.example.natasha.bookkeepingbuddy.materialtemplates.MaterialTemplatesActivity;
import com.example.natasha.bookkeepingbuddy.model.Material;
import com.example.natasha.bookkeepingbuddy.model.MaterialCategory;
import com.example.natasha.bookkeepingbuddy.model.data.DBHelper;
import com.example.natasha.bookkeepingbuddy.model.data.DBQueries;
import com.example.natasha.bookkeepingbuddy.producttemplates.ProductTemplatesActivity;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

  private PieChart chart;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_base);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    toggle.syncState();

    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);

    DBHelper.getInstance(this);
    chart = (PieChart) findViewById(R.id.chart);
    updateChart();
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
    }

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }

  public void updateChart() {
    ArrayList<PieEntry> entries = new ArrayList<>();
    List<MaterialCategory> materialCategories = DBQueries.getAllMaterialCategories();
    List<Material> materials = DBQueries.getAllMaterials();

    for (int i = 0; i < materialCategories.size(); i++) {
      MaterialCategory curCategory = materialCategories.get(i);
      List<Material> remove = new ArrayList<>();
      double sum = 0;

      for (int j = 0; j < materials.size(); j++) {
        Material material = materials.get(j);
        if (material.getMaterialTemplate().getCategory().getId() == curCategory.getId()) {
          sum += ((double)materials.get(j).getRunningTotal() / (double)material.getMaterialTemplate().getMeasuredQuantity() * material.getMaterialTemplate().getCost());
          remove.add(material);
        }
      }
      entries.add(new PieEntry((float)sum, curCategory.toString()));
    }

    PieDataSet dataset = new PieDataSet(entries, "material categories");
    dataset.setColors(ColorTemplate.PASTEL_COLORS);
    PieData data = new PieData(dataset);
    chart.setData(data);

    Legend legend = chart.getLegend();
    legend.setPosition(Legend.LegendPosition.RIGHT_OF_CHART_CENTER);
    legend.setTextSize(25);

    Description description = new Description();
    description.setText("amounts of money spent on each material category to date");
    chart.setDescription(description);
    chart.invalidate();
  }

}
