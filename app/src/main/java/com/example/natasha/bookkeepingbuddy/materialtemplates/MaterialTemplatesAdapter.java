package com.example.natasha.bookkeepingbuddy.materialtemplates;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.natasha.bookkeepingbuddy.R;
import com.example.natasha.bookkeepingbuddy.model.MaterialTemplate;

import java.util.List;

/**
 * Created by Natasha on 6/05/2017.
 */

public class MaterialTemplatesAdapter extends RecyclerView.Adapter<MaterialTemplatesAdapter.MaterialTemplatesAdapterHolder> {
  private List<MaterialTemplate> materialTemplates;
  private LayoutInflater inflater;

  public MaterialTemplatesAdapter(List<MaterialTemplate> materialTemplates, Context context) {
    this.inflater = LayoutInflater.from(context);
    this.materialTemplates = materialTemplates;
  }
  @Override
  public MaterialTemplatesAdapter.MaterialTemplatesAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = inflater.inflate(R.layout.item_material_template, parent, false);

    return new MaterialTemplatesAdapterHolder(view);
  }

  @Override
  public void onBindViewHolder(MaterialTemplatesAdapter.MaterialTemplatesAdapterHolder holder, int position) {
    MaterialTemplate materialTemplate = materialTemplates.get(position);

    holder.name.setText(materialTemplate.getName());
    holder.category.setText(materialTemplate.getCategory().toString());
    holder.measuredQuantity.setText(materialTemplate.getMeasuredQuantity()+"");
    holder.cost.setText(Double.toString(materialTemplate.getCost())+"");

  }

  @Override
  public int getItemCount() {
    return materialTemplates.size();
  }

  public void updateMaterialTemplates(List<MaterialTemplate> materialTemplates) {
    this.materialTemplates = materialTemplates;
    notifyDataSetChanged();
  }

  class MaterialTemplatesAdapterHolder extends  RecyclerView.ViewHolder {
    private TextView name, category, measuredQuantity, cost;

    public MaterialTemplatesAdapterHolder(View itemView) {
      super(itemView);

      name = (TextView)itemView.findViewById(R.id.mat_temp_item_name);
      category = (TextView)itemView.findViewById(R.id.mat_temp_item_cat);
      measuredQuantity = (TextView)itemView.findViewById(R.id.mat_temp_item_quantity);
      cost = (TextView)itemView.findViewById(R.id.mat_temp_item_cost);
    }
  }
}
