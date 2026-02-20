package org.dsl.step;

import org.jspecify.annotations.NonNull;

public sealed interface StepStart permits StepBuilder {

  StepEnd step(@NonNull final String value);

}
