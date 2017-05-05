package com.example.natasha.bookkeepingbuddy.model;

/**
 * Created by Natasha on 4/28/2017.
 */

public class ProductTemplateComponent {
  private int quantityNeeded;
  private MaterialCategory category;

  public ProductTemplateComponent(int quantityNeeded, MaterialCategory category) {
    this.quantityNeeded = quantityNeeded;
    this.category = category;
  }

  public int getQuantityNeeded() {
    return quantityNeeded;
  }

  public void setQuantityNeeded(int quantityNeeded) {
    this.quantityNeeded = quantityNeeded;
  }

  public MaterialCategory getCategory() {
    return category;
  }

  public void setCategory(MaterialCategory category) {
    this.category = category;
  }

}
