package com.example.natasha.bookkeepingbuddy.model.data;

import android.provider.BaseColumns;

/**
 * Created by Natasha on 5/26/2017.
 */

public final class DatabaseContract {
  public static final int DATABASE_VERSION = 1;
  public static final String DATABASE_NAME = "database.db";
  private static final String KEY_ID = "id";

  private DatabaseContract() {
  }

  public static final class MaterialCategoryEntry implements BaseColumns {
    public static final String TABLE_NAME = "MaterialCategory";
    public static final String COLUMN_CATEGORY_NAME = "name";
    public static final String COLUMN_UNIT = "unit";

    public static final String CREATE_TABLE =
            "CREATE TABLE " +
                    TABLE_NAME + " (" +
                    _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_CATEGORY_NAME + " TEXT NOT NULL, " +
                    COLUMN_UNIT + " TEXT NOT NULL" +
                    "); ";

    public static final String DROP_TABLE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    private MaterialCategoryEntry() {
    }
  }

  public static final class MaterialTemplateEntry implements BaseColumns {
    public static final String TABLE_NAME = "Template";
    public static final String COLUMN_TEMPLATE_NAME = "name";
    public static final String COLUMN_CATEGORY = "category";
    public static final String COLUMN_MEASURED_QUANTITY = "measuredQuantity";
    public static final String COLUMN_COST = "cost";

    public static final String CREATE_TABLE =
            "CREATE TABLE " +
                    TABLE_NAME + " (" +
                    _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_TEMPLATE_NAME + " TEXT NOT NULL, " +
                    COLUMN_CATEGORY + " INT REFERENCES MaterialCategoryEntry, " +
                    COLUMN_MEASURED_QUANTITY + " INT NOT NULL, " +
                    COLUMN_COST + " FLOAT" +
                    "); ";

    public static final String DROP_TABLE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    private MaterialTemplateEntry() {
    }


  }

}
