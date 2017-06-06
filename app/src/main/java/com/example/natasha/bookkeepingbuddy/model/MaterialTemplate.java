package com.example.natasha.bookkeepingbuddy.model;

/**
 * Created by Natasha on 4/21/2017.
 */

public class MaterialTemplate {
  private int id = -1;
  private String name;
  private MaterialCategory category;
  private int measuredQuantity;
  private double cost;

  public MaterialTemplate(String name, MaterialCategory category, int measuredQuantity, double cost) {
    this.name = name;
    this.category = category;
    this.measuredQuantity = measuredQuantity;
    this.cost = cost;
  }

  public MaterialTemplate(int id, String name, MaterialCategory category, int measuredQuantity, double cost) {
    this.id = id;
    this.name = name;
    this.category = category;
    this.measuredQuantity = measuredQuantity;
    this.cost = cost;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public MaterialCategory getCategory() {
    return category;
  }

  public void setCategory(MaterialCategory category) {
    this.category = category;
  }

  public int getMeasuredQuantity() {
    return measuredQuantity;
  }

  public void setMeasuredQuantity(int measuredQuantity) {
    this.measuredQuantity = measuredQuantity;
  }

  public double getCost() {
    return cost;
  }

  public void setCost(double cost) {
    this.cost = cost;
  }

  public int getId() { return id;}

  public void setId(int id) { this.id = id; }

  @Override
  public String toString() {
    return this.name;
  }


}
