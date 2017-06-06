package com.example.natasha.bookkeepingbuddy.materials;

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
import com.example.natasha.bookkeepingbuddy.model.MaterialTemplate;
import com.example.natasha.bookkeepingbuddy.model.data.DBQueries;

import java.util.List;

/**
 * Created by Natasha on 5/26/2017.
 */

public class AddMaterialFragment extends DialogFragment {
  private AddMaterialFragment.OnCreateMaterialTemplateListener callback;

  public static AddMaterialFragment newInstance() {
    return new AddMaterialFragment();
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    try {
      callback = (AddMaterialFragment.OnCreateMaterialTemplateListener) getTargetFragment();
    } catch (Exception e) {
      throw e;
    }
  }

  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    View v = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_material_dialog, null);

    final Spinner templateSpinner = (Spinner) v.findViewById(R.id.material_template_spinner);
    final EditText attributeView = (EditText) v.findViewById(R.id.material_attribute_edit_text);
    final TextView quantityView = (TextView) v.findViewById(R.id.material_quantity_textview);
    final TextView costView = (TextView) v.findViewById(R.id.material_cost_textview);

    List<MaterialTemplate> materialTemplates = DBQueries.getAllMaterialTemplates();
    ArrayAdapter<MaterialTemplate> adapter = new ArrayAdapter<MaterialTemplate>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, materialTemplates);
    templateSpinner.setAdapter(adapter);
    templateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        MaterialTemplate item = (MaterialTemplate) parent.getItemAtPosition(pos);
        quantityView.setText(item.getMeasuredQuantity() + " " + item.getCategory().getUnit());
        costView.setText(item.getCost() + "");
      }
      public void onNothingSelected(AdapterView<?> parent) {
      }
    });


    return new AlertDialog.Builder(getActivity())
            .setView(v)
            .setTitle("Add Material")
            .setPositiveButton("add",new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface dialog, int whichButton) {
                callback.OnCreateMaterialListener(
                        (MaterialTemplate) templateSpinner.getSelectedItem(),
                        attributeView.getText().toString());
              }
            })
            .create();
  }

  public interface OnCreateMaterialTemplateListener {
    public void OnCreateMaterialListener(MaterialTemplate template, String attribute);
  }
}
