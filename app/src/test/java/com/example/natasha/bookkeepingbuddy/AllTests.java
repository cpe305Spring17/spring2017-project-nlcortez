package com.example.natasha.bookkeepingbuddy;

import com.example.natasha.bookkeepingbuddy.TestMaterial;
import com.example.natasha.bookkeepingbuddy.TestMaterialCategory;
import com.example.natasha.bookkeepingbuddy.TestMaterialTemplate;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestMaterial.class,
        TestMaterialCategory.class,
        TestMaterialTemplate.class,
        TestMaterial.class,
        TestProductTemplateComponent.class,
        TestProductTemplate.class,
        TestFinishedProduct.class
})
public class AllTests {
}