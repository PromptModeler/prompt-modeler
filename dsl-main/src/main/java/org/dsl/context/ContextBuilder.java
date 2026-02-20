package org.dsl.context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.dsl.ast.ContextNode;
import org.dsl.operator.OperatorType;
import org.jspecify.annotations.NonNull;

public final class ContextBuilder implements ContextStart, ContextEnd {

  private final List<ContextNode> contextNodeList = new ArrayList<>();

  private OperatorType operator;

  @Override
  public void endContext() {

  }

  @Override
  public ContextEnd context(@NonNull final String context) {
    contextNodeList.add(new ContextNode(context, operator));
    return this;
  }

  @Override
  public ContextStart and() {
    return this;
  }

  @Override
  public ContextStart or() {
    return this;
  }

  public List<ContextNode> build() {
    return Collections.unmodifiableList(contextNodeList);
  }
}
