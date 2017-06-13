package com.example.natasha.bookkeepingbuddy;

import com.example.natasha.bookkeepingbuddy.model.Material;
import com.example.natasha.bookkeepingbuddy.model.MaterialCategory;
import com.example.natasha.bookkeepingbuddy.model.MaterialTemplate;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Natasha on 5/10/2017.
 */

public class TestMaterialTemplate {
  @Test
  public void testConstructor() throws Exception {
    MaterialCategory yarnCategory = new MaterialCategory("yarn", "yards");
    MaterialTemplate template = new MaterialTemplate("red heart super saver", yarnCategory, 360, 2.99);

    assertNotNull(template);
  }

  @Test
  public void testConstructorWithId() throws Exception {
    MaterialCategory yarnCategory = new MaterialCategory("yarn", "yards");
    MaterialTemplate template = new MaterialTemplate(1, "red heart super saver", yarnCategory, 360, 2.99);

    assertNotNull(template);
  }

  @Test
  public void testGetName() throws Exception {
    String name = "red heart super saver";
    MaterialCategory yarnCategory = new MaterialCategory("yarn", "yards");
    MaterialTemplate template = new MaterialTemplate(name, yarnCategory, 360, 2.99);

    assertEquals(name, template.getName());
  }

  @Test
  public void testSetName() throws Exception {
    MaterialCategory yarnCategory = new MaterialCategory("yarn", "yards");
    MaterialTemplate template = new MaterialTemplate("red heart super saver", yarnCategory, 360, 2.99);
    String name = "lionbrand";
    template.setName(name);

    assertEquals(name, template.getName());
  }

  @Test
  public void testGetCategory() throws Exception {
    MaterialCategory yarnCategory = new MaterialCategory("yarn", "yards");
    MaterialTemplate template = new MaterialTemplate("red heart super saver", yarnCategory, 360, 2.99);

    assertEquals(yarnCategory, template.getCategory());
  }

  @Test
  public void testSetCategory() throws Exception {
    MaterialCategory yarnCategory = new MaterialCategory("yarn", "yards");
    MaterialTemplate template = new MaterialTemplate("DNC embroidery", yarnCategory, 360, 2.99);

    MaterialCategory threadCategory = new MaterialCategory("thread", "yards");
    template.setCategory(threadCategory);

    assertEquals(threadCategory, template.getCategory());
  }

  @Test
  public void testGetMeasuredQuantity() throws Exception {
    MaterialCategory yarnCategory = new MaterialCategory("yarn", "yards");
    MaterialTemplate template = new MaterialTemplate("red heart super saver", yarnCategory, 360, 2.99);

    assertEquals(360, template.getMeasuredQuantity());
  }

  @Test
  public void testSetMeasuredQuantity() throws Exception {
    MaterialCategory yarnCategory = new MaterialCategory("yarn", "yards");
    MaterialTemplate template = new MaterialTemplate("DNC embroidery", yarnCategory, 360, 2.99);

    template.setMeasuredQuantity(300);

    assertEquals(300, template.getMeasuredQuantity());
  }

  @Test
  public void testGetCost() throws Exception {
    MaterialCategory yarnCategory = new MaterialCategory("yarn", "yards");
    MaterialTemplate template = new MaterialTemplate("red heart super saver", yarnCategory, 360, 2.99);

    assertEquals(2.99, template.getCost(), 0.001);
  }

  @Test
  public void testSetCost() throws Exception {
    MaterialCategory yarnCategory = new MaterialCategory("yarn", "yards");
    MaterialTemplate template = new MaterialTemplate("DNC embroidery", yarnCategory, 360, 2.99);

    template.setCost(2.50);

    assertEquals(2.50, template.getCost(), 0.001);
  }

  @Test
  public void testGetId() throws Exception {
    MaterialCategory yarnCategory = new MaterialCategory("yarn", "yards");
    MaterialTemplate template = new MaterialTemplate(7, "red heart super saver", yarnCategory, 360, 2.99);

    assertEquals(7, template.getId());
  }

  @Test
  public void testSetId() throws Exception {
    MaterialCategory yarnCategory = new MaterialCategory("yarn", "yards");
    MaterialTemplate template = new MaterialTemplate("DNC embroidery", yarnCategory, 360, 2.99);

    template.setId(8);

    assertEquals(8, template.getId());
  }

  @Test
  public void testQuantityDescription() throws Exception {
    MaterialCategory yarnCategory = new MaterialCategory("yarn", "yards");
    MaterialTemplate template = new MaterialTemplate("DNC embroidery", yarnCategory, 360, 2.99);

    assertEquals("360 yards", template.quantityDescription());
  }

  @Test
  public void testToString() throws Exception {
    MaterialCategory yarnCategory = new MaterialCategory("yarn", "yards");
    MaterialTemplate template = new MaterialTemplate("DNC embroidery", yarnCategory, 360, 2.99);

    assertEquals("DNC embroidery", template.toString());
  }


}
