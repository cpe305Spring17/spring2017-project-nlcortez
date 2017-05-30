package com.example.natasha.bookkeepingbuddy.materialcategories;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;

import com.example.natasha.bookkeepingbuddy.R;

/**
 * Created by Natasha on 5/12/2017.
 */

public class AddMaterialCategoryFragment extends DialogFragment {
  private static final String ARG_CATEGORY = "category";
  private static final String ARG_UNIT = "unit";

  public static AddMaterialCategoryFragment newInstance() {
    return new AddMaterialCategoryFragment();
  }

  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    View v = LayoutInflater.from(getActivity())
            .inflate(R.layout.fragment_material_category_dialog, null);

    return new AlertDialog.Builder(getActivity())
            .setView(v)
            .setTitle("Add Material Category")
            .setPositiveButton("add",null)
            .create();
  }
}
