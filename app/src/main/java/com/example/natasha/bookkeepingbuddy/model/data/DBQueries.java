package com.example.natasha.bookkeepingbuddy.model.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.natasha.bookkeepingbuddy.model.Material;
import com.example.natasha.bookkeepingbuddy.model.MaterialCategory;
import com.example.natasha.bookkeepingbuddy.model.MaterialTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Natasha on 6/2/2017.
 */

public class DBQueries {
  private static DBHelper dbHelper = DBHelper.getInstance();
  private static SQLiteDatabase writableDB = dbHelper.getWritableDatabase();
  private static SQLiteDatabase readableDB = dbHelper.getReadableDatabase();

  /* Material Categories Queries */
  public static List getAllMaterialCategories() {
    String[] projection = {
            DBContract.MaterialCategoryEntry._ID,
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
    while (cursor.moveToNext()) {
      MaterialCategory category = new MaterialCategory(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2));
      updatedCategories.add(category);
    }
    return updatedCategories;
  }

  public static long addMaterialCategory(MaterialCategory materialCategory) {
    ContentValues values = new ContentValues();
    values.put(DBContract.MaterialCategoryEntry.COLUMN_NAME, materialCategory.getName());
    values.put(DBContract.MaterialCategoryEntry.COLUMN_UNIT, materialCategory.getUnit());

    long id = writableDB.insert(DBContract.MaterialCategoryEntry.TABLE_NAME, null, values);
    materialCategory.setId((int) id);
    return id;
  }

  public static MaterialCategory getMaterialCategory(int id) {
    MaterialCategory materialCategory = null;
    String[] projection = {
            DBContract.MaterialCategoryEntry.COLUMN_NAME,
            DBContract.MaterialCategoryEntry.COLUMN_UNIT
    };

    String whereClause = "_ID=?";
    String[] args = {Integer.toString(id)};

    Cursor cursor = readableDB.query(
            DBContract.MaterialCategoryEntry.TABLE_NAME,
            projection,
            whereClause,
            args,
            null,
            null,
            null,
            null);

    while (cursor.moveToNext()) {
      materialCategory = new MaterialCategory(id, cursor.getString(0), cursor.getString(1));
    }
    return materialCategory;
  }

//  public static void updateMaterialCategory(int id) {
//    ContentValues values = new ContentValues();
//    //values.put(DBContract.MaterialCategoryEntry.COLUMN_NAME, materialCategory.getName());
//    //values.put(DBContract.MaterialCategoryEntry.COLUMN_UNIT, materialCategory.getUnit());
//
//    writableDB.update(DBContract.MaterialCategoryEntry.TABLE_NAME, values, "_ID="+id, null);
//
//  }

  /* Material Templates Queries */
  public static List getAllMaterialTemplates() {
    String[] projection = {
            DBContract.MaterialTemplateEntry.COLUMN_CATEGORY,
            DBContract.MaterialTemplateEntry._ID,
            DBContract.MaterialTemplateEntry.COLUMN_NAME,
            DBContract.MaterialTemplateEntry.COLUMN_MEAS_QUANTITY,
            DBContract.MaterialTemplateEntry.COLUMN_COST
    };

    Cursor cursor = readableDB.query(
            DBContract.MaterialTemplateEntry.TABLE_NAME,
            projection,
            null,
            null,
            null,
            null,
            null,
            null);

    List updatedMaterialTemplates = new ArrayList<MaterialTemplate>();
    while (cursor.moveToNext()) {
      MaterialCategory materialCategory = DBQueries.getMaterialCategory(cursor.getInt(0));

      if (null != materialCategory) {
        MaterialTemplate materialTemplate = new MaterialTemplate(cursor.getInt(1), cursor.getString(2), materialCategory, cursor.getInt(3), cursor.getDouble(4));
        updatedMaterialTemplates.add(materialTemplate);
      }
    }
    return updatedMaterialTemplates;
  }

  public static long addMaterialTemplate(MaterialTemplate materialTemplate) {
    ContentValues values = new ContentValues();
    values.put(DBContract.MaterialTemplateEntry.COLUMN_NAME, materialTemplate.getName());
    values.put(DBContract.MaterialTemplateEntry.COLUMN_CATEGORY, materialTemplate.getCategory().getId());
    values.put(DBContract.MaterialTemplateEntry.COLUMN_MEAS_QUANTITY, materialTemplate.getMeasuredQuantity());
    values.put(DBContract.MaterialTemplateEntry.COLUMN_COST, materialTemplate.getCost());

    long id = writableDB.insert(DBContract.MaterialTemplateEntry.TABLE_NAME, null, values);
    materialTemplate.setId((int) id);
    return id;
  }

  public static MaterialTemplate getMaterialTemplate(int id) {
    MaterialTemplate materialTemplate = null;
    String[] projection = {
            DBContract.MaterialTemplateEntry.COLUMN_CATEGORY,
            DBContract.MaterialTemplateEntry.COLUMN_NAME,
            DBContract.MaterialTemplateEntry.COLUMN_MEAS_QUANTITY,
            DBContract.MaterialTemplateEntry.COLUMN_COST
    };

    String whereClause = "_ID=?";
    String[] args = {Integer.toString(id)};

    Cursor cursor = readableDB.query(
            DBContract.MaterialTemplateEntry.TABLE_NAME,
            projection,
            whereClause,
            args,
            null,
            null,
            null,
            null);

    while (cursor.moveToNext()) {
      MaterialCategory materialCategory = DBQueries.getMaterialCategory(cursor.getInt(0));

      if (null != materialCategory) {
        materialTemplate = new MaterialTemplate(id, cursor.getString(1), materialCategory, cursor.getInt(2), cursor.getDouble(3));
      }
    }

    return materialTemplate;
  }

  /* Material Queries */
  public static List getAllMaterials() {
    String[] projection = {
            DBContract.MaterialEntry.COLUMN_TEMPLATE,
            DBContract.MaterialEntry._ID,
            DBContract.MaterialEntry.COLUMN_ATTRIBUTE,
            DBContract.MaterialEntry.COLUMN_CUR_QUANTITY,
            DBContract.MaterialEntry.COLUMN_RUNNING_TOTAL
    };

    Cursor cursor = readableDB.query(
            DBContract.MaterialEntry.TABLE_NAME,
            projection,
            null,
            null,
            null,
            null,
            null,
            null);

    List updatedMaterials = new ArrayList<Material>();
    while (cursor.moveToNext()) {
      MaterialTemplate materialTemplate = DBQueries.getMaterialTemplate(cursor.getInt(0));

      if (null != materialTemplate) {
        Material material = new Material(cursor.getInt(1), materialTemplate, cursor.getString(2), cursor.getInt(3), cursor.getInt(4));
        updatedMaterials.add(material);
      }
    }
    return updatedMaterials;
  }

  public static long addMaterial(Material material) {
    ContentValues values = new ContentValues();
    values.put(DBContract.MaterialEntry.COLUMN_TEMPLATE, material.getMaterialTemplate().getId());
    values.put(DBContract.MaterialEntry.COLUMN_ATTRIBUTE, material.getAttribute());
    values.put(DBContract.MaterialEntry.COLUMN_CUR_QUANTITY, material.getCurrentQuantity());
    values.put(DBContract.MaterialEntry.COLUMN_RUNNING_TOTAL, material.getRunningTotal());

    long id = writableDB.insert(DBContract.MaterialEntry.TABLE_NAME, null, values);
    material.setId((int) id);
    return id;
  }

  public static Material getMaterial(int id) {
    Material material = null;
    String[] projection = {
            DBContract.MaterialEntry.COLUMN_TEMPLATE,
            DBContract.MaterialEntry._ID,
            DBContract.MaterialEntry.COLUMN_ATTRIBUTE,
            DBContract.MaterialEntry.COLUMN_CUR_QUANTITY,
            DBContract.MaterialEntry.COLUMN_RUNNING_TOTAL
    };

    String whereClause = "_ID=?";
    String[] args = {Integer.toString(id)};

    Cursor cursor = readableDB.query(
            DBContract.MaterialEntry.TABLE_NAME,
            projection,
            whereClause,
            args,
            null,
            null,
            null,
            null);

    while (cursor.moveToNext()) {
      MaterialTemplate materialTemplate = DBQueries.getMaterialTemplate(cursor.getInt(0));

      if (null != materialTemplate) {
        material = new Material(cursor.getInt(1), materialTemplate, cursor.getString(2), cursor.getInt(3), cursor.getInt(4));
      }
    }

    return material;
  }

  public static void updateMaterial(Material material, int additionalAmount) {
    ContentValues values = new ContentValues();
    values.put(DBContract.MaterialEntry.COLUMN_CUR_QUANTITY, material.getCurrentQuantity() + additionalAmount);
    values.put(DBContract.MaterialEntry.COLUMN_RUNNING_TOTAL, material.getRunningTotal() + additionalAmount);

    writableDB.update(DBContract.MaterialEntry.TABLE_NAME, values, "_ID=" + material.getId(), null);
  }

}
