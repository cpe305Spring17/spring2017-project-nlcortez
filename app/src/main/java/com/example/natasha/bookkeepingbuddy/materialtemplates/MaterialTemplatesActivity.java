package com.example.natasha.bookkeepingbuddy.materialtemplates;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;

import com.example.natasha.bookkeepingbuddy.BaseActivity;
import com.example.natasha.bookkeepingbuddy.R;
import com.example.natasha.bookkeepingbuddy.materialtemplates.MaterialTemplatesFragment;

public class MaterialTemplatesActivity extends BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_material_templates);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    if (null == savedInstanceState) {
      initFragment(MaterialTemplatesFragment.newInstance());
    }

    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }

  private void initFragment(Fragment templatesFragment) {
    FragmentManager manager = getSupportFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.add(R.id.templatesFrame, templatesFragment);
    transaction.commit();
  }

}
