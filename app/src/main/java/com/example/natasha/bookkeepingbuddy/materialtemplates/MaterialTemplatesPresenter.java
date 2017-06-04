package com.example.natasha.bookkeepingbuddy.materialtemplates;

import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.example.natasha.bookkeepingbuddy.model.Material;
import com.example.natasha.bookkeepingbuddy.model.MaterialCategory;
import com.example.natasha.bookkeepingbuddy.model.MaterialTemplate;
import com.example.natasha.bookkeepingbuddy.model.data.DBHelper;

import java.util.List;

/**
 * Created by Natasha on 5/26/2017.
 */

public class MaterialTemplatesPresenter implements MaterialTemplatesContract.Presenter {
  private final MaterialTemplatesContract.View templatesView;
  private List<MaterialTemplate> materialTemplates;

  public MaterialTemplatesPresenter(MaterialTemplatesContract.View view,
                                     List<MaterialTemplate> list) {
    templatesView = view;
    materialTemplates = list;
  }


  @Override
  public void loadMaterialTemplates(boolean forceUpdate) {

  }

  @Override
  public void addNewMaterialTemplate() {
    templatesView.showAddMaterialTemplate();
  }

  @Override
  public void saveNewMaterialTemplate(String category, String template, String quantity, String cost) {

  }

  @Override
  public void openMaterialTemplateDetails(@NonNull MaterialTemplate category) {

  }
}
