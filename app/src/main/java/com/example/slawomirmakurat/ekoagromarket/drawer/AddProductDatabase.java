package com.example.slawomirmakurat.ekoagromarket.drawer;

import com.example.slawomirmakurat.ekoagromarket.model.POJO.POJO.AddProduct;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by slawomir.makurat on 2017-04-03.
 */

class AddProductDatabase {

    private static List<AddProduct> categories = new ArrayList<>();

    public static List<AddProduct> getCategories() {
        return categories;
    }

  public static void addProduct(AddProduct category) {
      categories.add(category);
  }
}
