package org.dsl.visitor;

import org.dsl.ast.ActionNode;
import org.dsl.ast.ContextNode;
import org.dsl.ast.OutputFormatNode;
import org.dsl.ast.RoleIdentityNode;
import org.dsl.ast.RoleTitleNode;
import org.dsl.ast.StepNode;
import org.jspecify.annotations.NonNull;

public interface Render<R> {

  void visit(@NonNull final RoleTitleNode node);

  void visit(@NonNull final RoleIdentityNode node);

  void visit(@NonNull final ActionNode node);

  void visit(@NonNull final ContextNode node);

  void visit(@NonNull final StepNode node);

  void visit(@NonNull final OutputFormatNode node);

  R getResult();

}
