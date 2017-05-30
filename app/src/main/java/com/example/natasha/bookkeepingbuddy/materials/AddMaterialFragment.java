package com.example.natasha.bookkeepingbuddy.materials;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;

import com.example.natasha.bookkeepingbuddy.R;

/**
 * Created by Natasha on 5/26/2017.
 */

public class AddMaterialFragment extends DialogFragment {

  public static AddMaterialFragment newInstance() {
    return new AddMaterialFragment();
  }

  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    View v = LayoutInflater.from(getActivity())
            .inflate(R.layout.fragment_material_dialog, null);

    return new AlertDialog.Builder(getActivity())
            .setView(v)
            .setTitle("Add Material")
            .setPositiveButton("add",null)
            .create();
  }
}
