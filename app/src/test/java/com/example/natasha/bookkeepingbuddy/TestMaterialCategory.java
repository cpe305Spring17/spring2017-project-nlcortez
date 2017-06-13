package com.example.natasha.bookkeepingbuddy;

import com.example.natasha.bookkeepingbuddy.model.Material;
import com.example.natasha.bookkeepingbuddy.model.MaterialCategory;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Natasha on 5/10/2017.
 */

public class TestMaterialCategory {
  @Test
  public void testConstructor() throws Exception {
    MaterialCategory category = new MaterialCategory("yarn", "yards");

    assertNotNull(category);
  }

  @Test
  public void testConstructorWithId() throws Exception {
    MaterialCategory category = new MaterialCategory(1, "yarn", "yards");

    assertNotNull(category);
  }

  @Test
  public void testGetName() throws Exception {
    String name = "yarn";
    MaterialCategory category = new MaterialCategory(name, "yards");

    assertEquals(name, category.getName());
  }

  @Test
  public void testSetName() throws Exception {
    MaterialCategory category = new MaterialCategory("thread", "yards");
    String name = "yarn";
    category.setName(name);

    assertEquals(name, category.getName());
  }

  @Test
  public void testGetUnit() throws Exception {
    String unit = "yards";
    MaterialCategory category = new MaterialCategory("yarn", unit);

    assertEquals(unit, category.getUnit());
  }

  @Test
  public void testSetUnit() throws Exception {
    MaterialCategory category = new MaterialCategory("thread", "feet");
    String unit = "yards";
    category.setUnit(unit);

    assertEquals(unit, category.getUnit());
  }

  @Test
  public void testGetId() throws Exception {
    String unit = "yards";
    MaterialCategory category = new MaterialCategory(7, "yarn", unit);

    assertEquals(7, category.getId());
  }

  @Test
  public void testSetId() throws Exception {
    MaterialCategory category = new MaterialCategory("thread", "feet");
    category.setId(6);

    assertEquals(6, category.getId());
  }

  @Test
  public void testToString() throws Exception {
    MaterialCategory category = new MaterialCategory("thread", "feet");
    category.setId(6);

    assertEquals("thread", category.toString());
  }

}
