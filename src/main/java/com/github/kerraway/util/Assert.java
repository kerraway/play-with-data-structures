package com.github.kerraway.util;

import java.util.Collection;
import java.util.Map;

/**
 * @author 小柯
 * @date 2018/11/26
 */
public class Assert {

  public static void isTrue(boolean expression, String message) {
    if (!expression) {
      throw new IllegalArgumentException(message);
    }
  }

  public static void isFalse(boolean expression, String message) {
    if (expression) {
      throw new IllegalArgumentException(message);
    }
  }

  public static void isNull(Object obj) {
    isNull(obj, "the obj argument must be null.");
  }

  public static void isNull(Object obj, String message) {
    if (obj != null) {
      throw new IllegalArgumentException(message);
    }
  }

  public static void notNull(Object obj) {
    notNull(obj, "the obj argument must not be null.");
  }

  public static void notNull(Object obj, String message) {
    if (obj == null) {
      throw new IllegalArgumentException(message);
    }
  }

  public static void notBlank(String text, String message) {
    if (text == null || text.trim().length() == 0) {
      throw new IllegalArgumentException(message);
    }
  }

  public static void notEmpty(String text, String message) {
    if (text == null || text.length() == 0) {
      throw new IllegalArgumentException(text);
    }
  }

  public static void notEmpty(Object[] array, String message) {
    if (array == null || array.length == 0) {
      throw new IllegalArgumentException(message);
    }
  }

  public static void notEmpty(Collection<?> collection, String message) {
    if (collection == null || collection.size() == 0) {
      throw new IllegalArgumentException(message);
    }
  }

  public static void notEmpty(Map<?, ?> map, String message) {
    if (map == null || map.size() == 0) {
      throw new IllegalArgumentException(message);
    }
  }

  public static void isInstanceOf(Class<?> type, Object obj, String message) {
    notNull(type, "type must not be null.");
    if (!type.isInstance(obj)) {
      throw new IllegalArgumentException(message);
    }
  }

  public static void isAssignable(Class<?> superType, Class<?> subType, String message) {
    notNull(superType, "superType must not be null.");
    if (subType == null || !superType.isAssignableFrom(subType)) {
      throw new IllegalArgumentException(message);
    }
  }

  private Assert() {
  }
}
