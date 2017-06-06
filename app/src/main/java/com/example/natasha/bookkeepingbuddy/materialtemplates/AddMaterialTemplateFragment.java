package com.example.natasha.bookkeepingbuddy.materialtemplates;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.natasha.bookkeepingbuddy.R;
import com.example.natasha.bookkeepingbuddy.materialcategories.AddMaterialCategoryFragment;
import com.example.natasha.bookkeepingbuddy.model.MaterialCategory;
import com.example.natasha.bookkeepingbuddy.model.data.DBQueries;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Natasha on 5/12/2017.
 */

public class AddMaterialTemplateFragment extends DialogFragment {
  private AddMaterialTemplateFragment.OnCreateMaterialTemplateListener callback;

  public static AddMaterialTemplateFragment newInstance() {
    return new AddMaterialTemplateFragment();
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    try {
      callback = (AddMaterialTemplateFragment.OnCreateMaterialTemplateListener) getTargetFragment();
    } catch (Exception e) {
      throw e;
    }
  }

  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    View v = LayoutInflater.from(getActivity())
            .inflate(R.layout.fragment_material_template_dialog, null);

    final Spinner categorySpinner = (Spinner) v.findViewById(R.id.material_category_spinner);
    final EditText nameView = (EditText) v.findViewById(R.id.temp_name_edit_text);
    final EditText quantityView = (EditText) v.findViewById(R.id.quantity_edit_text);
    final EditText costView = (EditText) v.findViewById(R.id.cost_edit_text);
    final TextView unitText = (TextView) v.findViewById(R.id.mt_unit_text_view);

    List<MaterialCategory> materialCategories = DBQueries.getAllMaterialCategories();
    ArrayAdapter<MaterialCategory> adapter = new ArrayAdapter<MaterialCategory>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, materialCategories);
    categorySpinner.setAdapter(adapter);
    categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        MaterialCategory item = (MaterialCategory) parent.getItemAtPosition(pos);
        unitText.setText(item.getUnit() + " " + item.getId());
      }
      public void onNothingSelected(AdapterView<?> parent) {
      }
    });


    return new AlertDialog.Builder(getActivity())
            .setView(v)
            .setTitle("Add Material Template")
            .setPositiveButton("add",new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface dialog, int whichButton) {
                callback.OnCreateMaterialTemplateListener(
                        (MaterialCategory) categorySpinner.getSelectedItem(),
                        nameView.getText().toString(),
                        quantityView.getText().toString(),
                        costView.getText().toString());
              }
            })
            .create();
  }

  public interface OnCreateMaterialTemplateListener {
    public void OnCreateMaterialTemplateListener(MaterialCategory category, String name, String quantity, String cost);
  }

}
