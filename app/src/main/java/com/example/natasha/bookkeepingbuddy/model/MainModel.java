package com.example.natasha.bookkeepingbuddy.model;

import com.example.natasha.bookkeepingbuddy.presenter.AddEntitiesPresenter;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Natasha on 5/12/2017.
 */

public class MainModel implements Serializable {
  private AddEntitiesPresenter presenter;
  private ArrayList<MaterialCategory> categories = new ArrayList<MaterialCategory>();
  private ArrayList<MaterialTemplate> materialTemplates = new ArrayList<MaterialTemplate>();
  private ArrayList<Material> materials = new ArrayList<Material>();

  public MainModel(AddEntitiesPresenter presenter) {
    this.presenter = presenter;
  }

  public void addCategory(MaterialCategory category) {
    categories.add(category);
  }

  public void addMaterialTemplate(MaterialTemplate template) {
    materialTemplates.add(template);
  }
}
