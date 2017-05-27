package com.example.natasha.bookkeepingbuddy.materialtemplates;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.natasha.bookkeepingbuddy.R;
import com.example.natasha.bookkeepingbuddy.model.MaterialTemplate;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MaterialTemplatesFragment extends Fragment implements MaterialTemplatesContract.View {

  public MaterialTemplatesFragment() {
  }

  public static MaterialTemplatesFragment newInstance() { return new MaterialTemplatesFragment(); }


  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    setRetainInstance(true);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootView;
    rootView = inflater.inflate(R.layout.fragment_material_templates, container, false);

    FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        FragmentManager manager = getFragmentManager();
        AddMaterialTemplateFragment dialog = AddMaterialTemplateFragment.newInstance("text", "text", "text", "text");
        dialog.show(manager,"Category Dialog");

      }
    });

    return rootView;

  }

  @Override
  public void showMaterialTemplates(List<MaterialTemplate> categories) {

  }

  @Override
  public void showMaterialTemplateDetails(String categoryId) {

  }
}
