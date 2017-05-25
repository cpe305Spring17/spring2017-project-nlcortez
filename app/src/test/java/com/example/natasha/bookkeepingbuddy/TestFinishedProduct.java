package com.example.natasha.bookkeepingbuddy;

import com.example.natasha.bookkeepingbuddy.model.FinishedProduct;
import com.example.natasha.bookkeepingbuddy.model.Material;
import com.example.natasha.bookkeepingbuddy.model.MaterialCategory;
import com.example.natasha.bookkeepingbuddy.model.MaterialTemplate;
import com.example.natasha.bookkeepingbuddy.model.ProductTemplate;
import com.example.natasha.bookkeepingbuddy.model.ProductTemplateComponent;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Natasha on 5/24/2017.
 */

public class TestFinishedProduct {
  @Test
  public void testConstructor() throws Exception {
    ProductTemplate template = new ProductTemplate("small bear", 18.50, new ArrayList<ProductTemplateComponent>());
    FinishedProduct product = new FinishedProduct(1.05, template, new ArrayList<Material>());
    assertNotNull(template);
  }

  //UPDATE WHEN getMaterialsCost() IS IMPLEMENTED
  @Test
  public void testGetMaterialsCost() throws Exception {
    ProductTemplate template = new ProductTemplate("small bear", 18.50, new ArrayList<ProductTemplateComponent>());
    FinishedProduct product = new FinishedProduct(1.05, template, new ArrayList<Material>());

    assertEquals(0.0, product.getMaterialsCost(), 0.001);
  }

  @Test
  public void testSetMaterialsCost() throws Exception {
    ProductTemplate template = new ProductTemplate("small bear", 18.50, new ArrayList<ProductTemplateComponent>());
    FinishedProduct product = new FinishedProduct(1.05, template, new ArrayList<Material>());

    product.setMaterialsCost(1.50);

    assertEquals(1.50, product.getMaterialsCost(), 0.001);
  }

  @Test
  public void testGetMaterialsUsed() throws Exception {
    ProductTemplate template = new ProductTemplate("small bear", 18.50, new ArrayList<ProductTemplateComponent>());
    ArrayList<Material> materials = new ArrayList<Material>();

    FinishedProduct product = new FinishedProduct(1.05, template, materials);

    assertEquals(materials, product.getMaterialsUsed());
  }

  @Test
  public void testAddMaterial() throws Exception {
    ProductTemplate prodTemplate = new ProductTemplate("small bear", 18.50, new ArrayList<ProductTemplateComponent>());
    FinishedProduct product = new FinishedProduct(1.05, prodTemplate, new ArrayList<Material>());
    MaterialTemplate matTemplate = new MaterialTemplate("red heart super saver", new MaterialCategory("yarn", "yards"), 360, 2.99);
    Material ballOfYarn = new Material(matTemplate);

    product.addMaterial(ballOfYarn);

    assertTrue(product.getMaterialsUsed().contains(ballOfYarn));
  }

  @Test
  public void testRemoveMaterial() throws Exception {
    ProductTemplate prodTemplate = new ProductTemplate("small bear", 18.50, new ArrayList<ProductTemplateComponent>());
    MaterialTemplate matTemplate = new MaterialTemplate("red heart super saver", new MaterialCategory("yarn", "yards"), 360, 2.99);
    Material ballOfYarn = new Material(matTemplate);
    ArrayList<Material> materials = new ArrayList<Material>();

    materials.add(ballOfYarn);

    FinishedProduct product = new FinishedProduct(1.05, prodTemplate, materials);

    product.removeMaterial(ballOfYarn);

    assertFalse(product.getMaterialsUsed().contains(ballOfYarn));
  }

}
