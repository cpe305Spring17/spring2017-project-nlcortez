package com.example.natasha.bookkeepingbuddy.materialcategories;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.example.natasha.bookkeepingbuddy.R;
import com.example.natasha.bookkeepingbuddy.materialtemplates.AddMaterialTemplateFragment;
import com.example.natasha.bookkeepingbuddy.model.MaterialCategory;

import java.io.Serializable;

/**
 * Created by Natasha on 5/12/2017.
 */

public class AddMaterialCategoryFragment extends DialogFragment {
  private OnMaterialCategoryListener callback;

  public static AddMaterialCategoryFragment newInstance() {
    return new AddMaterialCategoryFragment();
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    try {
      callback = (OnMaterialCategoryListener) getTargetFragment();
    } catch (Exception e) {
      throw e;
    }
  }

  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    View v = LayoutInflater.from(getActivity())
            .inflate(R.layout.fragment_material_category_dialog, null);

    final EditText categoryView = (EditText) v.findViewById(R.id.cat_name_edit_text);
    final EditText unitView = (EditText) v.findViewById(R.id.cat_unit_edit_text);

    return new AlertDialog.Builder(getActivity())
            .setView(v)
            .setTitle("Add Material")
            .setPositiveButton("add",new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface dialog, int whichButton) {
                callback.onCreateMaterialCategory(categoryView.getText().toString(),
                        unitView.getText().toString());
              }
            })
            .create();
  }

  public interface OnMaterialCategoryListener {
    public void onCreateMaterialCategory(String category, String unit);
  }
}
