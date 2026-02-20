package org.dsl.ast;

import org.dsl.visitor.Render;
import org.jspecify.annotations.NonNull;

public final class OutputFormatNode implements Node {

  private final String outputFormat;

  public OutputFormatNode(@NonNull final String outputFormat) {
    this.outputFormat = outputFormat;
  }

  public String getOutputFormat() {
    return outputFormat;
  }

  @Override
  public <R> R accept(@NonNull final Render<R> render) {
    render.visit(this);
    return render.getResult();
  }
}
