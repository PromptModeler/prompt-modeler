package org.dsl.core;

import org.dsl.Expression;
import org.dsl.util.RoleTitleType;
import org.jspecify.annotations.NonNull;

public interface StartExpression extends Expression {

  RoleTitleExpression roleTitle(@NonNull final RoleTitleType value);

}
