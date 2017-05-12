package com.example.natasha.bookkeepingbuddy.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.natasha.bookkeepingbuddy.R;
import com.example.natasha.bookkeepingbuddy.model.MaterialCategory;

import java.util.ArrayList;

import static android.R.attr.category;
import static android.R.layout.simple_spinner_dropdown_item;

public class AddMaterialTemplateActivity extends AppCompatActivity {

  private Spinner mCategorySpinner;
  private EditText mAddNameEditText;
  private EditText mAddQuantityEditText;
  private EditText mCostEditText;
  private Button mBtnAddTemplate;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_material_template);

    /*mCategorySpinner = (Spinner) findViewById(R.id.spinner);
    ArrayList<MaterialCategory> categories = new ArrayList<MaterialCategory>();
    ArrayAdapter<MaterialCategory> adapter = new ArrayAdapter<MaterialCategory>(this, android.R.layout.simple_spinner_item, categories);
    mCategorySpinner.setAdapter(adapter);
  */

    mAddNameEditText = (EditText) findViewById(R.id.temp_name_edit_text);
    mAddQuantityEditText = (EditText) findViewById(R.id.quantity_edit_text);
    mCostEditText = (EditText) findViewById(R.id.cost_edit_text);
    mBtnAddTemplate = (Button) findViewById(R.id.save_button);

    addTemplate();

  }

  public void addTemplate() {
    mBtnAddTemplate.setOnClickListener(
            new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                int quantity;
                double cost;

                String name = mAddNameEditText.getText().toString();

                try {
                  quantity = Integer.parseInt(mAddQuantityEditText.getText().toString());
                } catch(NumberFormatException e) {
                  System.out.println("Could not parse " + e);
                }

                try {
                  cost = Double.parseDouble(mCostEditText.getText().toString());
                } catch (NumberFormatException e) {
                  System.out.println("Could not parse " + e);
                }

                // ADD TEMPLATE

                Toast.makeText(AddMaterialTemplateActivity.this,
                        R.string.material_template_added_toast,
                        Toast.LENGTH_SHORT).show();
              }
            }
    );
  }

}
