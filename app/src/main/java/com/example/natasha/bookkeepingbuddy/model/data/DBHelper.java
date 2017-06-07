package com.example.natasha.bookkeepingbuddy.model.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Natasha on 5/26/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
  public static final int DATABASE_VERSION = 3;
  public static final String DATABASE_NAME = "testdb01.db";
  private static DBHelper instance;

  private DBHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  public static DBHelper getInstance() {
    return instance;
  }

  public static synchronized  DBHelper getInstance(Context context) {
    if (instance == null) {
      instance = new DBHelper(context);
    }
    return instance;
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    db.execSQL(DBContract.MaterialCategoryEntry.CREATE_TABLE);
    db.execSQL(DBContract.MaterialTemplateEntry.CREATE_TABLE);
    db.execSQL(DBContract.MaterialEntry.CREATE_TABLE);
    db.execSQL(DBContract.ProductTemplateEntry.CREATE_TABLE);
    db.execSQL(DBContract.ProdTempCompEntry.CREATE_TABLE);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL(DBContract.MaterialCategoryEntry.DROP_TABLE);
    db.execSQL(DBContract.MaterialTemplateEntry.DROP_TABLE);
    db.execSQL(DBContract.MaterialEntry.DROP_TABLE);
    db.execSQL(DBContract.ProductTemplateEntry.DROP_TABLE);
    db.execSQL(DBContract.ProdTempCompEntry.DROP_TABLE);
    onCreate(db);
  }
}
