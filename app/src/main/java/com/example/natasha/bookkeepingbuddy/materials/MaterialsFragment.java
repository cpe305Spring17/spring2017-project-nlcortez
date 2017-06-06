package com.example.natasha.bookkeepingbuddy.materials;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.natasha.bookkeepingbuddy.R;
import com.example.natasha.bookkeepingbuddy.model.Material;
import com.example.natasha.bookkeepingbuddy.model.MaterialTemplate;
import com.example.natasha.bookkeepingbuddy.model.data.DBHelper;

import java.util.List;

public class MaterialsFragment extends Fragment implements MaterialsContract.View, AddMaterialFragment.OnCreateMaterialTemplateListener {
  private MaterialsContract.Presenter presenter;

  private RecyclerView recView;
  private List<Material> materials;
  private MaterialsAdapter adapter;
  private DBHelper dbHelper;

  public MaterialsFragment() {
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    adapter = new MaterialsAdapter(materials, getContext());
    dbHelper = DBHelper.getInstance(getContext());
    presenter = new MaterialsPresenter(this);
    presenter.loadMaterials();

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

    recView = (RecyclerView)rootView.findViewById(R.id.materials_list);
    recView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
    recView.setAdapter(adapter);

    FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        presenter.addNewMaterial();
      }
    });

    return rootView;
  }

  @Override
  public void showAddMaterial() {
    FragmentManager manager = getFragmentManager();
    AddMaterialFragment dialog = AddMaterialFragment.newInstance();
    dialog.setTargetFragment(this, 0);
    dialog.show(manager,"Template Dialog");
  }

  @Override
  public void showMaterials(List<Material> materials) {
    this.materials = materials;
    adapter.updateMaterials(this.materials);
  }

  @Override
  public void showMaterialDetails(String materialId) {

  }

  @Override
  public void OnCreateMaterialListener(MaterialTemplate template, String attribute) {
    presenter.saveNewMaterial(template, attribute);
  }

}
