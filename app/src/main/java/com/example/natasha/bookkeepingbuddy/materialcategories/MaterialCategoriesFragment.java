package com.example.natasha.bookkeepingbuddy.materialcategories;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.natasha.bookkeepingbuddy.R;
import com.example.natasha.bookkeepingbuddy.model.MaterialCategory;

import java.util.List;

/**
 * Created by Natasha on 5/26/2017.
 */

public class MaterialCategoriesFragment extends Fragment implements MaterialCategoriesContract.View {
  private MaterialCategoriesContract.UserActionsListener actionsListener;

  public MaterialCategoriesFragment() {

  }

  public static MaterialCategoriesFragment newInstance() { return new MaterialCategoriesFragment(); }


  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    actionsListener = new MaterialCategoriesPresenter();
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

    FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        FragmentManager manager = getFragmentManager();
        AddMaterialCategoryFragment dialog = AddMaterialCategoryFragment.newInstance("text", "text");
        dialog.show(manager,"Category Dialog");

      }
    });

    return rootView;

  }

  @Override
  public void showMaterialCategories(List<MaterialCategory> categories) {

  }

  @Override
  public void showMaterialCategoryDetails(String categoryId) {

  }
}
