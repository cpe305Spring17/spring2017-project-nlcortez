package com.example.natasha.bookkeepingbuddy.model;

/**
 * Created by Natasha on 4/21/2017.
 */

public class Material {
  private int currentQuantity;
  private MaterialTemplate template;

  public Material(MaterialTemplate template) {
    this.template = template;
    setCurrentQuantity(template.getMeasuredQuantity());
  }

  public int getCurrentQuantity() {
    return currentQuantity;
  }

  public void setCurrentQuantity(int currentQuantity) {
    this.currentQuantity = currentQuantity;
  }

  public double getPartialCost(int amountUsed) {
    double percentUsed = (double) amountUsed / (double) template.getMeasuredQuantity();
    double cost = percentUsed * template.getCost();

    return cost;
  }
}
