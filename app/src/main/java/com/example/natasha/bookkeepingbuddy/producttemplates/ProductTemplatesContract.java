package com.example.natasha.bookkeepingbuddy.producttemplates;

import com.example.natasha.bookkeepingbuddy.model.ProductTemplate;
import com.example.natasha.bookkeepingbuddy.model.ProductTemplateComponent;

import java.util.List;

/**
 * Created by Natasha on 6/6/2017.
 */

public interface ProductTemplatesContract {
  interface View {
    void showAddProductTemplate();

    void showProductTemplates(List<ProductTemplate> productTemplates);

    void showProductTemplateDetails(ProductTemplate productTemplate);
  }

  interface Presenter {
    void loadProductTemplates();

    void addNewProductTemplate();

    void saveNewProductTemplate(String name, String price, List<ProductTemplateComponent> components);

    void updateProductTemplate(List<ProductTemplateComponent> components, String additionalAmount);

    void openProductTemplateDetails(ProductTemplate productTemplate);
  }
}
