package com.example.natasha.bookkeepingbuddy.presenter;

import com.example.natasha.bookkeepingbuddy.model.MainModel;
import com.example.natasha.bookkeepingbuddy.model.MaterialCategory;
import com.example.natasha.bookkeepingbuddy.model.MaterialTemplate;
import com.example.natasha.bookkeepingbuddy.view.AddMaterialCategoryActivity;

import java.io.Serializable;

/**
 * Created by Natasha on 5/12/2017.
 */

public class AddEntitiesPresenter implements Serializable {
  private AddMaterialCategoryActivity view;
  private MainModel model;

  public AddEntitiesPresenter(AddMaterialCategoryActivity view) {
    this.view = view;
  }

  public void setModel(MainModel model) {
    this.model = model;
  }

  public MainModel getModel() {
    return this.model;
  }

  public void addNewCategory(String name, String unit) {
    MaterialCategory category = new MaterialCategory(name, unit);
    model.addCategory(category);
  }

  public void addNewMaterialTemplate(MaterialCategory category, String name, int quantity, double cost) {
    MaterialTemplate template = new MaterialTemplate(name, category, quantity, cost);
    model.addMaterialTemplate(template);
  }

}
