package org.dsl.core;

import java.util.function.Consumer;
import org.dsl.Expression;
import org.dsl.step.StepStart;
import org.jspecify.annotations.NonNull;

public interface AfterContextExpression extends Expression {

  AfterStepExpression beginStep(@NonNull final Consumer<StepStart> consumer);

}
