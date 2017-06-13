package com.example.natasha.bookkeepingbuddy.model;

import java.util.List;

/**
 * Created by Natasha on 4/21/2017.
 */

public class FinishedProduct {
  private double materialsCost;
  private List<Material> materialsUsed;
  private ProductTemplate template;

  public FinishedProduct(ProductTemplate template, List<Material> materialsUsed) {
    this.template = template;
    this.materialsUsed = materialsUsed;
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

  public ProductTemplate getTemplate() {
    return template;
  }

}
