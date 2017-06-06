package com.example.natasha.bookkeepingbuddy.materialcategories;

import android.content.Context;
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
import android.widget.TextView;

import com.example.natasha.bookkeepingbuddy.R;
import com.example.natasha.bookkeepingbuddy.model.MaterialCategory;
import com.example.natasha.bookkeepingbuddy.model.data.DBHelper;

import java.util.List;

/**
 * Created by Natasha on 5/26/2017.
 */

public class MaterialCategoriesFragment extends Fragment implements MaterialCategoriesContract.View,
AddMaterialCategoryFragment.OnMaterialCategoryListener {
  private MaterialCategoriesContract.Presenter presenter;

  private RecyclerView recView;
  private List<MaterialCategory> materialCategories;
  private MaterialCategoriesAdapter adapter;
  private DBHelper dbHelper;

  public MaterialCategoriesFragment() {
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    adapter = new MaterialCategoriesAdapter(materialCategories, getContext());
    dbHelper = DBHelper.getInstance(getContext());
    presenter = new MaterialCategoriesPresenter(this);
    presenter.loadMaterialCategories();
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
    AddMaterialCategoryFragment dialog = new AddMaterialCategoryFragment();
    dialog.setTargetFragment(this, 0);
    dialog.show(manager,"Category Dialog");
  }

  @Override
  public void showMaterialCategories(List<MaterialCategory> materialCategories) {
    this.materialCategories = materialCategories;
    adapter.updateMaterialCategories(this.materialCategories);
  }

  @Override
  public void showMaterialCategoryDetails(String categoryId) {

  }

  /**
   * Created by Natasha on 5/30/2017.
   */

  private static class MaterialCategoriesAdapter extends RecyclerView.Adapter<MaterialCategoriesAdapter.MaterialCategoriesAdapterHolder> {
    private List<MaterialCategory> materialCategories;
    private LayoutInflater inflater;

    public MaterialCategoriesAdapter(List<MaterialCategory> materialCategories, Context context) {
      this.inflater = LayoutInflater.from(context);
      this.materialCategories = materialCategories;
    }
    @Override
    public MaterialCategoriesAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View view = inflater.inflate(R.layout.item_material_category, parent, false);

      return new MaterialCategoriesAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(MaterialCategoriesAdapterHolder holder, int position) {
      MaterialCategory category = materialCategories.get(position);

      holder.category.setText(category.getName());
      holder.unit.setText(category.getUnit());
    }

    @Override
    public int getItemCount() {
      return materialCategories.size();
    }

    public void updateMaterialCategories(List<MaterialCategory> materialCategories) {

      this.materialCategories = materialCategories;
      notifyDataSetChanged();
    }

    class MaterialCategoriesAdapterHolder extends RecyclerView.ViewHolder {
      private TextView category;
      private TextView unit;

      public MaterialCategoriesAdapterHolder(View itemView) {
        super(itemView);

        category = (TextView)itemView.findViewById(R.id.mat_cat_category);
        unit = (TextView)itemView.findViewById(R.id.mat_cat_unit);

        itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

          }
        });
      }
    }
  }

  @Override
  public void onCreateMaterialCategory(String category, String unit) {
    presenter.saveNewMaterialCategory(category, unit);
  }

}
