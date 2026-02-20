package org.dsl.util;

public enum ModalityType {
  MUST,
  MUST_NOT,
  SHALL,
  SHALL_NOT,
  SHOULD,
  SHOULD_NOT,
  MAY,
  MAY_NOT,
  MIGHT,
  MIGHT_NOT;

  public String render() {
    return name().toLowerCase().replace('_', ' ');
  }
}
