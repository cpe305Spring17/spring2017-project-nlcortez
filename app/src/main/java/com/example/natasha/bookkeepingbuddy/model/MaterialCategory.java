package com.example.natasha.bookkeepingbuddy.model;

/**
 * Created by Natasha on 4/21/2017.
 */

public class MaterialCategory {
  private int id = -1;
  private String name;
  private String unit;

  public MaterialCategory(String name, String unit) {
    this.name = name;
    this.unit = unit;
  }

  public MaterialCategory(int id, String name, String unit) {
    this.id = id;
    this.name = name;
    this.unit = unit;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public int getId() { return id;}

  public void setId(int id) { this.id = id; }

  @Override
  public String toString() {
    return this.name;
  }

}
