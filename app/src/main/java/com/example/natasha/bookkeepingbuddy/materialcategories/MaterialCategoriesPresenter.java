package com.example.natasha.bookkeepingbuddy.materialcategories;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.example.natasha.bookkeepingbuddy.model.MaterialCategory;
import com.example.natasha.bookkeepingbuddy.model.data.DBContract;
import com.example.natasha.bookkeepingbuddy.model.data.DBHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Natasha on 5/26/2017.
 */

public class MaterialCategoriesPresenter implements MaterialCategoriesContract.Presenter {
  private final MaterialCategoriesContract.View categoriesView;
  private List<MaterialCategory> materialCategories;
  private DBHelper dbHelper;
  private SQLiteDatabase writable;
  private SQLiteDatabase readableDB;

  public MaterialCategoriesPresenter(MaterialCategoriesContract.View view,
                                     DBHelper helper) {
    categoriesView = view;
    dbHelper = helper;
    writable = dbHelper.getWritableDatabase();
    readableDB = dbHelper.getReadableDatabase();
    materialCategories = getAllMaterialCategories();
  }

  @Override
  public void addNewMaterialCategory() {
    categoriesView.showAddMaterialCategory();
  }

  @Override
  public void saveNewMaterialCategory(String category, String unit) {
    ContentValues values = new ContentValues();
    values.put(DBContract.MaterialCategoryEntry.COLUMN_NAME, category);
    values.put(DBContract.MaterialCategoryEntry.COLUMN_UNIT, unit);

    writable.insert(DBContract.MaterialCategoryEntry.TABLE_NAME, null, values);
    getAllMaterialCategories();
    categoriesView.showMaterialCategories(materialCategories);
  }

  @Override
  public void loadMaterialCategories() {
    categoriesView.showMaterialCategories(materialCategories);
  }

  @Override
  public void openMaterialCategoryDetails(@NonNull MaterialCategory category) {

  }

  @Override
  public List<MaterialCategory> getAllMaterialCategories() {
    String[] projection = {
            DBContract.MaterialCategoryEntry.COLUMN_NAME,
            DBContract.MaterialCategoryEntry.COLUMN_UNIT
    };

    Cursor cursor = readableDB.query(
            DBContract.MaterialCategoryEntry.TABLE_NAME,
            projection,
            null,
            null,
            null,
            null,
            null,
            null);

    List updatedCategories = new ArrayList<MaterialCategory>();
    while(cursor.moveToNext()) {
      MaterialCategory category = new MaterialCategory(cursor.getString(0), cursor.getString(1));
      updatedCategories.add(category);
    }
    materialCategories = updatedCategories;
    return materialCategories;
  }

}
