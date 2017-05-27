package com.example.natasha.bookkeepingbuddy.materialtemplates;

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

public class AddMaterialTemplateFragment extends DialogFragment {
  private static final String ARG_CATEGORY = "category";
  private static final String ARG_TEMPLATE_NAME = "name";
  private static final String ARG_MEASURED_QUANTITY = "quantity";
  private static final String ARG_COST = "cost";

  public static AddMaterialTemplateFragment newInstance(String category, String name, String quantity, String cost) {
    Bundle args = new Bundle();
    args.putSerializable(ARG_CATEGORY, category);
    args.putSerializable(ARG_TEMPLATE_NAME, name);
    args.putSerializable(ARG_MEASURED_QUANTITY, quantity);
    args.putSerializable(ARG_COST, cost);

    AddMaterialTemplateFragment fragment = new AddMaterialTemplateFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    View v = LayoutInflater.from(getActivity())
            .inflate(R.layout.fragment_material_template_dialog, null);

    return new AlertDialog.Builder(getActivity())
            .setView(v)
            .setTitle("Add Material Template")
            .setPositiveButton("add",null)
            .create();
  }
}
