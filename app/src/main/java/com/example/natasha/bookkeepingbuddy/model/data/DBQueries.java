package com.example.natasha.bookkeepingbuddy.model.data;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.natasha.bookkeepingbuddy.model.MaterialCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Natasha on 6/2/2017.
 */

public class DBQueries {
  private static DBHelper dbHelper = DBHelper.getInstance();
  private static SQLiteDatabase writableDB = dbHelper.getWritableDatabase();
  private static SQLiteDatabase readableDB = dbHelper.getReadableDatabase();

  public static List getAllMaterialCategories() {
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
    return updatedCategories;
  }

  public static ArrayList<String> getAllMaterialCategoryStrings() {
    String[] projection = {
            DBContract.MaterialCategoryEntry.COLUMN_NAME
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

    ArrayList<String> materialCategoryNames = new ArrayList<String>();

    while(cursor.moveToNext()) {
      materialCategoryNames.add(cursor.getString(0));
    }
    return materialCategoryNames;
  }

}
