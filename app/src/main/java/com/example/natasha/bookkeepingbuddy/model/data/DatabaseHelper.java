package com.example.natasha.bookkeepingbuddy.model.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Natasha on 5/26/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

  public DatabaseHelper(Context context) {
    super(context, DatabaseContract.DATABASE_NAME, null, DatabaseContract.DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    db.execSQL(DatabaseContract.MaterialCategoryEntry.CREATE_TABLE);
    db.execSQL(DatabaseContract.MaterialTemplateEntry.CREATE_TABLE);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL(DatabaseContract.MaterialCategoryEntry.DROP_TABLE);
    db.execSQL(DatabaseContract.MaterialTemplateEntry.DROP_TABLE);
    onCreate(db);
  }
}
