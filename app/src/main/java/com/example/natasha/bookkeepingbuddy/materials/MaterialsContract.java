package com.example.natasha.bookkeepingbuddy.materials;

import android.support.annotation.NonNull;

import com.example.natasha.bookkeepingbuddy.model.Material;
import com.example.natasha.bookkeepingbuddy.model.MaterialTemplate;

import java.util.List;

/**
 * Created by Natasha on 5/26/2017.
 */

public interface MaterialsContract {
  interface View {

    void showAddMaterial();

    void showMaterials(List<Material> categories);

    void showMaterialDetails(Material material);
  }

  interface Presenter {

    void loadMaterials();

    void addNewMaterial();

    void saveNewMaterial(MaterialTemplate template, String attribute);

    void updateMaterial(Material material, String additionalAmount);

    void openMaterialDetails(Material material);
  }

}
