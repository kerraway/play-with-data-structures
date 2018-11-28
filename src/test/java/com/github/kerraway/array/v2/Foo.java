package com.github.kerraway.array.v2;

/**
 * @author 小柯
 * @date 2018/11/28
 */
public class Foo {

  private Integer id;
  private String name;

  public Foo() {
  }

  public Foo(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Foo foo = (Foo) o;
    if (id != null ? !id.equals(foo.id) : foo.id != null) {
      return false;
    }
    return name != null ? name.equals(foo.name) : foo.name == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Foo{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
