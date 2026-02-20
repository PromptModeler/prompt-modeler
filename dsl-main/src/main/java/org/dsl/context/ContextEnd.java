package org.dsl.context;

import org.dsl.operator.LogicalOperator;

public sealed interface ContextEnd extends LogicalOperator<ContextStart> permits ContextBuilder {

  void endContext();

}
