package org.dsl.context;

import org.jspecify.annotations.NonNull;

public sealed interface ContextStart permits ContextBuilder {

  ContextEnd context(@NonNull final String context);

}
