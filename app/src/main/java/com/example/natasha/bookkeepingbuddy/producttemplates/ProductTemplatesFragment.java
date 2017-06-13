package com.example.natasha.bookkeepingbuddy.producttemplates;

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
import com.example.natasha.bookkeepingbuddy.model.ProductTemplate;
import com.example.natasha.bookkeepingbuddy.model.ProductTemplateComponent;

import java.util.List;

public class ProductTemplatesFragment extends Fragment implements ProductTemplatesContract.View, AddProductTemplateFragment.OnCreateProductTemplateListener {
  private static ProductTemplatesContract.Presenter presenter;

  private List<ProductTemplate> productTemplates;
  private ProductTemplatesFragment.ProductTemplatesAdapter adapter;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    adapter = new ProductTemplatesAdapter(productTemplates, getContext());
    presenter = new ProductTemplatesPresenter(this);
    presenter.loadProductTemplates();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootView;
    RecyclerView recView;

    rootView = inflater.inflate(R.layout.fragment_product_templates, container, false);

    recView = (RecyclerView) rootView.findViewById(R.id.prod_temps_list);
    recView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
    recView.setAdapter(adapter);

    FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        presenter.addNewProductTemplate();
      }
    });

    return rootView;
  }

  @Override
  public void showAddProductTemplate() {
    FragmentManager manager = getFragmentManager();
    AddProductTemplateFragment dialog = AddProductTemplateFragment.newInstance();
    dialog.setTargetFragment(this, 0);
    dialog.show(manager, "Material Dialog");
  }

  @Override
  public void showProductTemplates(List<ProductTemplate> productTemplates) {
    this.productTemplates = productTemplates;
    adapter.updateProductTemplates(this.productTemplates);
  }

  @Override
  public void showProductTemplateDetails(ProductTemplate productTemplate) {
    // TO-DO
  }

  @Override
  public void onCreateProductTemplate(String name, String price, List<ProductTemplateComponent> productTemplateComponents) {
    presenter.saveNewProductTemplate(name, price, productTemplateComponents);
  }

  private static class ProductTemplatesAdapter extends RecyclerView.Adapter<ProductTemplatesAdapter.ProductTemplatesAdapterHolder> {
    private List<ProductTemplate> productTemplates;
    private LayoutInflater inflater;

    public ProductTemplatesAdapter(List<ProductTemplate> productTemplates, Context context) {
      this.inflater = LayoutInflater.from(context);
      this.productTemplates = productTemplates;
    }

    @Override
    public ProductTemplatesAdapter.ProductTemplatesAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View view = inflater.inflate(R.layout.item_product_template, parent, false);

      return new ProductTemplatesAdapter.ProductTemplatesAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductTemplatesAdapter.ProductTemplatesAdapterHolder holder, int position) {
      final ProductTemplate productTemplate = productTemplates.get(position);

      holder.name.setText(productTemplate.getProductName());
      holder.price.setText("price: $" + productTemplate.getPrice() + "");
      holder.materialCategories.setText(productTemplate.categoriesText());

      holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          presenter.openProductTemplateDetails(productTemplate);
        }

      });
    }

    @Override
    public int getItemCount() {
      return productTemplates.size();
    }

    public void updateProductTemplates(List<ProductTemplate> productTemplates) {
      this.productTemplates = productTemplates;
      notifyDataSetChanged();
    }

    class ProductTemplatesAdapterHolder extends RecyclerView.ViewHolder {
      private TextView name;
      private TextView price;
      private TextView materialCategories;

      public ProductTemplatesAdapterHolder(View itemView) {
        super(itemView);

        name = (TextView) itemView.findViewById(R.id.prod_temp_item_name);
        price = (TextView) itemView.findViewById(R.id.prod_temp_item_price);
        materialCategories = (TextView) itemView.findViewById(R.id.prod_temp_item_mat_cats);
      }
    }
  }
}
