package com.example.natasha.bookkeepingbuddy.producttemplates;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.natasha.bookkeepingbuddy.R;
import com.example.natasha.bookkeepingbuddy.materials.EditMaterialFragment;
import com.example.natasha.bookkeepingbuddy.model.Material;
import com.example.natasha.bookkeepingbuddy.model.MaterialCategory;
import com.example.natasha.bookkeepingbuddy.model.ProductTemplate;
import com.example.natasha.bookkeepingbuddy.model.ProductTemplateComponent;
import com.example.natasha.bookkeepingbuddy.model.data.DBQueries;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Natasha on 6/6/2017.
 */

public class AddProductTemplateFragment extends DialogFragment {
  private OnCreateProductTemplateListener callback;
  private RecyclerView recView;
  private ProdTempCompAdapter adapter;
  private List<ProductTemplateComponent> productTemplateComponents;

  public static AddProductTemplateFragment newInstance() {
    return new AddProductTemplateFragment();
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    productTemplateComponents = new ArrayList<ProductTemplateComponent>();

    try {
      callback = (OnCreateProductTemplateListener) getTargetFragment();
    } catch (Exception e) {
      throw e;
    }
  }

  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    View v = LayoutInflater.from(getActivity())
            .inflate(R.layout.fragment_prod_temp_dialog, null);

    final EditText nameView = (EditText) v.findViewById(R.id.pt_add_name);
    final EditText priceView = (EditText) v.findViewById(R.id.pt_add_price);
    final Button categoryBtn = (Button) v.findViewById(R.id.add_cat_button);

    adapter = new ProdTempCompAdapter(productTemplateComponents, getContext());

    LinearLayoutManager manager = new LinearLayoutManager(getContext());

    recView = (RecyclerView) v.findViewById(R.id.prod_temps_cat_list);
    recView.setLayoutManager(manager);
    recView.setAdapter(adapter);

    categoryBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        productTemplateComponents.add(new ProductTemplateComponent());
        adapter.updateProductTemplateComponents(productTemplateComponents);
      }
    });

    return new AlertDialog.Builder(getActivity())
            .setView(v)
            .setTitle("Add Product Template")
            .setPositiveButton("add",new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface dialog, int whichButton) {
                callback.OnCreateProductTemplateListener(nameView.getText().toString(),
                        priceView.getText().toString(),
                        adapter.getUpdatedList());
              }
            })
            .create();
  }

  private class ProdTempCompAdapter extends RecyclerView.Adapter<ProdTempCompAdapter.ProdTempCompAdapterHolder> {
    private List<ProductTemplateComponent> productTemplateComponents;
    private LayoutInflater inflater;
    private ArrayAdapter<MaterialCategory> categoryAdapter;

    public ProdTempCompAdapter(List<ProductTemplateComponent> productTemplateComponents, Context context) {
      this.inflater = LayoutInflater.from(context);
      this.productTemplateComponents = productTemplateComponents;

      List<MaterialCategory> materialCategories = DBQueries.getAllMaterialCategories();
      categoryAdapter = new ArrayAdapter<MaterialCategory>(context, android.R.layout.simple_spinner_dropdown_item, materialCategories);
      categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }

    @Override
    public ProdTempCompAdapter.ProdTempCompAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View view = inflater.inflate(R.layout.item_prod_temp_cat, parent, false);

      return new ProdTempCompAdapter.ProdTempCompAdapterHolder(view, new EditTextListener());
    }

    @Override
    public void onBindViewHolder(final ProdTempCompAdapterHolder holder, final int position) {
      final ProductTemplateComponent productTemplateComponent = productTemplateComponents.get(position);

      holder.editTextListener.updatePosition(position);
      holder.quantity.setText(productTemplateComponent.getQuantityNeeded() + "");
      holder.category.setAdapter(categoryAdapter);

      holder.category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
          MaterialCategory item = (MaterialCategory) parent.getItemAtPosition(pos);
          holder.unit.setText(item.getUnit());
          productTemplateComponent.setCategory(item);
        }
        public void onNothingSelected(AdapterView<?> parent) {
        }
      });

      holder.closeBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          productTemplateComponents.remove(position);
          notifyDataSetChanged();
        }
      });
    }

    @Override
    public int getItemCount() {
      return productTemplateComponents.size();
    }

    public void updateProductTemplateComponents(List<ProductTemplateComponent> productTemplateComponents) {
      this.productTemplateComponents = productTemplateComponents;
      notifyDataSetChanged();
    }

    public List<ProductTemplateComponent> getUpdatedList() {
      List<ProductTemplateComponent> retList = productTemplateComponents;
      List<ProductTemplateComponent> removeList = new ArrayList<ProductTemplateComponent>();

      for (int i = 0; i < productTemplateComponents.size(); i++) {
        ProductTemplateComponent component = productTemplateComponents.get(i);
        if (component.getQuantityNeeded() == 0)
          removeList.add(component);
        else
          System.out.println("CATEGORY IS " + component.getCategory().toString() + " AND AMOUNT IS " + component.getQuantityNeeded());
      }
      retList.removeAll(removeList);
      return retList;
    }

    class ProdTempCompAdapterHolder extends RecyclerView.ViewHolder {
      private Spinner category;
      private EditText quantity;
      private TextView unit;
      private ImageButton closeBtn;
      private EditTextListener editTextListener;

      public ProdTempCompAdapterHolder(View itemView, EditTextListener editTextListener) {
        super(itemView);
        category = (Spinner) itemView.findViewById(R.id.item_cur_cat);
        quantity = (EditText) itemView.findViewById(R.id.item_cur_cat_quantity);
        unit = (TextView) itemView.findViewById(R.id.item_cur_cat_unit);
        closeBtn = (ImageButton) itemView.findViewById(R.id.item_cat_close_btn);
        this.editTextListener = editTextListener;

        quantity.addTextChangedListener(editTextListener);
      }
    }

    private class EditTextListener implements TextWatcher {
      private int position;

      public void updatePosition(int position) {
        this.position = position;
      }

      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (!s.toString().equals("")) {
          productTemplateComponents.get(position).setQuantityNeeded(Integer.parseInt(s.toString()));
        }
      }

      @Override
      public void afterTextChanged(Editable s) {
      }
    }
  }




  public interface OnCreateProductTemplateListener {
    public void OnCreateProductTemplateListener(String name, String price, List<ProductTemplateComponent> productTemplateComponents);
  }

}
