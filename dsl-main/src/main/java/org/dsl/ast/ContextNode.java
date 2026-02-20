package org.dsl.ast;

import org.dsl.operator.OperatorType;
import org.dsl.visitor.Render;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public final class ContextNode implements Node {

  private final String context;
  private final OperatorType operator;

  public ContextNode(@NonNull final String context, @Nullable final OperatorType operator) {
    this.context = context;
    this.operator = operator;
  }

  public String getContext() {
    return context;
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
