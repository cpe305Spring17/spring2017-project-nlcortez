package com.example.natasha.bookkeepingbuddy;

import com.example.natasha.bookkeepingbuddy.model.MaterialCategory;
import com.example.natasha.bookkeepingbuddy.model.ProductTemplate;
import com.example.natasha.bookkeepingbuddy.model.ProductTemplateComponent;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Natasha on 5/24/2017.
 */

public class TestProductTemplate {
  @Test
  public void testConstructor() throws Exception {
    ArrayList<ProductTemplateComponent> materialsNeeded = new ArrayList<ProductTemplateComponent>();

    ProductTemplate template = new ProductTemplate("small bear", 18.50, new ArrayList<ProductTemplateComponent>());

    assertNotNull(template);
  }

  @Test
  public void testConstructorWithId() throws Exception {
    ArrayList<ProductTemplateComponent> materialsNeeded = new ArrayList<ProductTemplateComponent>();

    ProductTemplate template = new ProductTemplate(3, "small bear", 18.50, new ArrayList<ProductTemplateComponent>());

    assertNotNull(template);
  }


  @Test
  public void testGetProductName() throws Exception {
    ProductTemplate template = new ProductTemplate("small bear", 18.50, new ArrayList<ProductTemplateComponent>());

    assertEquals("small bear", template.getProductName());
  }

  @Test
  public void testSetProductName() throws Exception {
    ProductTemplate template = new ProductTemplate("small bear", 18.50, new ArrayList<ProductTemplateComponent>());
    template.setProductName("medium bear");

    assertEquals("medium bear", template.getProductName());
  }

  @Test
  public void testGetPrice() throws Exception {
    ProductTemplate template = new ProductTemplate("small bear", 18.50, new ArrayList<ProductTemplateComponent>());

    assertEquals(18.50, template.getPrice(), 0.001);
  }

  @Test
  public void testSetPrice() throws Exception {
    ProductTemplate template = new ProductTemplate("small bear", 18.50, new ArrayList<ProductTemplateComponent>());
    template.setPrice(19.00);

    assertEquals(19.00, template.getPrice(), 0.001);
  }

  @Test
  public void testGetId() throws Exception {
    ProductTemplate template = new ProductTemplate(6, "small bear", 18.50, new ArrayList<ProductTemplateComponent>());

    assertEquals(6, template.getId());
  }

  @Test
  public void testSetId() throws Exception {
    ProductTemplate template = new ProductTemplate("small bear", 18.50, new ArrayList<ProductTemplateComponent>());
    template.setId(5);

    assertEquals(5, template.getId());
  }

  @Test
  public void testCategoriesText() throws Exception {
    MaterialCategory yarnCategory = new MaterialCategory("yarn", "yards");
    ProductTemplateComponent yarnComponent = new ProductTemplateComponent(60, yarnCategory);
    ArrayList<ProductTemplateComponent> materialsNeeded = new ArrayList<>();

    materialsNeeded.add(yarnComponent);

    ProductTemplate template = new ProductTemplate("small bear", 18.50, materialsNeeded);

    assertEquals("materials needed: yarn (60 yards) ", template.categoriesText());
  }

  @Test
  public void testGetArrayList() throws Exception {
    MaterialCategory yarnCategory = new MaterialCategory("yarn", "yards");
    ProductTemplateComponent yarnComponent = new ProductTemplateComponent(60, yarnCategory);
    ArrayList<ProductTemplateComponent> materialsNeeded = new ArrayList<ProductTemplateComponent>();

    materialsNeeded.add(yarnComponent);

    ProductTemplate template = new ProductTemplate("small bear", 18.50, materialsNeeded);

    assertEquals(materialsNeeded, template.getMaterialsNeeded());
  }

  @Test
  public void testAddComponent() throws Exception {
    MaterialCategory yarnCategory = new MaterialCategory("yarn", "yards");
    ProductTemplateComponent yarnComponent = new ProductTemplateComponent(60, yarnCategory);
    ProductTemplate template = new ProductTemplate("small bear", 18.50, new ArrayList<ProductTemplateComponent>());

    template.addComponent(yarnComponent);

    assertTrue(template.getMaterialsNeeded().contains(yarnComponent));
  }

  @Test
  public void testRemoveComponent() throws Exception {
    MaterialCategory yarnCategory = new MaterialCategory("yarn", "yards");
    ProductTemplateComponent yarnComponent = new ProductTemplateComponent(60, yarnCategory);
    ArrayList<ProductTemplateComponent> components = new ArrayList<ProductTemplateComponent>();

    components.add(yarnComponent);

    ProductTemplate template = new ProductTemplate("small bear", 18.50, components);
    template.removeComponent(yarnComponent);

    assertFalse(template.getMaterialsNeeded().contains(yarnComponent));
  }

}
