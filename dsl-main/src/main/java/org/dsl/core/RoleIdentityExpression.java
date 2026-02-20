package org.dsl.core;

import java.util.function.Consumer;
import org.dsl.Expression;
import org.dsl.action.ActionStart;
import org.jspecify.annotations.NonNull;

public interface RoleIdentityExpression extends Expression {

  AfterActionExpression beginAction(@NonNull final Consumer<ActionStart> consumer);

}
