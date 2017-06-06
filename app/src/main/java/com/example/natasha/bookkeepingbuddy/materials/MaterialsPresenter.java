package com.example.natasha.bookkeepingbuddy.materials;

import android.support.annotation.NonNull;

import com.example.natasha.bookkeepingbuddy.model.Material;
import com.example.natasha.bookkeepingbuddy.model.MaterialTemplate;
import com.example.natasha.bookkeepingbuddy.model.data.DBQueries;

import java.util.List;

/**
 * Created by Natasha on 5/26/2017.
 */

public class MaterialsPresenter implements MaterialsContract.Presenter {
  private final MaterialsContract.View view;
  private List<Material> materials;

  public MaterialsPresenter(MaterialsContract.View view) {
    this.view = view;
    materials = DBQueries.getAllMaterials();
  }


  @Override
  public void loadMaterials() {
    materials = DBQueries.getAllMaterials();
    view.showMaterials(materials);
  }

  @Override
  public void addNewMaterial() {
    view.showAddMaterial();
  }

  @Override
  public void saveNewMaterial(MaterialTemplate template, String attribute) {
    DBQueries.addMaterial(new Material(template, attribute));
    loadMaterials();
  }

  @Override
  public void openMaterialDetails(Material category) {

  }
}
