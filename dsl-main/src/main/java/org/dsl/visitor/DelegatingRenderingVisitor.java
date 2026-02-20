package org.dsl.visitor;

import org.dsl.ast.ActionNode;
import org.dsl.ast.ContextNode;
import org.dsl.ast.OutputFormatNode;
import org.dsl.ast.RoleIdentityNode;
import org.dsl.ast.RoleTitleNode;
import org.dsl.ast.StepNode;
import org.dsl.strategy.RenderingStrategy;
import org.jspecify.annotations.NonNull;

public final class DelegatingRenderingVisitor<R> implements Render<R> {

  private final RenderingStrategy<R> strategy;

  public DelegatingRenderingVisitor(@NonNull final RenderingStrategy<R> strategy) {
    this.strategy = strategy;
  }

  @Override
  public void visit(@NonNull final RoleTitleNode node) {
    strategy.roleTitle(node.getRoleTitle());
  }

  @Override
  public void visit(@NonNull final RoleIdentityNode node) {
    strategy.roleIdentity(node.getRoleIdentity());
  }

  @Override
  public void visit(@NonNull final ActionNode node) {
    strategy.action(node.getModality(), node.getAction(), node.getOperator());
  }

  @Override
  public void visit(@NonNull final ContextNode node) {
    strategy.context(node.getContext(), node.getOperator());
  }

  @Override
  public void visit(@NonNull final StepNode node) {
    strategy.step(node.getStep(), node.getOperator());
  }

  @Override
  public void visit(@NonNull final OutputFormatNode node) {
    strategy.outputFormat(node.getOutputFormat());
  }

  @Override
  public R getResult() {
    return strategy.result();
  }
}
