package com.example.natasha.bookkeepingbuddy.materialtemplates;

import android.support.annotation.NonNull;
import com.example.natasha.bookkeepingbuddy.model.MaterialTemplate;

import java.util.List;

/**
 * Created by Natasha on 5/26/2017.
 */

public interface MaterialTemplatesContract {
  interface View {

    void showAddMaterialTemplate();

    void showMaterialTemplates(List<MaterialTemplate> categories);

    void showMaterialTemplateDetails(String templateId);
  }

  interface Presenter {

    void loadMaterialTemplates(boolean forceUpdate);

    void addNewMaterialTemplate();

    void saveNewMaterialTemplate(String category, String template, String quantity, String cost);

    void openMaterialTemplateDetails(@NonNull MaterialTemplate category);
  }

}
