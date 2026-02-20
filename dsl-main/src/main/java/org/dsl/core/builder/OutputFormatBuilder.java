package org.dsl.core.builder;

import org.dsl.ast.OutputFormatNode;
import org.jspecify.annotations.NonNull;

public final class OutputFormatBuilder {

  private final String value;

  public OutputFormatBuilder(@NonNull final String value) {
    this.value = value;
  }

  public OutputFormatNode build() {
    return new OutputFormatNode(value);
  }
}
