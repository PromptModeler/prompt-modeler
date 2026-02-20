package org.dsl.ast;

import org.dsl.visitor.Render;
import org.jspecify.annotations.NonNull;

public interface Node {

  <R> R accept(@NonNull final Render<R> render);

}
