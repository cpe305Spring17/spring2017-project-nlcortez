package com.example.natasha.bookkeepingbuddy.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.natasha.bookkeepingbuddy.R;
import com.example.natasha.bookkeepingbuddy.view.AddMaterialCategoryActivity;
import com.example.natasha.bookkeepingbuddy.view.MainActivity;

/**
 * Created by Natasha on 5/11/2017.
 */

public class AddEntitiesFragment extends Fragment {
  private Button addCategoryButton;
  private Button addMaterialTemplateButton;
  private static final String MESSAGE = "DialogMessage";

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_add_entities, container, false);

    addCategoryButton = (Button)v.findViewById(R.id.add_material_cat_button);
    addMaterialTemplateButton = (Button)v.findViewById(R.id.add_material_template_button);

    addCategoryButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        FragmentManager manager = getFragmentManager();
        AddMaterialCategoryFragment dialog = AddMaterialCategoryFragment.newInstance("test1", "test2");
        dialog.show(manager, MESSAGE);
      }
    });

    return v;
  }
}
