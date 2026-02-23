package org.dsl.context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.dsl.ast.ContextNode;
import org.dsl.operator.OperatorType;
import org.jspecify.annotations.NonNull;

public final class ContextBuilder implements ContextStart, ContextEnd {

  private final List<ContextNode> contextNodeList = new ArrayList<>();

  @Override
  public void endContext() {

  }

  @Override
  public ContextEnd context(@NonNull final String context) {
    contextNodeList.add(new ContextNode(context, null));
    return this;
  }

  @Override
  public ContextStart and() {
    attachOperatorToPrevious(OperatorType.AND);
    return this;
  }


  @Override
  public ContextStart or() {
    attachOperatorToPrevious(OperatorType.OR);
    return this;
  }

  public List<ContextNode> build() {
    return Collections.unmodifiableList(contextNodeList);
  }

  private void attachOperatorToPrevious(@NonNull final OperatorType operator) {
    if(contextNodeList.isEmpty()) {
      throw new IllegalArgumentException("Cannot apply operator without preceding context");
    }

    final int lastIndex = contextNodeList.size() - 1;
    final ContextNode previous = contextNodeList.get(lastIndex);

    contextNodeList.set(lastIndex, new ContextNode(previous.getContext(), operator));
  }
}
