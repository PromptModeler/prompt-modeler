package org.dsl.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.dsl.Expression;
import org.dsl.action.ActionBuilder;
import org.dsl.action.ActionStart;
import org.dsl.ast.ActionNode;
import org.dsl.ast.ContextNode;
import org.dsl.ast.OutputFormatNode;
import org.dsl.ast.RoleIdentityNode;
import org.dsl.ast.RoleTitleNode;
import org.dsl.ast.StepNode;
import org.dsl.context.ContextBuilder;
import org.dsl.context.ContextStart;
import org.dsl.core.AfterActionExpression;
import org.dsl.core.AfterContextExpression;
import org.dsl.core.AfterStepExpression;
import org.dsl.core.RoleIdentityExpression;
import org.dsl.core.RoleTitleExpression;
import org.dsl.core.StartExpression;
import org.dsl.core.builder.OutputFormatBuilder;
import org.dsl.core.builder.RoleIdentityBuilder;
import org.dsl.core.builder.RoleTitleBuilder;
import org.dsl.output.OutputFormatEnd;
import org.dsl.output.OutputFormatStart;
import org.dsl.step.StepBuilder;
import org.dsl.step.StepStart;
import org.dsl.util.RoleTitleType;
import org.dsl.visitor.Render;
import org.jspecify.annotations.NonNull;

public final class InternalBuilder implements
    StartExpression,
    RoleTitleExpression,
    RoleIdentityExpression,
    AfterActionExpression,
    AfterContextExpression,
    AfterStepExpression,
    OutputFormatStart,
    OutputFormatEnd {

  private RoleTitleNode roleTitleNode;
  private RoleIdentityNode roleIdentityNode;

  private final List<ActionNode> actionNodeList = new ArrayList<>();
  private final List<ContextNode> contextNodeList = new ArrayList<>();
  private final List<StepNode> stepNodeList = new ArrayList<>();
  private final List<OutputFormatNode> outputFormatNodeList = new ArrayList<>();

  @Override
  public AfterContextExpression beginContext(@NonNull final Consumer<ContextStart> consumer) {
    final ContextBuilder builder = new ContextBuilder();
    consumer.accept(builder);
    contextNodeList.addAll(builder.build());
    return this;
  }

  @Override
  public AfterStepExpression beginStep(@NonNull final Consumer<StepStart> consumer) {
    final StepBuilder builder = new StepBuilder();
    consumer.accept(builder);
    stepNodeList.addAll(builder.build());
    return this;
  }

  @Override
  public OutputFormatEnd outputFormat(@NonNull final String outputFormat) {
    final OutputFormatBuilder builder = new OutputFormatBuilder(outputFormat);
    outputFormatNodeList.add(builder.build());
    return this;
  }

  @Override
  public AfterActionExpression beginAction(@NonNull final Consumer<ActionStart> consumer) {
    final ActionBuilder builder = new ActionBuilder();
    consumer.accept(builder);
    actionNodeList.addAll(builder.build());
    return this;
  }

  @Override
  public RoleIdentityExpression roleIdentity(@NonNull final String value) {
    final RoleIdentityBuilder builder = new RoleIdentityBuilder(value);
    this.roleIdentityNode = builder.build();
    return this;
  }

  @Override
  public RoleTitleExpression roleTitle(@NonNull final RoleTitleType value) {
    final RoleTitleBuilder builder = new RoleTitleBuilder(value);
    this.roleTitleNode = builder.build();
    return this;
  }

  @Override
  public Expression build() {
    return this;
  }

  @Override
  public OutputFormatStart and() {
    return this;
  }

  @Override
  public OutputFormatStart or() {
    return this;
  }

  @Override
  public <R> R accept(@NonNull final Render<R> render) {
    roleTitleNode.accept(render);
    roleIdentityNode.accept(render);
    actionNodeList.forEach((node) -> node.accept(render));
    contextNodeList.forEach((node) -> node.accept(render));
    stepNodeList.forEach((node) -> node.accept(render));
    outputFormatNodeList.forEach((node) -> node.accept(render));

    return render.getResult();
  }
}
