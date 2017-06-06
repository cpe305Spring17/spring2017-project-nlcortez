package com.example.natasha.bookkeepingbuddy.materials;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.natasha.bookkeepingbuddy.R;
import com.example.natasha.bookkeepingbuddy.model.Material;

import java.util.List;

/**
 * Created by Natasha on 6/6/2017.
 */

public class MaterialsAdapter extends RecyclerView.Adapter<MaterialsAdapter.MaterialsAdapterHolder> {
  private List<Material> materials;
  private LayoutInflater inflater;

  public MaterialsAdapter(List<Material> materials, Context context) {
    this.inflater = LayoutInflater.from(context);
    this.materials = materials;
  }
  @Override
  public MaterialsAdapter.MaterialsAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = inflater.inflate(R.layout.item_material, parent, false);

    return new MaterialsAdapterHolder(view);
  }

  @Override
  public void onBindViewHolder(MaterialsAdapter.MaterialsAdapterHolder holder, int position) {
    Material material = materials.get(position);

    holder.name.setText(material.getAttribute() + " " + material.getMaterialTemplate().getCategory().toString());
    holder.template.setText(material.getMaterialTemplate().getName());
    holder.curQuantity.setText(material.getCurrentQuantity()+"");
  }

  @Override
  public int getItemCount() {
    return materials.size();
  }

  public void updateMaterials(List<Material> materials) {
    this.materials = materials;
    notifyDataSetChanged();
  }

  class MaterialsAdapterHolder extends  RecyclerView.ViewHolder {
    private TextView name, template, curQuantity;

    public MaterialsAdapterHolder(View itemView) {
      super(itemView);

      name = (TextView)itemView.findViewById(R.id.material_item_name);
      template = (TextView)itemView.findViewById(R.id.material_item_template);
      curQuantity = (TextView)itemView.findViewById(R.id.material_item_quantity);
    }
  }
}
