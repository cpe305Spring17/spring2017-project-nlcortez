package com.example.natasha.bookkeepingbuddy.materialtemplates;

import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.natasha.bookkeepingbuddy.R;
import com.example.natasha.bookkeepingbuddy.model.MaterialTemplate;
import com.example.natasha.bookkeepingbuddy.model.data.DBHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MaterialTemplatesFragment extends Fragment implements MaterialTemplatesContract.View,
AddMaterialTemplateFragment.OnCreateMaterialTemplateListener {
  private MaterialTemplatesContract.Presenter presenter;
  private RecyclerView recView;
  private List<MaterialTemplate> templatesList;
  private DBHelper dbHelper;

  public MaterialTemplatesFragment() {
  }

  public static MaterialTemplatesFragment newInstance() { return new MaterialTemplatesFragment(); }


  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    presenter = new MaterialTemplatesPresenter(this, templatesList);
    templatesList = new ArrayList<MaterialTemplate>();
    DBHelper.getInstance(this.getContext());
  }

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
        presenter.addNewMaterialTemplate();
      }
    });

    return rootView;

  }

  @Override
  public void showAddMaterialTemplate() {
    FragmentManager manager = getFragmentManager();
    AddMaterialTemplateFragment dialog = AddMaterialTemplateFragment.newInstance();
    dialog.setTargetFragment(this, 0);
    dialog.show(manager,"Template Dialog");
  }


  @Override
  public void showMaterialTemplates(List<MaterialTemplate> categories) {

  }

  @Override
  public void showMaterialTemplateDetails(String categoryId) {

  }

  @Override
  public void OnCreateMaterialTemplateListener(String category, String template, String quantity, String cost) {
    presenter.saveNewMaterialTemplate(category, template,quantity,cost);
  }
}
