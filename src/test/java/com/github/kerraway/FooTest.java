package com.github.kerraway;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author 小柯
 * @date 2018/11/21
 */
public class FooTest {

  @Test
  public void say() {
    new Foo().say();

    assertNotNull(new Foo());
  }
}