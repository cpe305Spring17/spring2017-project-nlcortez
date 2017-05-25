package com.example.natasha.bookkeepingbuddy.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Natasha on 4/21/2017.
 */

public class FinishedProduct {
  private double materialsCost;
  private ArrayList<Material>  materialsUsed;
  private ProductTemplate template;

  public FinishedProduct(double materialsCost, ProductTemplate template, ArrayList<Material> materialsUsed) {
    this.template = template;
    this.materialsUsed = materialsUsed;
    calculateMaterialsCost();
  }

  public double getMaterialsCost() {
    return materialsCost;
  }

  public void setMaterialsCost(double materialsCost) {
    this.materialsCost = materialsCost;
  }

  public ArrayList<Material> getMaterialsUsed() { return materialsUsed; }

  public void addMaterial(Material materialUsed) {
    materialsUsed.add(materialUsed);
  }

  public void removeMaterial(Material materialUsed) {
    materialsUsed.remove(materialUsed);
  }

  // need to use SQL query
  public void calculateMaterialsCost() {
    double cost = 0.0;

    materialsCost = cost;
  }
}
