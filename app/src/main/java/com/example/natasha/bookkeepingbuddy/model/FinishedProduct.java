package com.example.natasha.bookkeepingbuddy.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Natasha on 4/21/2017.
 */

public class FinishedProduct {
  int id;
  private double materialsCost;
  private List<Material> materialsUsed;
  private ProductTemplate template;

  public FinishedProduct(ProductTemplate template, List<Material> materialsUsed) {
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

  public List<Material> getMaterialsUsed() { return materialsUsed; }

  public void addMaterial(Material materialUsed) {
    materialsUsed.add(materialUsed);
  }

  public void removeMaterial(Material materialUsed) {
    materialsUsed.remove(materialUsed);
  }

  public int getId() { return id;}

  public void setId(int id) { this.id = id; }

  public void calculateMaterialsCost() {
    double cost = 0.0;

    materialsCost = cost;
  }
}
