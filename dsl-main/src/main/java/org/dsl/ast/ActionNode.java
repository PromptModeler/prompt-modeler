package org.dsl.ast;

import org.dsl.operator.OperatorType;
import org.dsl.visitor.Render;
import org.jspecify.annotations.NonNull;

public final class ActionNode implements Node {

  private final String modality;
  private final String action;
  private final OperatorType operator;

  public ActionNode(@NonNull final String modality, @NonNull final String action, @NonNull final OperatorType operator) {
    this.modality = modality;
    this.action = action;
    this.operator = operator;
  }

  public String getModality() {
    return modality;
  }

  public String getAction() {
    return action;
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
