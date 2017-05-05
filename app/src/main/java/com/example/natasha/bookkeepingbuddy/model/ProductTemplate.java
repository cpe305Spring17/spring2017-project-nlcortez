package com.example.natasha.bookkeepingbuddy.model;

import java.util.ArrayList;

/**
 * Created by Natasha on 4/21/2017.
 */

public class ProductTemplate {
  private String productName;
  private double price;
  private ArrayList<ProductTemplateComponent> materialsNeeded;

  public ProductTemplate(String productName, double price) {
    this.productName = productName;
    this.price = price;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}
