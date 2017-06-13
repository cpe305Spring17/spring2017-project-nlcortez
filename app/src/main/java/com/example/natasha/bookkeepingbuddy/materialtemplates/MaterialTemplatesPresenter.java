package com.example.natasha.bookkeepingbuddy.materialtemplates;

import com.example.natasha.bookkeepingbuddy.model.MaterialCategory;
import com.example.natasha.bookkeepingbuddy.model.MaterialTemplate;
import com.example.natasha.bookkeepingbuddy.model.data.DBQueries;

import java.util.List;

/**
 * Created by Natasha on 5/26/2017.
 */

public class MaterialTemplatesPresenter implements MaterialTemplatesContract.Presenter {
  private final MaterialTemplatesContract.View view;
  private List<MaterialTemplate> materialTemplates;

  public MaterialTemplatesPresenter(MaterialTemplatesContract.View view) {
    this.view = view;
    materialTemplates = DBQueries.getAllMaterialTemplates();
  }

  @Override
  public void loadMaterialTemplates() {
    materialTemplates = DBQueries.getAllMaterialTemplates();
    view.showMaterialTemplates(materialTemplates);
  }

  @Override
  public void addNewMaterialTemplate() {
    view.showAddMaterialTemplate();
  }

  @Override
  public void saveNewMaterialTemplate(MaterialCategory category, String name, String quantity, String cost) {
    DBQueries.addMaterialTemplate(new MaterialTemplate(name, category, Integer.parseInt(quantity), Double.parseDouble(cost)));
    loadMaterialTemplates();
  }

  @Override
  public void openMaterialTemplateDetails(MaterialTemplate materialTemplate) {
    // TO-DO
  }
}
