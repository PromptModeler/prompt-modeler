package org.dsl.step;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.dsl.ast.StepNode;
import org.dsl.operator.OperatorType;
import org.jspecify.annotations.NonNull;

public final class StepBuilder implements StepStart, StepEnd {

  private final List<StepNode> stepNodeList = new ArrayList<>();

  @Override
  public void endStep() {

  }

  @Override
  public StepStart and() {
    attachOperatorToPreviousNode(OperatorType.AND);
    return this;
  }

  @Override
  public StepStart or() {
    attachOperatorToPreviousNode(OperatorType.OR);
    return this;
  }

  @Override
  public StepEnd step(@NonNull final String value) {
    stepNodeList.add(new StepNode(value, null));
    return this;
  }

  public List<StepNode> build() {
    return Collections.unmodifiableList(stepNodeList);
  }

  private void attachOperatorToPreviousNode(@NonNull final OperatorType operator) {
    if(stepNodeList.isEmpty()) {
      throw new IllegalArgumentException("Cannot apply step without a preceding step");
    }

    final int lastIndex = stepNodeList.size() - 1;
    final StepNode previous = stepNodeList.get(lastIndex);

    stepNodeList.set(lastIndex, new StepNode(previous.getStep(), operator));
  }
}
