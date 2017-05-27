package com.example.natasha.bookkeepingbuddy.materials;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.natasha.bookkeepingbuddy.R;
import com.example.natasha.bookkeepingbuddy.model.Material;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MaterialsActivityFragment extends Fragment implements MaterialsContract.View {

  public MaterialsActivityFragment() {
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_materials, container, false);
  }

  @Override
  public void showMaterials(List<Material> categories) {
    
  }

  @Override
  public void showMaterialDetails(String materialId) {

  }
}
