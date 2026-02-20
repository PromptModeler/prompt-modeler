package org.dsl.core;

import org.dsl.Expression;
import org.dsl.output.OutputFormatEnd;
import org.jspecify.annotations.NonNull;

public interface AfterStepExpression extends Expression {

  OutputFormatEnd outputFormat(@NonNull final String outputFormat);

}
