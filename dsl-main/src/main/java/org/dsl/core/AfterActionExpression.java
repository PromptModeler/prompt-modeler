package org.dsl.core;

import java.util.function.Consumer;
import org.dsl.Expression;
import org.dsl.context.ContextStart;
import org.jspecify.annotations.NonNull;

public interface AfterActionExpression extends Expression {

  AfterContextExpression beginContext(@NonNull final Consumer<ContextStart> consumer);

}
