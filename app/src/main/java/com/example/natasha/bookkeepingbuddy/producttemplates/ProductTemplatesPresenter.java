package com.example.natasha.bookkeepingbuddy.producttemplates;

import com.example.natasha.bookkeepingbuddy.model.ProductTemplate;
import com.example.natasha.bookkeepingbuddy.model.ProductTemplateComponent;
import com.example.natasha.bookkeepingbuddy.model.data.DBQueries;

import java.util.List;

/**
 * Created by Natasha on 6/6/2017.
 */

public class ProductTemplatesPresenter implements ProductTemplatesContract.Presenter {
  private final ProductTemplatesContract.View view;
  private List<ProductTemplate> productTemplates;

  public ProductTemplatesPresenter(ProductTemplatesContract.View view) {
    this.view = view;
    productTemplates = DBQueries.getAllProductTemplates();
  }

  @Override
  public void loadProductTemplates() {
    productTemplates = DBQueries.getAllProductTemplates();
    view.showProductTemplates(productTemplates);
  }

  @Override
  public void addNewProductTemplate() {
    view.showAddProductTemplate();
  }

  @Override
  public void saveNewProductTemplate(String name, String price, List<ProductTemplateComponent> components) {
    DBQueries.addProductTemplate(new ProductTemplate(name, Double.parseDouble(price), components));
    loadProductTemplates();
  }


  @Override
  public void updateProductTemplate(List<ProductTemplateComponent> components, String additionalAmount) {
    // TO-DO
  }

  @Override
  public void openProductTemplateDetails(ProductTemplate productTemplate) {
    // TO-DO
  }
}
