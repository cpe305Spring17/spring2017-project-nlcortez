package com.example.natasha.bookkeepingbuddy;

import com.example.natasha.bookkeepingbuddy.model.Material;
import com.example.natasha.bookkeepingbuddy.model.MaterialCategory;
import com.example.natasha.bookkeepingbuddy.model.MaterialTemplate;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Natasha on 5/24/2017.
 */

public class TestMaterial {

  @Test
  public void testConstructor() throws Exception {
    MaterialCategory yarnCategory = new MaterialCategory("yarn", "yards");
    MaterialTemplate template = new MaterialTemplate("red heart super saver", yarnCategory, 360, 2.99);
    Material ballOfYarn = new Material(template, "red");

    assertNotNull(template);
  }

  @Test
  public void testGetAttribute() throws Exception {
    String name = "red heart super saver";
    MaterialCategory yarnCategory = new MaterialCategory("yarn", "yards");
    MaterialTemplate template = new MaterialTemplate(name, yarnCategory, 360, 2.99);
    Material ballOfYarn = new Material(template, "red");

    assertEquals("red", ballOfYarn.getAttribute());
  }

  @Test
  public void testSetAttribute() throws Exception {
    MaterialCategory yarnCategory = new MaterialCategory("yarn", "yards");
    MaterialTemplate template = new MaterialTemplate("red heart super saver", yarnCategory, 360, 2.99);
    Material ballOfYarn = new Material(template, "red");
    ballOfYarn.setAttribute("blue");

    assertEquals("blue", ballOfYarn.getAttribute());
  }

  @Test
  public void testGetCurrentQuantity() throws Exception {
    String name = "red heart super saver";
    MaterialCategory yarnCategory = new MaterialCategory("yarn", "yards");
    MaterialTemplate template = new MaterialTemplate(name, yarnCategory, 360, 2.99);
    Material ballOfYarn = new Material(template, "red");

    assertEquals(360, ballOfYarn.getCurrentQuantity());
  }

  @Test
  public void testSetCurrentQuantity() throws Exception {
    MaterialCategory yarnCategory = new MaterialCategory("yarn", "yards");
    MaterialTemplate template = new MaterialTemplate("red heart super saver", yarnCategory, 360, 2.99);
    Material ballOfYarn = new Material(template, "red");
    ballOfYarn.setCurrentQuantity(300);

    assertEquals(300, ballOfYarn.getCurrentQuantity());
  }

  @Test
  public void testGetPartialCost() throws Exception {
    MaterialCategory yarnCategory = new MaterialCategory("yarn", "yards");
    MaterialTemplate template = new MaterialTemplate("red heart super saver", yarnCategory, 300, 3.00);
    Material ballOfYarn = new Material(template, "red");

    assertEquals(1.00, ballOfYarn.getPartialCost(100), .001);
  }
}
