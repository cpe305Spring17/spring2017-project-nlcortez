package com.example.natasha.bookkeepingbuddy;

import com.example.natasha.bookkeepingbuddy.model.MaterialCategory;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Natasha on 5/10/2017.
 */

public class TestMaterialCategory {
  @Test
  public void constructor_isNotNull() throws Exception {
    MaterialCategory category = new MaterialCategory("yarn", "yards");

    assertNotNull(category);
  }


}
