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
  public void testOtherConstructor() throws Exception {
    MaterialCategory yarnCategory = new MaterialCategory("yarn", "yards");
    MaterialTemplate template = new MaterialTemplate("red heart super saver", yarnCategory, 360, 2.99);
    Material ballOfYarn = new Material(1, template, "red", 200, 360);

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

  @Test
  public void testGetRunningTotal() throws Exception {
    String name = "red heart super saver";
    MaterialCategory yarnCategory = new MaterialCategory("yarn", "yards");
    MaterialTemplate template = new MaterialTemplate(name, yarnCategory, 360, 2.99);
    Material ballOfYarn = new Material(template, "red");

    assertEquals(360, ballOfYarn.getRunningTotal());
  }

  @Test
  public void testSetRunningTotal() throws Exception {
    MaterialCategory yarnCategory = new MaterialCategory("yarn", "yards");
    MaterialTemplate template = new MaterialTemplate("red heart super saver", yarnCategory, 360, 2.99);
    Material ballOfYarn = new Material(template, "red");
    ballOfYarn.setRunningTotal(720);

    assertEquals(720, ballOfYarn.getRunningTotal());
  }

  @Test
  public void testAddAmount() throws Exception {
    String name = "red heart super saver";
    MaterialCategory yarnCategory = new MaterialCategory("yarn", "yards");
    MaterialTemplate template = new MaterialTemplate(name, yarnCategory, 360, 2.99);
    Material ballOfYarn = new Material(template, "red");
    ballOfYarn.addAmount(360);

    assertEquals(720, ballOfYarn.getCurrentQuantity());
  }

  @Test
  public void testGetId() throws Exception {
    MaterialCategory yarnCategory = new MaterialCategory("yarn", "yards");
    MaterialTemplate template = new MaterialTemplate("red heart super saver", yarnCategory, 360, 2.99);
    Material ballOfYarn = new Material(1, template, "red", 200, 360);

    assertEquals(1, ballOfYarn.getId());
  }

  @Test
  public void testSetId() throws Exception {
    MaterialCategory yarnCategory = new MaterialCategory("yarn", "yards");
    MaterialTemplate template = new MaterialTemplate("red heart super saver", yarnCategory, 360, 2.99);
    Material ballOfYarn = new Material(template, "red");
    ballOfYarn.setId(5);

    assertEquals(5, ballOfYarn.getId());
  }

}
