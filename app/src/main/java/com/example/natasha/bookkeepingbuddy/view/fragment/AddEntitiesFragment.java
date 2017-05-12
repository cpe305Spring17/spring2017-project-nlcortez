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
import com.example.natasha.bookkeepingbuddy.model.MainModel;
import com.example.natasha.bookkeepingbuddy.presenter.AddEntitiesPresenter;
import com.example.natasha.bookkeepingbuddy.view.AddMaterialCategoryActivity;
import com.example.natasha.bookkeepingbuddy.view.MainActivity;

import java.io.Serializable;

/**
 * Created by Natasha on 5/11/2017.
 */

public class AddEntitiesFragment extends Fragment implements Serializable {
  private AddEntitiesPresenter presenter;
  private Button addCategoryButton;
  private Button addMaterialTemplateButton;

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
        //Intent i = AddMaterialCategoryActivity.newIntent(v.getContext(), presenter);
        //startActivity(i);
      }
    });

    return v;
  }


}
