package com.example.natasha.bookkeepingbuddy.materialtemplates;

import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.natasha.bookkeepingbuddy.R;
import com.example.natasha.bookkeepingbuddy.model.MaterialCategory;
import com.example.natasha.bookkeepingbuddy.model.MaterialTemplate;
import com.example.natasha.bookkeepingbuddy.model.data.DBHelper;

import java.util.ArrayList;
import java.util.List;


public class MaterialTemplatesFragment extends Fragment implements MaterialTemplatesContract.View,
AddMaterialTemplateFragment.OnCreateMaterialTemplateListener {
  private MaterialTemplatesContract.Presenter presenter;

  private RecyclerView recView;
  private List<MaterialTemplate> materialTemplates;
  private MaterialTemplatesAdapter adapter;
  private DBHelper dbHelper;

  public MaterialTemplatesFragment() {
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    adapter = new MaterialTemplatesAdapter(materialTemplates, getContext());
    dbHelper = DBHelper.getInstance(getContext());
    presenter = new MaterialTemplatesPresenter(this);
    presenter.loadMaterialTemplates();

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

    recView = (RecyclerView)rootView.findViewById(R.id.material_templates_list);
    recView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
    recView.setAdapter(adapter);

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
  public void showMaterialTemplates(List<MaterialTemplate> materialTemplates) {
    this.materialTemplates = materialTemplates;
    adapter.updateMaterialTemplates(this.materialTemplates);
  }

  @Override
  public void showMaterialTemplateDetails(String categoryId) {

  }

  @Override
  public void OnCreateMaterialTemplateListener(MaterialCategory category, String name, String quantity, String cost) {
    presenter.saveNewMaterialTemplate(category, name, quantity, cost);
  }
}
