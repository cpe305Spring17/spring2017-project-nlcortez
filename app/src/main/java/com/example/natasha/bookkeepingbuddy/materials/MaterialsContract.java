package com.example.natasha.bookkeepingbuddy.materials;

import android.support.annotation.NonNull;

import com.example.natasha.bookkeepingbuddy.model.Material;

import java.util.List;

/**
 * Created by Natasha on 5/26/2017.
 */

public interface MaterialsContract {
  interface View {

    void showMaterials(List<Material> categories);

    void showMaterialDetails(String materialId);
  }

  interface UserActionsListener {
    void loadMaterials(boolean forceUpdate);

    void addNewMaterial();

    void openMaterialDetails(@NonNull Material category);
  }

}
