package com.example.natasha.bookkeepingbuddy.model;

/**
 * Created by Natasha on 4/21/2017.
 */

public class FinishedProduct {
  private double materialsCost;
  private ProductTemplate template;

  public FinishedProduct(double materialsCost, ProductTemplate template) {
    this.materialsCost = materialsCost;
    this.template = template;
  }

  public double getMaterialsCost() {
    return materialsCost;
  }

  public void setMaterialsCost(double materialsCost) {
    this.materialsCost = materialsCost;
  }

  public ProductTemplate getTemplate() {
    return template;
  }

  public void setTemplate(ProductTemplate template) {
    this.template = template;
  }
}
