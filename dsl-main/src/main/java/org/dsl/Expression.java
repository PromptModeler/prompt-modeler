package org.dsl;

import org.dsl.visitor.Render;
import org.jspecify.annotations.NonNull;

public interface Expression {

  <R> R accept(@NonNull final Render<R> render);

}
