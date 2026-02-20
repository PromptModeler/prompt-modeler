package org.dsl.core.builder;

import org.dsl.ast.RoleIdentityNode;
import org.jspecify.annotations.NonNull;

public final class RoleIdentityBuilder {

  private final String value;

  public RoleIdentityBuilder(@NonNull final String value) {
    this.value = value;
  }

  public RoleIdentityNode build() {
    return new RoleIdentityNode(value);
  }
}
