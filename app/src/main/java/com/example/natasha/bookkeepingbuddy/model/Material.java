package com.example.natasha.bookkeepingbuddy.model;

/**
 * Created by Natasha on 4/21/2017.
 */

public class Material {
  private int id = -1;
  private int currentQuantity;
  private MaterialTemplate template;
  private String attribute;

  public Material(MaterialTemplate template, String attribute) {
    this.template = template;
    this.attribute = attribute;
    this.currentQuantity = template.getMeasuredQuantity();
  }

  public Material(int id, MaterialTemplate template, String attribute, int currentQuantity) {
    this.id = id;
    this.template = template;
    this.attribute = attribute;
    this.currentQuantity = currentQuantity;
  }

  public String getAttribute() { return attribute; }

  public void setAttribute(String attribute) { this.attribute = attribute; }

  public int getCurrentQuantity() {
    return currentQuantity;
  }

  public void setCurrentQuantity(int currentQuantity) {
    this.currentQuantity = currentQuantity;
  }

  public int getId() { return id;}

  public void setId(int id) { this.id = id; }

  public MaterialTemplate getMaterialTemplate() {return template; }

  public double getPartialCost(int amountUsed) {
    double percentUsed = (double) amountUsed / (double) template.getMeasuredQuantity();
    double cost = percentUsed * template.getCost();

    return cost;
  }
}
