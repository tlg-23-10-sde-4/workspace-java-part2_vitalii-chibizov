/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.catalog;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import com.entertainment.Television;

public class Catalog {
  private static final Collection<Television> catalog = new ArrayList<>(30);

  private Catalog() {
  }

  public static Collection<Television> findByBrand(String brand) {
    Collection<Television> result = new ArrayList<>();
    for (Television tv : catalog) {
      if (tv.getBrand().equals(brand)) {
        result.add(tv);
      }
    }
    return result;
  }

  public static Map<String,Collection<Television>> findByBrands(String... brands) {
    Map<String,Collection<Television>> result = new HashMap<>();

    for (String brand : brands) {
      Collection<Television> tvs = findByBrand(brand);
      result.put(brand, tvs);
    }
    return result;
  }

  public static Collection<Television> getInventory() {
    //  return catalog;
    return Collections.unmodifiableCollection(catalog);
  }

  static {
    catalog.add(new Television("Zenith",  0));
    catalog.add(new Television("Sony",    4));
    catalog.add(new Television("Sony",    50));
    catalog.add(new Television("Zenith",  33));
    catalog.add(new Television("RCA",     50));
    catalog.add(new Television("Zenith",  86));
    catalog.add(new Television("Hitachi", 13));
    catalog.add(new Television("Hitachi", 40));
    catalog.add(new Television("Zenith",  46));
    catalog.add(new Television("RCA",     50)); //  dup
    catalog.add(new Television("Sony",    94)); //  the loudest
    catalog.add(new Television("RCA",     50)); //  dup
    catalog.add(new Television("Sony",    50)); //  dup
    catalog.add(new Television("Hitachi", 50));
    catalog.add(new Television("Zenith",  37));
    catalog.add(new Television("RCA",     31));
    catalog.add(new Television("Sony",    87));
    catalog.add(new Television("Hitachi", 39));
    catalog.add(new Television("Zenith",  27));
    catalog.add(new Television("Zenith",  12));
    catalog.add(new Television("RCA",     10));
    catalog.add(new Television("Hitachi", 50)); //  dup
    catalog.add(new Television("RCA",     4));
    catalog.add(new Television("RCA",     50)); //  dup
    catalog.add(new Television("RCA",     50)); //  dup
    catalog.add(new Television("Sony",    28));
    catalog.add(new Television("Zenith",  50));
    catalog.add(new Television("Zenith",  77));
    catalog.add(new Television("Sony",    22));
    catalog.add(new Television("RCA",     50)); //  dup
  }
}
