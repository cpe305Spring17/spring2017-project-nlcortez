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
import com.example.natasha.bookkeepingbuddy.model.MainModel;
import com.example.natasha.bookkeepingbuddy.model.data.BookkeepingContract;
import com.example.natasha.bookkeepingbuddy.model.data.BookkeepingDbHelper;
import com.example.natasha.bookkeepingbuddy.presenter.AddEntitiesPresenter;
import com.example.natasha.bookkeepingbuddy.view.fragment.AddEntitiesFragment;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements Serializable {
  private MainModel mModel;
  private AddEntitiesPresenter mPresenter;
  private Button mBtnAddCategory;
  private Button mBtnAddMaterialTemplate;
  private Button mBtnAddMaterialToInventory;
  private Button mBtnAddProductTemplate;
  private Button mBtnAddProductToInventory;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    mBtnAddCategory = (Button) findViewById(R.id.add_material_cat_button);
    mBtnAddMaterialTemplate = (Button) findViewById(R.id.add_material_template_button);
    mBtnAddMaterialToInventory = (Button) findViewById(R.id.add_material_button);
    mBtnAddProductTemplate = (Button) findViewById(R.id.add_product_template_button);
    mBtnAddProductToInventory = (Button) findViewById(R.id.add_product_button);

    mBtnAddCategory.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick (View v) {
        Intent i = new Intent(MainActivity.this, AddMaterialCategoryActivity.class);
        startActivity(i);
      }
    });

    mBtnAddMaterialTemplate.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick (View v) {
        Intent i = new Intent(MainActivity.this, AddMaterialTemplateActivity.class);
        startActivity(i);
      }
    });

  }


}
