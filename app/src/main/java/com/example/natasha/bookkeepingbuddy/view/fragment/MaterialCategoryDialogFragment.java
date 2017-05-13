package com.example.natasha.bookkeepingbuddy.view.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;

import com.example.natasha.bookkeepingbuddy.R;
import com.example.natasha.bookkeepingbuddy.model.Material;

/**
 * Created by Natasha on 5/12/2017.
 */

public class MaterialCategoryDialogFragment extends DialogFragment {
  private static final String ARG_CATEGORY = "category";
  private static final String ARG_UNIT = "unit";

  public static MaterialCategoryDialogFragment newInstance(String category, String unit) {
    Bundle args = new Bundle();
    args.putSerializable(ARG_CATEGORY, category);
    args.putSerializable(ARG_UNIT, unit);

    MaterialCategoryDialogFragment fragment = new MaterialCategoryDialogFragment();
    fragment.setArguments(args);
    return fragment;
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
