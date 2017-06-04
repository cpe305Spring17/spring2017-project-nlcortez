package com.example.natasha.bookkeepingbuddy.materialcategories;

import android.support.annotation.NonNull;

import com.example.natasha.bookkeepingbuddy.model.MaterialCategory;

import java.util.List;

/**
 * Created by Natasha on 5/26/2017.
 */

public interface MaterialCategoriesContract {
  interface View {
    void showAddMaterialCategory();

    void showMaterialCategories(List<MaterialCategory> categories);

    void showMaterialCategoryDetails(String categoryId);
  }

  interface Presenter {
    void loadMaterialCategories();

    void addNewMaterialCategory();

    void saveNewMaterialCategory(String category, String unit);

    void openMaterialCategoryDetails(@NonNull MaterialCategory category);

    List<MaterialCategory> getAllMaterialCategories();

  }

}
