package org.dsl.ast;

import org.dsl.operator.OperatorType;
import org.dsl.visitor.Render;
import org.jspecify.annotations.NonNull;

public final class StepNode implements Node {

  private final String step;
  private final OperatorType operator;

  public StepNode(@NonNull final String step, @NonNull final OperatorType operator) {
    this.step = step;
    this.operator = operator;
  }

  public String getStep() {
    return step;
  }

  public OperatorType getOperator() {
    return operator;
  }

  @Override
  public <R> R accept(@NonNull final Render<R> render) {
    render.visit(this);
    return render.getResult();
  }
}
