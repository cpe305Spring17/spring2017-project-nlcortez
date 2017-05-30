package com.example.natasha.bookkeepingbuddy.materials;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.natasha.bookkeepingbuddy.R;
import com.example.natasha.bookkeepingbuddy.materials.AddMaterialFragment;
import com.example.natasha.bookkeepingbuddy.model.Material;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MaterialsFragment extends Fragment implements MaterialsContract.View {
  private MaterialsContract.UserActionsListener actionsListener;

  public MaterialsFragment() {
  }
  public static MaterialsFragment newInstance() { return new MaterialsFragment(); }



  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    actionsListener = new MaterialsPresenter();
  }

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    setRetainInstance(true);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View rootView;
    rootView = inflater.inflate(R.layout.fragment_materials, container, false);

    FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        FragmentManager manager = getFragmentManager();
        AddMaterialFragment dialog = AddMaterialFragment.newInstance();
        dialog.show(manager,"Material Dialog");

      }
    });

    return rootView;


  }

  @Override
  public void showMaterials(List<Material> categories) {

  }

  @Override
  public void showMaterialDetails(String materialId) {

  }
}
