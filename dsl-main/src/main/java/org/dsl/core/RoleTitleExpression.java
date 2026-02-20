package org.dsl.core;

import org.dsl.Expression;
import org.jspecify.annotations.NonNull;

public interface RoleTitleExpression extends Expression {

  RoleIdentityExpression roleIdentity(@NonNull final String value);

}
