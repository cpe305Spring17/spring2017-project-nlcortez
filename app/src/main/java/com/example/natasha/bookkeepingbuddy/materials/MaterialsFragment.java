package com.example.natasha.bookkeepingbuddy.materials;

import android.content.Context;
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
import android.widget.TextView;

import com.example.natasha.bookkeepingbuddy.R;
import com.example.natasha.bookkeepingbuddy.model.Material;
import com.example.natasha.bookkeepingbuddy.model.MaterialTemplate;
import com.example.natasha.bookkeepingbuddy.model.data.DBHelper;

import java.util.List;

public class MaterialsFragment extends Fragment implements MaterialsContract.View, AddMaterialFragment.OnCreateMaterialTemplateListener, EditMaterialFragment.OnEditMaterialListener {
  private static MaterialsContract.Presenter presenter;

  private List<Material> materials;
  private MaterialsAdapter adapter;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    adapter = new MaterialsAdapter(materials, getContext());
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
    RecyclerView recView;

    rootView = inflater.inflate(R.layout.fragment_materials, container, false);

    recView = (RecyclerView) rootView.findViewById(R.id.materials_list);
    recView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
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
    dialog.show(manager, "Material Dialog");
  }

  @Override
  public void showMaterials(List<Material> materials) {
    this.materials = materials;
    adapter.updateMaterials(this.materials);
  }

  @Override
  public void showMaterialDetails(Material material) {
    FragmentManager manager = getFragmentManager();
    EditMaterialFragment dialog = EditMaterialFragment.newInstance(material);
    dialog.setTargetFragment(this, 0);
    dialog.show(manager, "Edit Material Dialog Dialog");
  }

  private static class MaterialsAdapter extends RecyclerView.Adapter<MaterialsAdapter.MaterialsAdapterHolder> {
    private List<Material> materials;
    private LayoutInflater inflater;

    public MaterialsAdapter(List<Material> materials, Context context) {
      this.inflater = LayoutInflater.from(context);
      this.materials = materials;
    }

    @Override
    public MaterialsAdapter.MaterialsAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View view = inflater.inflate(R.layout.item_material, parent, false);

      return new MaterialsAdapter.MaterialsAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(MaterialsAdapter.MaterialsAdapterHolder holder, int position) {
      final Material material = materials.get(position);

      holder.name.setText(material.getAttribute() + " " + material.getMaterialTemplate().getCategory().toString());
      holder.template.setText(material.getMaterialTemplate().getName());
      holder.curQuantity.setText(material.curQuantityText());

      holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          presenter.openMaterialDetails(material);
        }

      });
    }

    @Override
    public int getItemCount() {
      return materials.size();
    }

    public void updateMaterials(List<Material> materials) {
      this.materials = materials;
      notifyDataSetChanged();
    }

    class MaterialsAdapterHolder extends RecyclerView.ViewHolder {
      private TextView name;
      private TextView template;
      private TextView curQuantity;

      public MaterialsAdapterHolder(View itemView) {
        super(itemView);

        name = (TextView) itemView.findViewById(R.id.material_item_name);
        template = (TextView) itemView.findViewById(R.id.material_item_template);
        curQuantity = (TextView) itemView.findViewById(R.id.material_item_quantity);
      }
    }
  }


  @Override
  public void onCreateMaterialListener(MaterialTemplate template, String attribute) {
    presenter.saveNewMaterial(template, attribute);
  }


  @Override
  public void onEditMaterialListener(Material material, String additionalAmount) {
    presenter.updateMaterial(material, additionalAmount);
  }
}
