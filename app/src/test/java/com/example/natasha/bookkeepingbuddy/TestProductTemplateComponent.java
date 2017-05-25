package com.example.natasha.bookkeepingbuddy;

import com.example.natasha.bookkeepingbuddy.model.Material;
import com.example.natasha.bookkeepingbuddy.model.MaterialCategory;
import com.example.natasha.bookkeepingbuddy.model.MaterialTemplate;
import com.example.natasha.bookkeepingbuddy.model.ProductTemplateComponent;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Natasha on 5/10/2017.
 */

public class TestProductTemplateComponent {
  @Test
  public void testConstructor() throws Exception {
    MaterialCategory yarnCategory = new MaterialCategory("yarn", "yards");
    ProductTemplateComponent component = new ProductTemplateComponent(60, yarnCategory);

    assertNotNull(component);
  }


  @Test
  public void testGetQuantityNeeded() throws Exception {
    MaterialCategory yarnCategory = new MaterialCategory("yarn", "yards");
    ProductTemplateComponent component = new ProductTemplateComponent(60, yarnCategory);

    assertEquals(60, component.getQuantityNeeded());

  }

  @Test
  public void testSetQuantityNeeded() throws Exception {
    MaterialCategory yarnCategory = new MaterialCategory("yarn", "yards");
    ProductTemplateComponent component = new ProductTemplateComponent(60, yarnCategory);
    component.setQuantityNeeded(75);

    assertEquals(75, component.getQuantityNeeded());

  }

  @Test
  public void testGetCategory() throws Exception {
    MaterialCategory yarnCategory = new MaterialCategory("yarn", "yards");
    ProductTemplateComponent component = new ProductTemplateComponent(60, yarnCategory);

    assertEquals(yarnCategory, component.getCategory());
  }

  @Test
  public void testSetCategory() throws Exception {
    MaterialCategory yarnCategory = new MaterialCategory("yarn", "yards");
    ProductTemplateComponent component = new ProductTemplateComponent(60, yarnCategory);
    MaterialCategory threadCategory = new MaterialCategory("thread", "yards");

    component.setCategory(threadCategory);

    assertEquals(threadCategory, component.getCategory());
  }


}
