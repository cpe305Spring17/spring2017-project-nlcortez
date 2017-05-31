package com.example.natasha.bookkeepingbuddy.model.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Natasha on 5/26/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
  public static final int DATABASE_VERSION = 1;
  public static final String DATABASE_NAME = "database.db";

  public DBHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }



  @Override
  public void onCreate(SQLiteDatabase db) {
    db.execSQL(DBContract.MaterialCategoryEntry.CREATE_TABLE);
    db.execSQL(DBContract.MaterialTemplateEntry.CREATE_TABLE);
    db.execSQL(DBContract.MaterialEntry.CREATE_TABLE);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL(DBContract.MaterialCategoryEntry.DROP_TABLE);
    db.execSQL(DBContract.MaterialTemplateEntry.DROP_TABLE);
    db.execSQL(DBContract.MaterialEntry.DROP_TABLE);
    onCreate(db);
  }
}
