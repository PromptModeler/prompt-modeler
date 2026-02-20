package org.dsl.step;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.dsl.ast.StepNode;
import org.dsl.operator.OperatorType;
import org.jspecify.annotations.NonNull;

public final class StepBuilder implements StepStart, StepEnd {

  private final List<StepNode> stepNodeList = new ArrayList<>();

  private OperatorType operator;

  @Override
  public void endStep() {

  }

  @Override
  public StepStart and() {
    return this;
  }

  @Override
  public StepStart or() {
    return this;
  }

  @Override
  public StepEnd step(@NonNull final String value) {
    stepNodeList.add(new StepNode(value, operator));
    return this;
  }

  public List<StepNode> build() {
    return Collections.unmodifiableList(stepNodeList);
  }
}
