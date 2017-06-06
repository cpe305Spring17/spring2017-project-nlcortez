package com.example.natasha.bookkeepingbuddy.materialcategories;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.example.natasha.bookkeepingbuddy.model.MaterialCategory;
import com.example.natasha.bookkeepingbuddy.model.data.DBContract;
import com.example.natasha.bookkeepingbuddy.model.data.DBHelper;
import com.example.natasha.bookkeepingbuddy.model.data.DBQueries;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Natasha on 5/26/2017.
 */

public class MaterialCategoriesPresenter implements MaterialCategoriesContract.Presenter {
  private final MaterialCategoriesContract.View view;
  private List<MaterialCategory> materialCategories;

  public MaterialCategoriesPresenter(MaterialCategoriesContract.View view) {
    this.view = view;
    materialCategories = DBQueries.getAllMaterialCategories();
  }

  @Override
  public void addNewMaterialCategory() {
    view.showAddMaterialCategory();
  }

  @Override
  public void saveNewMaterialCategory(String category, String unit) {
    DBQueries.addMaterialCategory(new MaterialCategory(category,unit));
    loadMaterialCategories();
  }

  @Override
  public void loadMaterialCategories() {
    materialCategories = DBQueries.getAllMaterialCategories();
    view.showMaterialCategories(materialCategories);
  }

  @Override
  public void openMaterialCategoryDetails(@NonNull MaterialCategory category) {

  }

}
