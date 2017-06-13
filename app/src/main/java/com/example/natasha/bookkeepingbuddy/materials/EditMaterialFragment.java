package com.example.natasha.bookkeepingbuddy.materials;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.example.natasha.bookkeepingbuddy.R;
import com.example.natasha.bookkeepingbuddy.model.Material;

/**
 * Created by Natasha on 6/6/2017.
 */

public class EditMaterialFragment extends DialogFragment {
  private EditMaterialFragment.OnEditMaterialListener callback;
  private Material material = null;

  public static EditMaterialFragment newInstance(Material material) {
    EditMaterialFragment fragment = new EditMaterialFragment();
    fragment.setMaterial(material);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    try {
      callback = (EditMaterialFragment.OnEditMaterialListener) getTargetFragment();
    } catch (Exception e) {
      throw e;
    }
  }

  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    View v = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_material_edit, null);

    final TextView templateView = (TextView) v.findViewById(R.id.material_template_textview);
    final TextView attributeView = (TextView) v.findViewById(R.id.material_attribute_textview);
    final TextView quantityView = (TextView) v.findViewById(R.id.material_quantity_textview);
    final TextView totalView = (TextView) v.findViewById(R.id.material_total_textview);
    final EditText addQuantityView = (EditText) v.findViewById(R.id.material_add_edit_text);
    final TextView unitView = (TextView) v.findViewById(R.id.material_unit_textview);

    templateView.setText(material.getMaterialTemplate().getName());
    attributeView.setText(material.getAttribute());
    quantityView.setText(material.curQuantityText());
    totalView.setText(material.runningTotalText());
    addQuantityView.setText(Integer.toString(material.getMaterialTemplate().getMeasuredQuantity()), TextView.BufferType.NORMAL);
    unitView.setText(material.getMaterialTemplate().getCategory().getUnit());

    return new AlertDialog.Builder(getActivity())
            .setView(v)
            .setTitle("Update Material")
            .setPositiveButton("update",new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface dialog, int whichButton) {
                callback.onEditMaterialListener(
                        material,
                        addQuantityView.getText().toString());
              }
            })
            .create();
  }

  public void setMaterial(Material material) {
    this.material = material;
  }

  public interface OnEditMaterialListener {
    public void onEditMaterialListener(Material material, String additionalAmount);
  }
}

