package org.dsl.builder;

import org.dsl.core.StartExpression;

public class ExpressionBuilder {

  public static StartExpression start() {
    return new InternalBuilder();
  }
}
