package com.example.natasha.bookkeepingbuddy.materialcategories;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.natasha.bookkeepingbuddy.R;
import com.example.natasha.bookkeepingbuddy.model.MaterialCategory;
import com.example.natasha.bookkeepingbuddy.model.data.DBHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Natasha on 5/26/2017.
 */

public class MaterialCategoriesFragment extends Fragment implements MaterialCategoriesContract.View,
AddMaterialCategoryFragment.OnMaterialCategoryListener {
  private MaterialCategoriesContract.Presenter presenter;

  private RecyclerView recView;
  private List<MaterialCategory> categoriesList;
  private MaterialCategoriesAdapter adapter;
  private DBHelper dbHelper;

  public MaterialCategoriesFragment() {

  }

  public static MaterialCategoriesFragment newInstance() { return new MaterialCategoriesFragment(); }


  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    dbHelper = DBHelper.getInstance(getContext());
    presenter = new MaterialCategoriesPresenter(this, dbHelper);
    categoriesList = presenter.getAllMaterialCategories();
    adapter = new MaterialCategoriesAdapter(categoriesList, getContext());

  }

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    setRetainInstance(true);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootView;
    rootView = inflater.inflate(R.layout.fragment_material_categories, container, false);

    recView = (RecyclerView)rootView.findViewById(R.id.material_categories_list);
    recView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
    recView.setAdapter(adapter);

    FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        presenter.addNewMaterialCategory();

      }
    });

    return rootView;

  }

  @Override
  public void showAddMaterialCategory() {
    FragmentManager manager = getFragmentManager();
    AddMaterialCategoryFragment dialog = AddMaterialCategoryFragment.newInstance();
    dialog.setTargetFragment(this, 0);
    dialog.show(manager,"Category Dialog");
  }

  @Override
  public void showMaterialCategories(List<MaterialCategory> categories) {
    adapter.updateMaterialCategories(categories);
  }

  @Override
  public void showMaterialCategoryDetails(String categoryId) {

  }

  @Override
  public void onCreateMaterialCategory(String category, String unit) {
    presenter.saveNewMaterialCategory(category, unit);
  }
}
