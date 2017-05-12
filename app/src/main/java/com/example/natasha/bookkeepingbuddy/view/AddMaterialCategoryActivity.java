package com.example.natasha.bookkeepingbuddy.view;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
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

import java.io.Serializable;

public class AddMaterialCategoryActivity extends AppCompatActivity {

  private AddEntitiesPresenter mPresenter;
  private EditText mNewCategoryNameEditText;
  private EditText mNewUnitEditText;
  private Button mBtnAddCategory;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_material_category);

    setupMVP();

    mNewCategoryNameEditText = (EditText) findViewById(R.id.cat_name_edit_text);
    mNewUnitEditText = (EditText) findViewById(R.id.cat_unit_edit_text);
    mBtnAddCategory = (Button) findViewById(R.id.save_button);

    addToBook();
  }

  public void addToBook() {
    mBtnAddCategory.setOnClickListener(
            new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                String category = mNewCategoryNameEditText.getText().toString();
                String unit = mNewUnitEditText.getText().toString();

                mPresenter.addNewCategory(category, unit);

                Toast.makeText(AddMaterialCategoryActivity.this,
                        R.string.category_added_toast,
                        Toast.LENGTH_SHORT).show();
              }
            }
    );
  }


  private int addNewCategory(String name, String unit) {
    return 0;
    /* ContentValues cv = new ContentValues();

    cv.put(BookkeepingContract.CategoryEntry.COLUMN_CATEGORY_NAME, name);
    cv.put(BookkeepingContract.CategoryEntry.COLUMN_UNIT, unit);

    return bookkeepingDB.insert(BookkeepingContract.CategoryEntry.TABLE_NAME, null, cv); */
  }
  private void setupMVP() {
    mPresenter = new AddEntitiesPresenter(this);
    MainModel model = new MainModel(mPresenter);
    mPresenter.setModel(model);
  }

}
