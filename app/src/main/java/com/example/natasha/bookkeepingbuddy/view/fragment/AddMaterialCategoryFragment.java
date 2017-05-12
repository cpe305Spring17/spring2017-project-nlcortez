package com.example.natasha.bookkeepingbuddy.view.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import com.example.natasha.bookkeepingbuddy.R;
import com.example.natasha.bookkeepingbuddy.presenter.AddMaterialCategoryPresenter;

/**
 * Created by Natasha on 5/12/2017.
 */

public class AddMaterialCategoryFragment extends DialogFragment {
  private AddMaterialCategoryPresenter presenter;

  private static final String ARG_CATEGORY = "category";
  private static final String ARG_UNIT = "unit";

  public static AddMaterialCategoryFragment newInstance(String category, String unit) {
    Bundle args = new Bundle();
    args.putSerializable(ARG_CATEGORY, category);

    AddMaterialCategoryFragment fragment = new AddMaterialCategoryFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    View v = LayoutInflater.from(getActivity())
            .inflate(R.layout.fragment_add_material_category, null);

    return new AlertDialog.Builder(getActivity())
            .setView(v)
            .setTitle("Add Material Category")
            .setPositiveButton("add", null)
            .create();
  }
}
