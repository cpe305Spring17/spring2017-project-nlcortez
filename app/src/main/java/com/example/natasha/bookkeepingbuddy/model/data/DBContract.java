package com.example.natasha.bookkeepingbuddy.model.data;

import android.content.ContentValues;
import android.provider.BaseColumns;

import com.example.natasha.bookkeepingbuddy.model.MaterialCategory;

/**
 * Created by Natasha on 5/26/2017.
 */

public final class DBContract {
  public static final String KEY_ID = "id";

  private DBContract() {
  }

  public static final class MaterialCategoryEntry implements BaseColumns {
    public static final String TABLE_NAME = "MaterialCategory";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_UNIT = "unit";

    public static final String CREATE_TABLE =
            "CREATE TABLE " +
                    TABLE_NAME + " (" +
                    _ID + " INTEGER PRIMARY KEY," +
                    COLUMN_NAME + " TEXT NOT NULL UNIQUE, " +
                    COLUMN_UNIT + " TEXT NOT NULL" +
                    "); ";

    public static final String DROP_TABLE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    private MaterialCategoryEntry() {
    }
  }

  public static final class MaterialTemplateEntry implements BaseColumns {
    public static final String TABLE_NAME = "MaterialTemplate";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_CATEGORY = "category";
    public static final String COLUMN_MEAS_QUANTITY = "measuredQuantity";
    public static final String COLUMN_COST = "cost";

    public static final String CREATE_TABLE =
            "CREATE TABLE " +
                    TABLE_NAME + " (" +
                    _ID + " INTEGER PRIMARY KEY," +
                    COLUMN_NAME + " TEXT NOT NULL UNIQUE, " +
                    COLUMN_CATEGORY + " INT REFERENCES MaterialCategory(id), " +
                    COLUMN_MEAS_QUANTITY + " INT NOT NULL, " +
                    COLUMN_COST + " FLOAT NOT NULL" +
                    "); ";

    public static final String DROP_TABLE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    private MaterialTemplateEntry() {
    }

  }

  public static final class MaterialEntry implements BaseColumns {
    public static final String TABLE_NAME = "Material";
    public static final String COLUMN_CUR_QUANTITY = "currentQuantity";
    public static final String COLUMN_TEMPLATE = "template";
    public static final String COLUMN_ATTRIBUTE = "attribute";
    public static final String COLUMN_RUNNING_TOTAL = "runningTotal";

    public static final String CREATE_TABLE =
            "CREATE TABLE " +
                    TABLE_NAME + " (" +
                    _ID + " INTEGER PRIMARY KEY," +
                    COLUMN_CUR_QUANTITY + " INT NOT NULL, " +
                    COLUMN_TEMPLATE + " INT REFERENCES MaterialTemplate(id), " +
                    COLUMN_ATTRIBUTE + " TEXT NOT NULL, " +
                    COLUMN_RUNNING_TOTAL + " INT NOT NULL " +
                    "); ";

    public static final String DROP_TABLE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    private MaterialEntry() {
    }

  }

  public static final class ProductTemplateEntry implements BaseColumns {
    public static final String TABLE_NAME = "ProductTemplate";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PRICE = "price";

    public static final String CREATE_TABLE =
            "CREATE TABLE " +
                    TABLE_NAME + " (" +
                    _ID + " INTEGER PRIMARY KEY," +
                    COLUMN_NAME + " TEXT NOT NULL, " +
                    COLUMN_PRICE + " FLOAT NOT NULL " +
                    "); ";

    public static final String DROP_TABLE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    private ProductTemplateEntry() {
    }
  }

  public static final class ProdTempCompEntry implements BaseColumns {
    public static final String TABLE_NAME = "ProductTemplateComponent";
    public static final String COLUMN_TEMP_ID = "templateId";
    public static final String COLUMN_CATEGORY = "category";
    public static final String COLUMN_QUANTITY = "quantity";

    public static final String CREATE_TABLE =
            "CREATE TABLE " +
                    TABLE_NAME + " (" +
                    COLUMN_TEMP_ID + " INT REFERENCES ProductTemplate(id)," +
                    COLUMN_CATEGORY + " INT REFERENCES Category(id), " +
                    COLUMN_QUANTITY + " INT NOT NULL " +
                    "); ";

    public static final String DROP_TABLE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    private ProdTempCompEntry() {
    }
  }


}
