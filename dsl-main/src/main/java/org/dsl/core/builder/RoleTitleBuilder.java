package org.dsl.core.builder;

import org.dsl.ast.RoleTitleNode;
import org.dsl.util.RoleTitleType;
import org.jspecify.annotations.NonNull;

public final class RoleTitleBuilder {

  private final RoleTitleType value;

  public RoleTitleBuilder(@NonNull final RoleTitleType value) {
    this.value = value;
  }

  public RoleTitleNode build() {
    return new RoleTitleNode(value);
  }
}
