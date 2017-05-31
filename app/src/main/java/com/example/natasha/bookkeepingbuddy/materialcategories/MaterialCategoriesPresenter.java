package com.example.natasha.bookkeepingbuddy.materialcategories;

import android.content.ContentValues;
import android.content.Context;
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

public class MaterialCategoriesPresenter implements MaterialCategoriesContract.UserActionsListener {
  private final MaterialCategoriesContract.View categoriesView;
  private List<MaterialCategory> materialCategories;
  private DBHelper dbHelper;
  private SQLiteDatabase writable;
  private SQLiteDatabase readableDB;

  public MaterialCategoriesPresenter(MaterialCategoriesContract.View view,
                                     List<MaterialCategory> list,
                                     DBHelper helper) {
    categoriesView = view;
    materialCategories = list;
    dbHelper = helper;
    writable = dbHelper.getWritableDatabase();
    readableDB = dbHelper.getReadableDatabase();
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
  public void loadMaterialCategories(boolean forceUpdate) {
    categoriesView.showMaterialCategories(materialCategories);
  }

  @Override
  public void openMaterialCategoryDetails(@NonNull MaterialCategory category) {

  }

  private List<MaterialCategory> getAllMaterialCategories() {
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
      MaterialCategory category = new MaterialCategory(cursor.getString(1), cursor.getString(1));
      updatedCategories.add(category);
    }
    materialCategories = updatedCategories;
    return materialCategories;
  }

}
