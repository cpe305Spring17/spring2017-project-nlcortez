package com.example.natasha.bookkeepingbuddy.materialcategories;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.natasha.bookkeepingbuddy.R;
import com.example.natasha.bookkeepingbuddy.model.MaterialCategory;

import java.util.List;

/**
 * Created by Natasha on 5/30/2017.
 */

public class MaterialCategoriesAdapter extends RecyclerView.Adapter<MaterialCategoriesAdapter.MaterialCategoriesAdapterHolder> {
  private List<MaterialCategory> materialCategories;
  private LayoutInflater inflater;

  public MaterialCategoriesAdapter(List<MaterialCategory> materialCategories, Context context) {
    this.inflater = LayoutInflater.from(context);
    this.materialCategories = materialCategories;
  }
  @Override
  public MaterialCategoriesAdapter.MaterialCategoriesAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = inflater.inflate(R.layout.item_material_category, parent, false);

    return new MaterialCategoriesAdapterHolder(view);
  }

  @Override
  public void onBindViewHolder(MaterialCategoriesAdapter.MaterialCategoriesAdapterHolder holder, int position) {
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
