package com.example.slawomirmakurat.ekoagromarket.drawer;

//import com.example.slawomirmakurat.ekoagromarket.model.POJO.POJO.AddProduct;
import com.example.slawomirmakurat.ekoagromarket.model.POJO.POJO.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by slawomir.makurat on 2017-04-03.
 */

class AddProductDatabase {

    private static List<Category> categories = new ArrayList<>();

    public static List<Category> getCategories() {
        return categories;
    }

  public static void addProduct(Category category) {
      categories.add(category);
  }
}
